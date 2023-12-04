package uniandes.edu.co.hoteles.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HabitacionDTO {

    private String id;
    private Long capacidad;
    private Long television;
    private Long minibar;
    private Long cafetera;
    private Double costoNoche;
    private String numero;
    private Long tipoHabitacionId;

    
}
