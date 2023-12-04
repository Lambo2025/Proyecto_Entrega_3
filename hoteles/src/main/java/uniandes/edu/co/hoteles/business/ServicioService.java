package uniandes.edu.co.hoteles.business;

import java.util.List;

import uniandes.edu.co.hoteles.dto.ServicioDTO;

public interface ServicioService {

    public void createServicio(ServicioDTO servicio);
    
    public ServicioDTO updateServicio(ServicioDTO servicio);

    public String deleteServicio(String idServicio);

    public List<ServicioDTO> findAll();

}
