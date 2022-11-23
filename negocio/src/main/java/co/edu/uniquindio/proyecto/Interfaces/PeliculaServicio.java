package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.entidades.Pelicula;

import java.util.List;

public interface PeliculaServicio {

    Pelicula crearPelicula(String nombre, String descripcion, String sinopsis, String genero, String tariler, String ruta)throws Exception;
    Pelicula modificarPelicula( Pelicula pelicula)throws Exception;
    Boolean eliminarPelicula(Integer codigo)throws Exception;
    List<Pelicula> buscarPeliculaPorNombre(String nombre)throws Exception;

    List<Pelicula> buscarPeliculaPorTeatro(Integer teatro);

    List<Pelicula> listarPeliculas();

    List<Pelicula> listarPeliculasCartelera();

    Pelicula obtenerPelicula(String peliculacodigo);
}
