package uniandes.edu.co.hoteles.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uniandes.edu.co.hoteles.business.TipoServicioService;
import uniandes.edu.co.hoteles.dto.TipoServicioDTO;

@RestController
@RequestMapping("/tipoServicio")
public class TipoServicioAPI {

    // @Autowired
    // private TipoServicioService service;

    // @PostMapping
    // public ResponseEntity<Void> create(HttpServletRequest req,
    //         HttpServletResponse res,
    //         @RequestBody TipoServicioDTO tipoServicio) {

    //     try {
    //         service.create(tipoServicio);
    //         return new ResponseEntity<Void>(HttpStatus.CREATED);
    //     } catch (Exception e) {
    //         return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }

    // }

    // @PutMapping
    // public ResponseEntity<Void> update(HttpServletRequest req,
    //         HttpServletResponse res,
    //         @RequestBody TipoServicioDTO tipoServicio) {

    //     try {
    //         if (service.update(tipoServicio) != null) {
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

    //         if (service.delete(id) != null) {
    //             return new ResponseEntity<Void>(HttpStatus.OK);
    //         } else {
    //             return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    //         }

    //     } catch (Exception e) {
    //         return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }

    // }

}
