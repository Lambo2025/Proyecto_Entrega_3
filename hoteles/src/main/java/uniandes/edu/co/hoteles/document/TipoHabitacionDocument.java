package uniandes.edu.co.hoteles.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("TIPO_HABITACION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoHabitacionDocument {
    
    @Id
    private String id;
    private String descripcion;
    private Long estado;

}
