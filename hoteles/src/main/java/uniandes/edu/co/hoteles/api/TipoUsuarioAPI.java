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
import uniandes.edu.co.hoteles.business.TipoUsuarioService;
import uniandes.edu.co.hoteles.dto.TipoUsuarioDTO;

@RestController
@RequestMapping("/tipoUsuario")
public class TipoUsuarioAPI {

    @Autowired
    private TipoUsuarioService service;

    @PostMapping
    public ResponseEntity<Void> create(HttpServletRequest req,
            HttpServletResponse res,
            @RequestBody TipoUsuarioDTO tipoUsuario) {

        try {
            service.createTipoUsuario(tipoUsuario);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping
    public ResponseEntity<Void> update(HttpServletRequest req,
            HttpServletResponse res,
            @RequestBody TipoUsuarioDTO tipoUsuario) {

        try {
            if (service.updateTipoUsuario(tipoUsuario) != null) {
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
            @PathVariable Long id) {

        try {

            if (service.deleteTipoUsuario(id) != null) {
                return new ResponseEntity<Void>(HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
