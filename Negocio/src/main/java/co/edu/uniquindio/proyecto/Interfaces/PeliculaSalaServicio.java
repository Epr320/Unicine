package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.entidades.Horario;
import co.edu.uniquindio.proyecto.entidades.Pelicula;
import co.edu.uniquindio.proyecto.entidades.PeliculaSala;
import co.edu.uniquindio.proyecto.entidades.Sala;

import java.util.List;

public interface PeliculaSalaServicio {
    PeliculaSala crearPeliculaSala(Pelicula pelicula, Sala sala,  List<Horario> horarios);

}
