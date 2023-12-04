package uniandes.edu.co.hoteles.business;

import java.util.List;

import uniandes.edu.co.hoteles.dto.ConsumoPorUsuarioRequest;
import uniandes.edu.co.hoteles.dto.ReservaDTO;

public interface ReservaService {

    public void createReserva(ReservaDTO reserva);
    
    public ReservaDTO updateReserva(ReservaDTO reserva);

    public String deleteReserva(String idreserva);

    public List<ReservaDTO> findAll();

    public Double findBookingByUserDocument(ConsumoPorUsuarioRequest dto);
    
    
}
