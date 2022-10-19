package co.edu.uniquindio.proyecto.Servicios;

import  co.edu.uniquindio.proyecto.Interfaces.PeliculaSalaServicio;
import co.edu.uniquindio.proyecto.entidades.Horario;
import co.edu.uniquindio.proyecto.entidades.Pelicula;
import co.edu.uniquindio.proyecto.entidades.PeliculaSala;
import co.edu.uniquindio.proyecto.entidades.Sala;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaSalaServicioImpl implements PeliculaSalaServicio {
    @Override
    public PeliculaSala crearPeliculaSala(Pelicula pelicula, Sala sala, List<Horario> horarios) {
        PeliculaSala peliculaSala=new PeliculaSala();
        peliculaSala.setPelicula(pelicula);
        peliculaSala.setSala(sala);
        peliculaSala.setHorarios(horarios);
        return null;
    }


}
