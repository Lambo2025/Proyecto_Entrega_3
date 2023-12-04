package uniandes.edu.co.hoteles.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.hoteles.business.ServicioService;
import uniandes.edu.co.hoteles.business.UsuarioService;
import uniandes.edu.co.hoteles.document.ReservaDocument;
import uniandes.edu.co.hoteles.document.ServicioDocument;
import uniandes.edu.co.hoteles.dto.ServicioDTO;
import uniandes.edu.co.hoteles.repository.ReservaRepository;
import uniandes.edu.co.hoteles.repository.ServicioRepository;

@Service
public class ServicioServiceImp implements ServicioService {

    @Autowired
    private ServicioRepository repository;

    @Autowired
    private ReservaRepository reservaRepository;



    @Override
    public void createServicio(ServicioDTO servicio) {

        ServicioDocument servicioDocument = new ServicioDocument(UUID.randomUUID().toString(), servicio.getNombre(), servicio.getCapacidad(), servicio.getProfundidad(), servicio.getHorarioApertura(), servicio.getHorarioCierre(), servicio.getIncluido().equals(true) ? 1L : 0L, servicio.getMaquinas(), servicio.getEstilo(), servicio.getDuracion(), servicio.getCosto(), servicio.getTipoServicio());
        repository.insert(servicioDocument);
    }

    @Override
    public ServicioDTO updateServicio(ServicioDTO servicio) {
        Optional<ServicioDocument> sOptional = repository.findById(servicio.getId());
        if (sOptional.isPresent()) {
            ServicioDocument s = sOptional.get();
            s.setCapacidad(servicio.getCapacidad());
            s.setCosto(servicio.getCosto());
            s.setDuracion(servicio.getDuracion());
            s.setEstilo(servicio.getEstilo());
            s.setHorarioApertura(servicio.getHorarioApertura());
            s.setHorarioCierre(servicio.getHorarioCierre());
            s.setIncluido(servicio.getIncluido().equals(true) ? 1L : 0L);
            s.setMaquinas(servicio.getMaquinas());
            s.setNombre(servicio.getNombre());
            s.setProfundidad(servicio.getProfundidad());
            s.setTipoServicio(servicio.getTipoServicio());
            repository.save(s);
            return servicio;
        } else {
            return null;
        }

    } 

    

    @Override
    public String deleteServicio(String idServicio) {
        Optional<ServicioDocument> sOptional = repository.findById(idServicio);
        if (sOptional.isPresent()) {
            repository.deleteById(idServicio);
            return idServicio;
            
        } else {
            return null;
        }
        
    }


    private ServicioDTO entityToDTO(ServicioDocument servicio) {
       // ServicioDTO dto = new ServicioDTO(servicio.getId(), servicio.getNombre(), servicio.getCapacidad(), servicio.getProfundidad(), servicio.getHorarioApertura(), servicio.getHorarioCierre(), servicio.getIncluido(), servicio.getMaquinas(), servicio.getEstilo(), servicio.getDuracion(), servicio.getCosto(), servicio.getTipoServicio());
       // return dto;
       return null;
    }

    @Override
    public List<ServicioDTO> findAll() {

        List<ServicioDTO> servicioDTOs = new ArrayList<>();
        repository.findAll().forEach(s -> servicioDTOs.add(entityToDTO(s)));
        return servicioDTOs;
        
    }

}
