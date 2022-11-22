package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.HorarioServicio;
import co.edu.uniquindio.proyecto.Repositorios.HorarioRepo;
import co.edu.uniquindio.proyecto.Repositorios.PeliculaSalaRepo;
import co.edu.uniquindio.proyecto.entidades.Horario;
import co.edu.uniquindio.proyecto.entidades.PeliculaSala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class HorarioServicioImpl implements HorarioServicio {

    @Autowired
    HorarioRepo horarioRepo;

    @Autowired
    PeliculaSalaRepo peliculaSalaRepo;

    @Override
    public Horario crearHorario(String horaInicio, double precio, Date fechaFin, PeliculaSala peliculaSala) throws Exception {

        Horario horario =new Horario();
        horario.setPrecio(precio);
        horario.setHorainicio(horaInicio);
        horario.setFecha(fechaFin);
        horario.setPeliculaSala(peliculaSala);
        return horarioRepo.save(horario);
    }

    @Override
    public Horario actualizarHorario(Horario horario) throws Exception {
        peliculaSalaRepo.save(horario.getPeliculaSala());
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

    @Override
    public List<Horario> listarHorariosPorAdmin(String cedula) {
        return horarioRepo.listarHorariosPorAdmin(cedula);
    }
}
