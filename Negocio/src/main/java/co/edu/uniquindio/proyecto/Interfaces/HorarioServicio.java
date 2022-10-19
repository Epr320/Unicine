package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.entidades.Horario;
import co.edu.uniquindio.proyecto.entidades.PeliculaSala;

import java.util.Date;
import java.util.List;

public interface HorarioServicio {

    Horario crearHorario(String horaInicio, double precio, Date fechaFin,PeliculaSala peliculaSala)throws Exception;
    Horario actualizarHorario(Integer codigo,String horaInicio, double precio, Date fechaFin)throws Exception;
    Boolean eliminarHorario(Integer codigo)throws Exception;
    List<Horario> buscarHorarioPorPelicula(String nombre);

}
