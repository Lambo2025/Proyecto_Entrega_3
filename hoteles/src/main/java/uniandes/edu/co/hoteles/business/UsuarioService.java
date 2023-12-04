package uniandes.edu.co.hoteles.business;

import java.util.List;
import java.util.Set;

import uniandes.edu.co.hoteles.dto.UsuarioDTO;

public interface UsuarioService {

    public void createUsuario(UsuarioDTO usuario);
    
    public UsuarioDTO updateUsuario(UsuarioDTO usuario);

    public String deleteUsuario(String idUsuario);

    public List<UsuarioDTO> findAll();

    public Set<UsuarioDTO> clientesExcelentes(String year);
    
}
