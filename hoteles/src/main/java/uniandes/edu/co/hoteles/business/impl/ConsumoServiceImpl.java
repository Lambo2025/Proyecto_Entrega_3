package uniandes.edu.co.hoteles.business.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.hoteles.business.ConsumoService;
import uniandes.edu.co.hoteles.document.ConsumoDocument;
import uniandes.edu.co.hoteles.dto.ConsumoDTO;
import uniandes.edu.co.hoteles.repository.ConsumoRepository;

@Service
public class ConsumoServiceImpl implements ConsumoService {

    @Autowired
    private ConsumoRepository repository;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    @Override
    public void createConsumo(ConsumoDTO consumo) {
        ConsumoDocument consumoDocument;
        try {
            consumoDocument = new ConsumoDocument(UUID.randomUUID().toString(), consumo.getDescripcion(), consumo.getEstado(), consumo.getReservaId(), consumo.getServicioId(), consumo.getCantidad(), sdf.parse(consumo.getFecha()));
            repository.insert(consumoDocument);

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    @Override
    public ConsumoDTO updateConsumo(ConsumoDTO Consumo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateConsumo'");
    }

    @Override
    public Long deleteConsumo(Long idConsumo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteConsumo'");
    }

    @Override
    public List<ConsumoDTO> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }



}
