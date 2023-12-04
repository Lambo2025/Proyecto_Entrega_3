package uniandes.edu.co.hoteles.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("SERVICIO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicioDocument {
    
    @Id
    private String id;
    private String nombre;  
    private Long capacidad;
    private Double profundidad;
    private String horarioApertura;
    private String horarioCierre;
    private Long incluido;
    private Long maquinas;
    private String estilo;
    private Double duracion;
    private Double costo;
    private Long tipoServicio;

}
