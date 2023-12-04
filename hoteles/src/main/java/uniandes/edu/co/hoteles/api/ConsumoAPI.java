package uniandes.edu.co.hoteles.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uniandes.edu.co.hoteles.business.ConsumoService;
import uniandes.edu.co.hoteles.dto.ConsumoDTO;

@RestController
@RequestMapping("/consumo")
public class ConsumoAPI {

     @Autowired
     private ConsumoService service;

     @PostMapping
     public ResponseEntity<Void> create(HttpServletRequest req,
             HttpServletResponse res,
             @RequestBody ConsumoDTO consumo) {

         try {
             service.createConsumo(consumo);
             return new ResponseEntity<Void>(HttpStatus.CREATED);
         } catch (Exception e) {
             return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
         }

     }

    // @PutMapping
    // public ResponseEntity<Void> update(HttpServletRequest req,
    //         HttpServletResponse res,
    //         @RequestBody TipoPlanConsumoDTO tipoPlanConsumo) {

    //     try {
    //         if (service.updateTipoPlanConsumo(tipoPlanConsumo) != null) {
    //             return new ResponseEntity<Void>(HttpStatus.OK);
    //         } else {
    //             return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    //         }
    //     } catch (Exception e) {
    //         return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }

    // }

    // @DeleteMapping(value = "/{id}")
    // public ResponseEntity<Void> delete(HttpServletRequest req,
    //         HttpServletResponse res,
    //         @PathVariable Long id) {

    //     try {

    //         if (service.deleteTipoPlanConsumo(id) != null) {
    //             return new ResponseEntity<Void>(HttpStatus.OK);
    //         } else {
    //             return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    //         }

    //     } catch (Exception e) {
    //         return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }

    // }

}
