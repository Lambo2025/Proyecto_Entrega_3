package uniandes.edu.co.hoteles.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("CONSUMO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsumoDocument {
    
    @Id
    private String id;
    private String descripcion;
    private Long estado;
    private String reservaId;
    private String servicioId;
    private Long cantidad;
    private Date fecha;

}
