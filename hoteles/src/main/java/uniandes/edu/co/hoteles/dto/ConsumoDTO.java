package uniandes.edu.co.hoteles.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConsumoDTO {

    private String id;
    private String descripcion;
    private Long estado;
    private String reservaId;
    private String servicioId;
    private Long cantidad;
    private String fecha;
    
}
