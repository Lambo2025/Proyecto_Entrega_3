package uniandes.edu.co.hoteles.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TipoHabitacionDTO {

    private String id;
    private String descripcion;
    private Long estado;
    
}
