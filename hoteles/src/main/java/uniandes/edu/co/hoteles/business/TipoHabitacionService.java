package uniandes.edu.co.hoteles.business;

import java.util.List;

import uniandes.edu.co.hoteles.dto.TipoHabitacionDTO;

public interface TipoHabitacionService {

    public void createTipoHabitacion(TipoHabitacionDTO tipoHabitacion);
    
    public TipoHabitacionDTO updateTipoHabitacion(TipoHabitacionDTO tipoHabitacion);

    public String deleteTipoHabitacion(String idTipoHAbitacion);

    public List<TipoHabitacionDTO> findAll();
    
}
