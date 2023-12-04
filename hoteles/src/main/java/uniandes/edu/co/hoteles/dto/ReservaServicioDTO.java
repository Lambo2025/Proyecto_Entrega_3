package uniandes.edu.co.hoteles.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReservaServicioDTO {

    private String id;
    private Long idReserva;
    private Long idServicio;
    private String Fecha;    
    
}
