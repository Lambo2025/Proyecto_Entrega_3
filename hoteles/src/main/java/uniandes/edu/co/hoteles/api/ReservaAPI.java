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
import uniandes.edu.co.hoteles.business.ReservaService;
import uniandes.edu.co.hoteles.dto.ConsumoPorUsuarioRequest;
import uniandes.edu.co.hoteles.dto.ReservaDTO;
import uniandes.edu.co.hoteles.dto.ServicioDTO;

@RestController
@RequestMapping("/reserva")
public class ReservaAPI {

     @Autowired
     private ReservaService service;

     @PostMapping
     public ResponseEntity<Void> create(HttpServletRequest req,
             HttpServletResponse res,
             @RequestBody ReservaDTO reserva) {

         try {
             service.createReserva(reserva);
             return new ResponseEntity<Void>(HttpStatus.CREATED);
         } catch (Exception e) {
             return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
         }

     }

     @PutMapping
     public ResponseEntity<Void> update(HttpServletRequest req,
             HttpServletResponse res,
             @RequestBody ReservaDTO reserva) {

         try {
             if (service.updateReserva(reserva) != null) {
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
             if (service.deleteReserva(id) != null) {
                 return new ResponseEntity<Void>(HttpStatus.OK);
             } else {
                 return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
             }

         } catch (Exception e) {
             return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
         }
     }

     @GetMapping(value = "/all")
     public ResponseEntity<List<ReservaDTO>> findAll(HttpServletRequest req,
             HttpServletResponse res) {

         try {

             List<ReservaDTO> reservas =  service.findAll();

             if (!reservas.isEmpty()) {
                 return new ResponseEntity<List<ReservaDTO>>(reservas, HttpStatus.OK);
             } else {
                 return new ResponseEntity<List<ReservaDTO>>(HttpStatus.NO_CONTENT);
             }

         } catch (Exception e) {
             return new ResponseEntity<List<ReservaDTO>>(HttpStatus.INTERNAL_SERVER_ERROR);
         }

     }


     /*@GetMapping(value = "/findByUser/{userDocument}")
     public ResponseEntity<List<ReservaDTO>> findByUser(HttpServletRequest req,
             HttpServletResponse res, @PathVariable String userDocument) {

         try {

             List<ReservaDTO> reservas =  service.findBookingByUserDocument(userDocument);

             if (!reservas.isEmpty()) {
                 return new ResponseEntity<List<ReservaDTO>>(reservas, HttpStatus.OK);
             } else {
                 return new ResponseEntity<List<ReservaDTO>>(HttpStatus.NO_CONTENT);
             }

         } catch (Exception e) {
             return new ResponseEntity<List<ReservaDTO>>(HttpStatus.INTERNAL_SERVER_ERROR);
         }

     }*/

    @PostMapping(value = "/consumesByUser")
     public ResponseEntity<Double> findConsumesByUser(HttpServletRequest req,
             HttpServletResponse res,
             @RequestBody ConsumoPorUsuarioRequest dto) {

         try {

             return new ResponseEntity<Double>( service.findBookingByUserDocument(dto), HttpStatus.OK);

         } catch (Exception e) {
            e.printStackTrace();
             return new ResponseEntity<Double>(HttpStatus.INTERNAL_SERVER_ERROR);
         }

     }


}
