package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.ReservaServicio;
import co.edu.uniquindio.proyecto.Repositorios.*;
import co.edu.uniquindio.proyecto.entidades.*;
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
    @Autowired
    ReservaConfiteriaRepo reservaConfiteriaRepo;

    @Autowired
    EntradaRepo entradaRepo;

    @Override
    public Reserva crearReserva(Double precio, Date fecha, String cedulacliente, Integer codhorario, String cupon,
                                List<Entrada> entradas,List<Reserva_Confiteria> confiterias) throws Exception {
        double precioTotal;
        double descuento;
        Horario horario = horarioRepo.getById(codhorario);
        Cliente cliente = clienteRepo.getById(cedulacliente);
        Optional<Cupon> cupon1 = cuponRepo.buscarPorNombre(cupon);
        Reserva reserva = new Reserva();
        precioTotal=precio*entradas.size();
       for(int i=0;i<confiterias.size();i++){
           precioTotal=precioTotal+confiterias.get(i).getConfiteria().getPrecio()*confiterias.get(i).getCantidad();
           confiterias.get(i).setReserva(reserva);
       }
       for(int i=0;i<entradas.size();i++){
           entradas.get(i).setReserva(reserva);
           entradas.get(i).setHorario(horario);
       }
        if(cupon1.isEmpty()){
            reserva.setCupon(null);

        }else{
            reserva.setCupon(cupon1.get());
            precioTotal=precioTotal-precioTotal*(cupon1.get().getPorcentaje()/100);
        }
        reserva.setCliente(cliente);
        reserva.setFecha(fecha);
        reserva.setHorario(horario);
        reserva.setConfiterias(confiterias);
        reserva.setEntradas(entradas);
        entradaRepo.saveAll(entradas);
        reservaConfiteriaRepo.saveAll(confiterias);
        return reservaRepo.save(reserva);
    }
}
