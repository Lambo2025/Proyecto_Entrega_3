package uniandes.edu.co.hoteles.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.hoteles.document.ReservaDocument;
import uniandes.edu.co.hoteles.document.ServicioDocument;

@Repository
public interface ServicioRepository extends MongoRepository<ServicioDocument, String> {

    //List<ServicioDocument> findByUsuarioId(String usuarioId);
    
}
