package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.entidades.Pelicula;

import java.util.List;

public interface PeliculaServicio {

    Pelicula crearPelicula(String nombre, String descripcion, String sinopsis, String genero, String tariler, List<String> ruta)throws Exception;
    Pelicula modificarPelicula(Integer codigo,String nombre, String descripcion, String sinopsis, String genero, String tariler, List<String>ruta)throws Exception;
    Boolean eliminarPelicula(Integer codigo)throws Exception;
    Pelicula buscarPeliculaPorNombre(String nombre)throws Exception;

}
