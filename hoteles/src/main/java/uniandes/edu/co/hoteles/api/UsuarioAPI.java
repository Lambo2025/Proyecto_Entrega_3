package uniandes.edu.co.hoteles.api;

import java.util.List;
import java.util.Set;

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
import uniandes.edu.co.hoteles.business.UsuarioService;
import uniandes.edu.co.hoteles.dto.TipoHabitacionDTO;
import uniandes.edu.co.hoteles.dto.UsuarioDTO;

@RestController
@RequestMapping("/usuario")
public class UsuarioAPI {

     @Autowired
     private UsuarioService service;

     @PostMapping
     public ResponseEntity<Void> create(HttpServletRequest req,
             HttpServletResponse res,
             @RequestBody UsuarioDTO usuario) {

         try {
             service.createUsuario(usuario);
             return new ResponseEntity<Void>(HttpStatus.CREATED);
         } catch (Exception e) {
             return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
         }

     }

     @PutMapping
     public ResponseEntity<Void> update(HttpServletRequest req,
             HttpServletResponse res,
             @RequestBody UsuarioDTO usuario) {

         try {
             if (service.updateUsuario(usuario) != null) {
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

             if (service.deleteUsuario(id) != null) {
                 return new ResponseEntity<Void>(HttpStatus.OK);
             } else {
                 return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
             }

         } catch (Exception e) {
             return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
         }

     }


     @GetMapping(value = "/all")
     public ResponseEntity<List<UsuarioDTO>> findAll(HttpServletRequest req,
             HttpServletResponse res) {

         try {

             List<UsuarioDTO> usuarios =  service.findAll();

             if (!usuarios.isEmpty()) {
                 return new ResponseEntity<List<UsuarioDTO>>(usuarios, HttpStatus.OK);
             } else {
                 return new ResponseEntity<List<UsuarioDTO>>(HttpStatus.NO_CONTENT);
             }

         } catch (Exception e) {
             return new ResponseEntity<List<UsuarioDTO>>(HttpStatus.INTERNAL_SERVER_ERROR);
         }

     }


     @GetMapping(value = "/excelentes/{year}")
     public ResponseEntity<Set<UsuarioDTO>> findExcellent(HttpServletRequest req,
             HttpServletResponse res,
             @PathVariable String year) {

         try {

             Set<UsuarioDTO> usuarios =  service.clientesExcelentes(year);

             if (!usuarios.isEmpty()) {
                 return new ResponseEntity<Set<UsuarioDTO>>(usuarios, HttpStatus.OK);
             } else {
                 return new ResponseEntity<Set<UsuarioDTO>>(HttpStatus.NO_CONTENT);
             }

         } catch (Exception e) {
             return new ResponseEntity<Set<UsuarioDTO>>(HttpStatus.INTERNAL_SERVER_ERROR);
         }

     }

}
