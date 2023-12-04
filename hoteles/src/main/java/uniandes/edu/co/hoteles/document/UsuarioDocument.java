package uniandes.edu.co.hoteles.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("USUARIO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDocument {
    
    @Id
    private String id;
    private Long rol;
    private String tipoDocumento;
    private String numeroDocumento;
    private String correo;
    private String nombre; 

}
