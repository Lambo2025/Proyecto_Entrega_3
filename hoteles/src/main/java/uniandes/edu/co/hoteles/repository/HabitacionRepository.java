package uniandes.edu.co.hoteles.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.hoteles.document.HabitacionDocument;

@Repository
public interface HabitacionRepository extends MongoRepository<HabitacionDocument, String> {
    
}
