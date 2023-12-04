package uniandes.edu.co.hoteles.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.hoteles.document.ConsumoDocument;

@Repository
public interface ConsumoRepository extends MongoRepository<ConsumoDocument, String> {

    //public List<ConsumoDocument> findByReservaIdAndFechaGreaterThanAndFechaLessThan(String reservaId, Date fechaInicial, Date fechaFinal);
    
    @Query("{'reservaId': ?0, 'fecha': {'$gt': ?1, '$lt': ?2}}")
    List<ConsumoDocument> findByReservaIdAndFechaRange(String reservaId, Date fechaInicial, Date fechaFinal);
    
}
