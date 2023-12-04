package uniandes.edu.co.hoteles.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.hoteles.business.HabitacionService;
import uniandes.edu.co.hoteles.document.HabitacionDocument;
import uniandes.edu.co.hoteles.dto.HabitacionDTO;
import uniandes.edu.co.hoteles.repository.HabitacionRepository;

@Service
public class HabitacionServiceImpl implements HabitacionService {

    @Autowired
    private HabitacionRepository repository;

    @Override
    public void create(HabitacionDTO habitacion) {

        HabitacionDocument habitacionDocument = new HabitacionDocument(UUID.randomUUID().toString(), habitacion.getCapacidad(),
                habitacion.getTelevision().equals(true) ? 1L : 0L, habitacion.getMinibar().equals(true) ? 1L : 0L,
                habitacion.getCafetera().equals(true) ? 1L : 0L, habitacion.getCostoNoche(), habitacion.getNumero(),
                habitacion.getTipoHabitacionId());
        repository.insert(habitacionDocument);

    }

    @Override
    public HabitacionDTO update(HabitacionDTO habitacion) {
        Optional<HabitacionDocument> sOptional = repository.findById(habitacion.getId());
       if (sOptional.isPresent()) {
           HabitacionDocument h = sOptional.get(); 
           h.setCafetera(habitacion.getCafetera().equals(true) ? 1L : 0L);
           h.setCapacidad(habitacion.getCapacidad());
           h.setCostoNoche(habitacion.getCostoNoche());
           h.setMinibar(habitacion.getMinibar().equals(true) ? 1L : 0L);
           h.setNumero(habitacion.getNumero());
           h.setTelevision(habitacion.getTelevision().equals(true) ? 1L : 0L);
           h.setTipoHabitacionId(habitacion.getTipoHabitacionId());
           repository.save(h);
           return habitacion;
       } else {
           return null;
       }

    }

    @Override
    public String delete(String idhabitacion) {
        Optional<HabitacionDocument> hOptional = repository.findById(idhabitacion);
        if (hOptional.isPresent()) {
            repository.deleteById(idhabitacion);
            return idhabitacion;

            
        } else {
            return null;
        }
    }


    private HabitacionDTO entityToDTO(HabitacionDocument habitacion) {
        HabitacionDTO dto = new HabitacionDTO(habitacion.getId(), habitacion.getCapacidad(), habitacion.getTelevision(), habitacion.getMinibar(), habitacion.getCafetera(), habitacion.getCostoNoche(), habitacion.getNumero(), habitacion.getTipoHabitacionId());
        return dto;
    }


    @Override
    public List<HabitacionDTO> findAll() {
        List<HabitacionDTO> habitacionDTOs = new ArrayList<>();
        repository.findAll().forEach(s -> habitacionDTOs.add(entityToDTO(s)));
        return habitacionDTOs;
    }



}
