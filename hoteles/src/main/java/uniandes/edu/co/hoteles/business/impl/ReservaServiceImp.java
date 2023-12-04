package uniandes.edu.co.hoteles.business.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.hoteles.business.ReservaService;
import uniandes.edu.co.hoteles.document.ConsumoDocument;
import uniandes.edu.co.hoteles.document.ReservaDocument;
import uniandes.edu.co.hoteles.document.ServicioDocument;
import uniandes.edu.co.hoteles.document.UsuarioDocument;
import uniandes.edu.co.hoteles.dto.ConsumoPorUsuarioRequest;
import uniandes.edu.co.hoteles.dto.ReservaDTO;
import uniandes.edu.co.hoteles.repository.ConsumoRepository;
import uniandes.edu.co.hoteles.repository.ReservaRepository;
import uniandes.edu.co.hoteles.repository.ServicioRepository;
import uniandes.edu.co.hoteles.repository.UsuarioRepository;

@Service
public class ReservaServiceImp implements ReservaService {

    private Double costo;

    @Autowired
    private ReservaRepository repository;

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private ConsumoRepository consumoRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private SimpleDateFormat sdfConsumo = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void createReserva(ReservaDTO reserva) {
        try {
            ReservaDocument reservaDocument = new ReservaDocument(UUID.randomUUID().toString(), sdf.parse(reserva.getCheckin()), sdf.parse(reserva.getCheckout()), reserva.getNum_personas(), reserva.getUsuarioId(), reserva.getPlanconsumoId(), reserva.getHabitacionId());
            repository.insert(reservaDocument);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    @Override
    public ReservaDTO updateReserva(ReservaDTO reserva) {
        Optional<ReservaDocument> sOptional = repository.findById(reserva.getId());
        if (sOptional.isPresent()) {
            
            try {
                ReservaDocument r = sOptional.get();
                r.setCheckin(sdf.parse(reserva.getCheckin()));
                r.setCheckout(sdf.parse(reserva.getCheckout()));
                r.setHabitacionId(reserva.getHabitacionId());
                r.setNum_personas(reserva.getNum_personas());
                r.setPlanconsumoId(reserva.getPlanconsumoId());
                r.setUsuarioId(reserva.getUsuarioId());
                repository.save(r);
            return reserva;
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }
            

        } else {
            return null;

        }
    }

    @Override
    public String deleteReserva(String idreserva) {
        Optional<ReservaDocument> rOptional = repository.findById(idreserva);
        if (rOptional.isPresent()){
            repository.deleteById(idreserva);
            return idreserva;
            
        } else {
            return null;
        }
    }

    @Override
    public List<ReservaDTO> findAll() {
        List<ReservaDTO> reservaDTOs = new ArrayList<>();
        repository.findAll().forEach(s -> reservaDTOs.add(entityToDTO(s)));
        return reservaDTOs;
    }

    private ReservaDTO entityToDTO(ReservaDocument reserva) {
        ReservaDTO dto = new ReservaDTO(reserva.getId(), sdf.format(reserva.getCheckin()), sdf.format(reserva.getCheckout()), reserva.getNum_personas(), reserva.getUsuarioId(), reserva.getPlanconsumoId(), reserva.getHabitacionId());
        return dto;
    }


    @Override
    public Double findBookingByUserDocument(ConsumoPorUsuarioRequest dto) {
        
        this.costo = 0.0;

        UsuarioDocument usuarioDocument = userRepository.findByNumeroDocumento(dto.getNumeroDocumento());
        List<ReservaDocument> reservas = repository.findByUsuarioId(usuarioDocument.getId());
        reservas.forEach(r -> { 
            List<ConsumoDocument> consumos;
            try {
                consumos = consumoRepository.findByReservaIdAndFechaRange(r.getId(), sdfConsumo.parse(dto.getFechaInicial()), sdfConsumo.parse(dto.getFechaFinal()));
                consumos.forEach(c -> { 
                Optional<ServicioDocument> oServ = servicioRepository.findById(c.getServicioId());
                if (oServ.isPresent()) {
                    costo += oServ.get().getCosto() * c.getCantidad();
                }
            });
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        });
        
        return costo;

    } 


    
}
