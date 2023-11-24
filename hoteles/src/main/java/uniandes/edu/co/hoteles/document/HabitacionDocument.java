package uniandes.edu.co.hoteles.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("HABITACION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HabitacionDocument {
    
    @Id
    private String id;
    private Long capacidad;
    private Long television;
    private Long minibar;
    private Long cafetera;
    private Double costoNoche;
    private String numero;
    private Long tipoHabitacionId;

}
