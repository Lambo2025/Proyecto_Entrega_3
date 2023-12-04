package uniandes.edu.co.hoteles.business.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.hoteles.business.UsuarioService;
import uniandes.edu.co.hoteles.document.ReservaDocument;
import uniandes.edu.co.hoteles.document.UsuarioDocument;
import uniandes.edu.co.hoteles.dto.UsuarioDTO;
import uniandes.edu.co.hoteles.repository.ReservaRepository;
import uniandes.edu.co.hoteles.repository.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ReservaRepository reservaRepository;

    private Set<UsuarioDTO> usuariosExcelentes;

    @Override
    public void createUsuario(UsuarioDTO usuario) {
        UsuarioDocument usuarioDocument = new UsuarioDocument(UUID.randomUUID().toString(), usuario.getRol(),
                usuario.getTipoDocumento(), usuario.getNumeroDocumento(), usuario.getCorreo(), usuario.getNombre());
        repository.insert(usuarioDocument);
    }

    @Override
    public UsuarioDTO updateUsuario(UsuarioDTO usuario) {
        Optional<UsuarioDocument> sOptional = repository.findById(usuario.getId());
        if (sOptional.isPresent()) {
            UsuarioDocument u = sOptional.get();
            u.setTipoDocumento(usuario.getTipoDocumento());
            u.setCorreo(usuario.getCorreo());
            u.setNombre(usuario.getNombre());
            u.setNumeroDocumento(usuario.getNumeroDocumento());
            u.setRol(usuario.getRol());
            repository.save(u);
            return usuario;
        } else {
            return null;
        }
    }

    @Override
    public String deleteUsuario(String idUsuario) {
        Optional<UsuarioDocument> uOptional = repository.findById(idUsuario);
        if (uOptional.isPresent()) {
            repository.deleteById(idUsuario);
            return idUsuario;
        } else {
            return null;
        }

    }

    private UsuarioDTO entityToDTO(UsuarioDocument usuario) {
        UsuarioDTO dto = new UsuarioDTO(usuario.getId(), usuario.getRol(), usuario.getTipoDocumento(),
                usuario.getNumeroDocumento(), usuario.getCorreo(), usuario.getNombre());
        return dto;
    }

    @Override
    public List<UsuarioDTO> findAll() {
        List<UsuarioDTO> usuarioDTOs = new ArrayList<>();
        repository.findAll().forEach(s -> usuarioDTOs.add(entityToDTO(s)));
        return usuarioDTOs;
    }

    @Override
    public Set<UsuarioDTO> clientesExcelentes(String year) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        usuariosExcelentes = new HashSet<>();
        
        try {
            List<ReservaDocument> q1 = reservaRepository.findByCheckinGreaterThanAndCheckoutLessThan(
                    sdf.parse("01/01/" + year), sdf.parse("31/03/" + year));
            List<ReservaDocument> q2 = reservaRepository.findByCheckinGreaterThanAndCheckoutLessThan(
                    sdf.parse("01/04/" + year), sdf.parse("30/06/" + year));
            List<ReservaDocument> q3 = reservaRepository
                    .findByCheckinGreaterThanAndCheckoutLessThan(sdf.parse("01/07/" + year), sdf.parse("31/09/" + year));
            List<ReservaDocument> q4 = reservaRepository.findByCheckinGreaterThanAndCheckoutLessThan(
                    sdf.parse("01/10/" + year), sdf.parse("31/12/" + year));

            q1.forEach(rq1 -> {
                q2.forEach(rq2 -> {
                    if (rq1.getUsuarioId().equals(rq2.getUsuarioId())) {
                        q3.forEach(rq3 -> {
                            if (rq1.getUsuarioId().equals(rq3.getUsuarioId())) {
                                q4.forEach(rq4 -> {
                                    if (rq1.getUsuarioId().equals(rq4.getUsuarioId())) {
                                        usuariosExcelentes.add(entityToDTO(repository.findById(rq1.getUsuarioId()).get()));
                                    }
                                });

                            }
                        });
                    }
                });
            });

        return usuariosExcelentes;

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

}
