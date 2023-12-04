package uniandes.edu.co.hoteles.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.hoteles.document.UsuarioDocument;

@Repository
public interface UsuarioRepository extends MongoRepository<UsuarioDocument, String> {

    public UsuarioDocument findByNumeroDocumento(String numeroDocumento);
    
}
