package uniandes.edu.co.hoteles.business;

import org.springframework.stereotype.Service;

import uniandes.edu.co.hoteles.dto.HabitacionDTO;

@Service
public interface HabitacionService {

    public void create(HabitacionDTO habitacion);
    
    public HabitacionDTO update(HabitacionDTO habitacion);

    public Long delete(Long idhabitacion);
    
}
