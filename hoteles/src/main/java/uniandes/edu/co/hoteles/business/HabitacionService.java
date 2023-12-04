package uniandes.edu.co.hoteles.business;

import java.util.List;

import org.springframework.stereotype.Service;

import uniandes.edu.co.hoteles.dto.HabitacionDTO;

@Service
public interface HabitacionService {

    public void create(HabitacionDTO habitacion);
    
    public HabitacionDTO update(HabitacionDTO habitacion);

    public String delete(String idhabitacion);

    public List<HabitacionDTO> findAll();
    
}
