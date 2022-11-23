package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.entidades.Horario;
import co.edu.uniquindio.proyecto.entidades.PeliculaSala;

import java.util.Date;
import java.util.List;

public interface HorarioServicio {

    Horario crearHorario(String horaInicio, double precio, Date fechaFin,PeliculaSala peliculaSala)throws Exception;
    Horario actualizarHorario(Horario horario)throws Exception;
    Boolean eliminarHorario(Integer codigo)throws Exception;
    List<Horario> buscarHorarioPorPelicula(String nombre);

    List<Horario> listarHorariosPorAdmin(String cedula);

    List<Horario> buscarHorarioPorPeliculaYFecha(String fecha, String peliculacodigo, Integer codigo);

    Horario obtenerHorario(Integer codigo);
}
