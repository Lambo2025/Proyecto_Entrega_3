package uniandes.edu.co.hoteles.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("RESERVA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDocument {
    
    @Id
    private String id;
    private Date checkin;
    private Date checkout;
    private Long num_personas;
    private String usuarioId;
    private Long planconsumoId;
    private Long habitacionId;

}
