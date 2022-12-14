package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.HorarioServicio;
import co.edu.uniquindio.proyecto.Repositorios.HorarioRepo;
import co.edu.uniquindio.proyecto.Repositorios.PeliculaSalaRepo;
import co.edu.uniquindio.proyecto.entidades.Horario;
import co.edu.uniquindio.proyecto.entidades.PeliculaSala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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

    @Override
    public List<Horario> buscarHorarioPorPeliculaYFecha(String fecha, String peliculacodigo,Integer codigoCiudad) {

        LocalDate localDate1 = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Date fecha1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return horarioRepo.buscarHorarioPorPeliculaYFecha(fecha1,Integer.parseInt(peliculacodigo),codigoCiudad);
    }

    @Override
    public Horario obtenerHorario(Integer codigo) {
        return horarioRepo.findById(codigo).get();
    }
}
