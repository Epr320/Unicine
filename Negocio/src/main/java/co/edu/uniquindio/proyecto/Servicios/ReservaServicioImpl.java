package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.ReservaServicio;
import co.edu.uniquindio.proyecto.Repositorios.ClienteRepo;
import co.edu.uniquindio.proyecto.Repositorios.CuponRepo;
import co.edu.uniquindio.proyecto.Repositorios.HorarioRepo;
import co.edu.uniquindio.proyecto.Repositorios.ReservaRepo;
import co.edu.uniquindio.proyecto.entidades.Cupon;
import co.edu.uniquindio.proyecto.entidades.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public Reserva crearReserva(Reserva reserva) throws Exception {


        return reservaRepo.save(reserva);
    }

    @Override
    public Reserva obtenerReservar(Integer codigo) {
        return reservaRepo.findById(codigo).get();
    }

    @Override
    public Reserva guardarReservarFinal(Reserva reserva1, String cupon) {

        Optional<Cupon> cupon1 = cuponRepo.buscarPorNombre(cupon);


        if(cupon1.isPresent()){
            double descuento=cupon1.get().getPorcentaje();
            descuento=descuento/100;
            reserva1.setPrecio(reserva1.getPrecio()-(reserva1.getPrecio()*descuento));
        }

        return reservaRepo.save(reserva1);
    }

    @Override
    public List<Reserva> obtenerReservasPorCliente(String cedula) {
        return reservaRepo.obtenerReservasPorCliente(cedula);
    }
}
