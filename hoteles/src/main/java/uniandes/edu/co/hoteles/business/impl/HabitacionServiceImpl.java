package uniandes.edu.co.hoteles.business.impl;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Long delete(Long idhabitacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
