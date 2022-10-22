package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.PeliculaServicio;
import co.edu.uniquindio.proyecto.Repositorios.PeliculaRepo;
import co.edu.uniquindio.proyecto.entidades.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PeliculaServicioImpl implements PeliculaServicio {

    @Autowired
    PeliculaRepo peliculaRepo;

    @Override
    public Pelicula crearPelicula(String nombre, String descripcion, String sinopsis, String genero, String trailer, List<String> ruta) throws Exception {
       Pelicula pelicula =new Pelicula();
        pelicula.setNombre(nombre);
       pelicula.setGenero(genero);
       pelicula.setRuta(ruta);
       pelicula.setDescripcion(descripcion);
       pelicula.setSinopsis(sinopsis);
       pelicula.setTrailer(trailer);
        return peliculaRepo.save(pelicula);
    }

    @Override
    public Pelicula modificarPelicula(Integer codigo, String nombre, String descripcion, String sinopsis, String genero, String trailer, List<String> ruta) throws Exception {
        Pelicula pelicula =peliculaRepo.getById(codigo);
        pelicula.setNombre(nombre);
        pelicula.setGenero(genero);
        pelicula.setRuta(ruta);
        pelicula.setDescripcion(descripcion);
        pelicula.setSinopsis(sinopsis);
        pelicula.setTrailer(trailer);
        return peliculaRepo.save(pelicula);
    }

    @Override
    public Boolean eliminarPelicula(Integer codigo) throws Exception {
        Pelicula pelicula =peliculaRepo.getById(codigo);
        peliculaRepo.deleteById(codigo);
        if(peliculaRepo.getById(codigo)==null){
            return true;
        }
        return false;
    }

    @Override
    public Pelicula buscarPeliculaPorNombre(String nombre) throws Exception {
        return peliculaRepo.buscarPeliculaPorNombre(nombre);
    }
}

