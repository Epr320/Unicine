package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.ReservaConfiteriaServicio;
import co.edu.uniquindio.proyecto.Repositorios.ReservaConfiteriaRepo;
import co.edu.uniquindio.proyecto.entidades.Reserva_Confiteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaConfiteriaServicioImpl implements ReservaConfiteriaServicio {

    @Autowired
    ReservaConfiteriaRepo reservaConfiteriaRepo;

    @Override
    public Reserva_Confiteria crearReservaConfiteria(Reserva_Confiteria reserva_confiteria) throws Exception {
        return reservaConfiteriaRepo.save(reserva_confiteria);
    }

    @Override
    public List<Reserva_Confiteria> guardarTodas(List<Reserva_Confiteria> confiteriasC) {
        return reservaConfiteriaRepo.saveAll(confiteriasC);
    }

    @Override
    public List<Reserva_Confiteria> buscarPorReserva(Integer codigo) {
        return reservaConfiteriaRepo.buscarPorReserva(codigo);
    }
}
