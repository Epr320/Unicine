package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.ReservaServicio;
import co.edu.uniquindio.proyecto.Repositorios.ClienteRepo;
import co.edu.uniquindio.proyecto.Repositorios.CuponRepo;
import co.edu.uniquindio.proyecto.Repositorios.HorarioRepo;
import co.edu.uniquindio.proyecto.Repositorios.ReservaRepo;
import co.edu.uniquindio.proyecto.entidades.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReservaServicioImpl implements ReservaServicio {
    @Autowired
    ReservaRepo reservaRepo;

    @Autowired
    HorarioRepo horarioRepo;

    @Autowired
    ClienteRepo clienteRepo;

    @Autowired
    CuponRepo cuponRepo;

    @Override
    public Reserva crearReserva(Double precio, Date Fecha, Integer cliente, Integer Horario, String cupon) throws Exception {


        return null;
    }
}
