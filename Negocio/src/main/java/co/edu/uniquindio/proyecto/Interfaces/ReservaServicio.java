package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.entidades.Reserva;

import java.util.Date;

public interface ReservaServicio {

    Reserva crearReserva(Reserva reserva)throws Exception;

    Reserva obtenerReservar(Integer codigo);

    Reserva guardarReservarFinal(Reserva reserva1, String cupon);
}
