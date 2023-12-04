package uniandes.edu.co.hoteles.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uniandes.edu.co.hoteles.business.HabitacionService;
import uniandes.edu.co.hoteles.dto.HabitacionDTO;
import uniandes.edu.co.hoteles.dto.ReservaDTO;

@RestController
@RequestMapping("/habitacion")
public class HabitacionAPI {

    @Autowired
    private HabitacionService service;

    @PostMapping
    public ResponseEntity<Void> create(HttpServletRequest req,
            HttpServletResponse res,
            @RequestBody HabitacionDTO habitacion) {

        try {
            service.create(habitacion);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping
    public ResponseEntity<Void> update(HttpServletRequest req,
            HttpServletResponse res,
            @RequestBody HabitacionDTO habitacion) {

        try {
            if (service.update(habitacion) != null) {
                return new ResponseEntity<Void>(HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
 
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(HttpServletRequest req,
            HttpServletResponse res,
            @PathVariable String id) {

        try {

            if (service.delete(id) != null) {
                return new ResponseEntity<Void>(HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



    @GetMapping(value = "/all")
     public ResponseEntity<List<HabitacionDTO>> findAll(HttpServletRequest req,
             HttpServletResponse res) {

         try {

             List<HabitacionDTO> habitaciones =  service.findAll();

             if (!habitaciones.isEmpty()) {
                 return new ResponseEntity<List<HabitacionDTO>>(habitaciones, HttpStatus.OK);
             } else {
                 return new ResponseEntity<List<HabitacionDTO>>(HttpStatus.NO_CONTENT);
             }

         } catch (Exception e) {
             return new ResponseEntity<List<HabitacionDTO>>(HttpStatus.INTERNAL_SERVER_ERROR);
         }

     }

}