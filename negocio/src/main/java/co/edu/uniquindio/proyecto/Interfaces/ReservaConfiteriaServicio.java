package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.entidades.Reserva_Confiteria;

import java.util.List;

public interface ReservaConfiteriaServicio {

    Reserva_Confiteria crearReservaConfiteria(Reserva_Confiteria reserva_confiteria)throws Exception;

    List<Reserva_Confiteria> guardarTodas(List<Reserva_Confiteria> confiteriasC);

    List<Reserva_Confiteria> buscarPorReserva(Integer codigo);
}
