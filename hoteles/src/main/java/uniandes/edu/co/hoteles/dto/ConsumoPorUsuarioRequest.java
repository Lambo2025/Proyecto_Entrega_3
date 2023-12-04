package uniandes.edu.co.hoteles.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConsumoPorUsuarioRequest {

    private String numeroDocumento;
    private String fechaInicial;
    private String fechaFinal;    
    
}
