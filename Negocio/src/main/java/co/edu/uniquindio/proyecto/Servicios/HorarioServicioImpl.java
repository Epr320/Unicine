package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.HorarioServicio;
import co.edu.uniquindio.proyecto.Repositorios.HorarioRepo;
import co.edu.uniquindio.proyecto.entidades.Horario;
import co.edu.uniquindio.proyecto.entidades.PeliculaSala;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class HorarioServicioImpl implements HorarioServicio {

    @Autowired
    HorarioRepo horarioRepo;

    @Override
    public Horario crearHorario(String horaInicio, double precio, Date fechaFin, PeliculaSala peliculaSala) throws Exception {

        Horario horario =new Horario();
        horario.setPrecio(precio);
        horario.setHorainicio(horaInicio);
        horario.setFechaFin(fechaFin);
        horario.setPeliculaSala(peliculaSala);
        return horarioRepo.save(horario);
    }

    @Override
    public Horario actualizarHorario(Integer codigo, String horaInicio, double precio, Date fechaFin) throws Exception {

       Horario horario =horarioRepo.getById(codigo);
       horario.setPrecio(precio);
       horario.setHorainicio(horaInicio);
       horario.setFechaFin(fechaFin);
        return horarioRepo.save(horario);
    }

    @Override
    public Boolean eliminarHorario(Integer codigo) throws Exception {
         horarioRepo.deleteById(codigo);
         if(horarioRepo.getById(codigo)==null){
             return true;
         }else{
             return false;
         }
    }

    @Override
    public List<Horario> buscarHorarioPorPelicula(String nombre) {

        return horarioRepo.buscarPorPelicula(nombre);
    }
}
