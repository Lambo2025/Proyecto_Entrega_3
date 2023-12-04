package uniandes.edu.co.hoteles.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.hoteles.business.TipoHabitacionService;
import uniandes.edu.co.hoteles.document.TipoHabitacionDocument;
import uniandes.edu.co.hoteles.dto.TipoHabitacionDTO;
import uniandes.edu.co.hoteles.repository.TipoHabitacionRepository;

@Service
public class TipoHabitacionServiceImpl implements TipoHabitacionService {

    @Autowired
    private TipoHabitacionRepository repository;

    @Override
    public void createTipoHabitacion(TipoHabitacionDTO tipoHabitacion) {
        TipoHabitacionDocument tipohabitacionDocument = new TipoHabitacionDocument(UUID.randomUUID().toString(), tipoHabitacion.getDescripcion(), tipoHabitacion.getEstado());
        repository.insert(tipohabitacionDocument);
    }

    @Override
    public TipoHabitacionDTO updateTipoHabitacion(TipoHabitacionDTO tipoHabitacion) {
        Optional<TipoHabitacionDocument> sOptional = repository.findById(tipoHabitacion.getId());
        if (sOptional.isPresent()) {
            TipoHabitacionDocument tp = sOptional.get();
            tp.setDescripcion(tipoHabitacion.getDescripcion());
            tp.setEstado(tipoHabitacion.getEstado());
            repository.save(tp);
            return tipoHabitacion;
            
        } else {
            return null;
        }
    }

    @Override
    public String deleteTipoHabitacion(String idTipoHAbitacion) {
        Optional<TipoHabitacionDocument> tOptional = repository.findById(idTipoHAbitacion);
        if (tOptional.isPresent()) {
            repository.deleteById(idTipoHAbitacion);
            return idTipoHAbitacion;            
        } else {
            return null;
        }

    }

    private TipoHabitacionDTO entityToDTO(TipoHabitacionDocument thabitacion) {
        TipoHabitacionDTO dto = new TipoHabitacionDTO(thabitacion.getId(), thabitacion.getDescripcion(), thabitacion.getEstado());
        return dto;
    }

    @Override
    public List<TipoHabitacionDTO> findAll() {
        List<TipoHabitacionDTO> tipoHabitacionDTOs = new ArrayList<>();
        repository.findAll().forEach(s -> tipoHabitacionDTOs.add(entityToDTO(s)));
        return tipoHabitacionDTOs;
    }

}
