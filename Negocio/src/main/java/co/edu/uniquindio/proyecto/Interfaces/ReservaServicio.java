package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.entidades.Reserva;

import java.util.Date;

public interface ReservaServicio {

    Reserva crearReserva(Double precio, Date Fecha,Integer cliente,Integer Horario,String cupon)throws Exception;

}
