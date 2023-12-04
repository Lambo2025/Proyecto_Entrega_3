package uniandes.edu.co.hoteles.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.hoteles.document.ReservaDocument;

@Repository
public interface ReservaRepository extends MongoRepository<ReservaDocument, String> {



    public List<ReservaDocument> findByUsuarioId(String usuarioId);

    public List<ReservaDocument> findByCheckinGreaterThanAndCheckoutLessThan(Date fechaInicio, Date fechaFin);

    /*@Query ( "{" +
    "$lookup: {" +
    "  from: 'USUARIO'," +
    "  localField: 'USUARIO_ID'," +
    "  foreignField: 'ID'," +
    "  as: 'usuario_info'" +
    "}," +
    "$unwind: '$usuario_info'," +
    "$match: {" +
    "  'usuario_info.NUMERO_DOCUMENTO': ?0" +
    "}," +
    "$project: {" +
    "  usuario_info: 0" +
    "}" +
    "}")

    public List<ReservaDocument> findBookingByUserDocument(String userDocument);*/

    


    
    
}
