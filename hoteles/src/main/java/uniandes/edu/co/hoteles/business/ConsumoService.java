package uniandes.edu.co.hoteles.business;

import java.util.List;

import uniandes.edu.co.hoteles.dto.ConsumoDTO;

public interface ConsumoService {

    public void createConsumo(ConsumoDTO Consumo);
    
    public ConsumoDTO updateConsumo(ConsumoDTO Consumo);

    public Long deleteConsumo(Long idConsumo);
    
    public List<ConsumoDTO> findAll();
    
}
