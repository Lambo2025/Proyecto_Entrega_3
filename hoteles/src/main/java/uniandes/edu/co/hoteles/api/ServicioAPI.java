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
import uniandes.edu.co.hoteles.business.ServicioService;
import uniandes.edu.co.hoteles.dto.ServicioDTO;

@RestController
@RequestMapping("/servicio")
public class ServicioAPI {

    // @Autowired
    // private ServicioService service;

    // @PostMapping
    // public ResponseEntity<Void> create(HttpServletRequest req,
    //         HttpServletResponse res,
    //         @RequestBody ServicioDTO servicio) {

    //     try {
    //         service.create(servicio);
    //         return new ResponseEntity<Void>(HttpStatus.CREATED);
    //     } catch (Exception e) {
    //         return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }

    // }

    // @PutMapping
    // public ResponseEntity<Void> update(HttpServletRequest req,
    //         HttpServletResponse res,
    //         @RequestBody ServicioDTO servicio) {

    //     try {
    //         if (service.update(servicio) != null) {
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

    // @GetMapping(value = "/all")
    // public ResponseEntity<List<ServicioDTO>> findAll(HttpServletRequest req,
    //         HttpServletResponse res) {

    //     try {

    //         List<ServicioDTO> servicios =  service.findAll();

    //         if (!servicios.isEmpty()) {
    //             return new ResponseEntity<List<ServicioDTO>>( servicios, HttpStatus.OK);
    //         } else {
    //             return new ResponseEntity<List<ServicioDTO>>(HttpStatus.NO_CONTENT);
    //         }

    //     } catch (Exception e) {
    //         return new ResponseEntity<List<ServicioDTO>>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }

    // }

}
