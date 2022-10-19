package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.entidades.Entrada;
import co.edu.uniquindio.proyecto.entidades.Reserva;
import co.edu.uniquindio.proyecto.entidades.Reserva_Confiteria;

import java.util.Date;
import java.util.List;

public interface ReservaServicio {

    Reserva crearReserva(Double precio, Date fecha,String cliente,Integer horario,String cupon, List<Entrada> entradas,List<Reserva_Confiteria> confiterias )throws Exception;

}
