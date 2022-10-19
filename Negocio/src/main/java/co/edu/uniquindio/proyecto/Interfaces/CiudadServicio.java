package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.entidades.Ciudad;

import java.util.List;
import java.util.Optional;

public interface CiudadServicio {
    Ciudad agregarCiudad (String nombre) throws Exception;

    Ciudad actualizarCiudad (Integer codigo, String nombreNuevo) throws Exception;

    boolean eliminarCiudad (Integer codigo) throws Exception;

    List<Ciudad> buscarCiudad (String nombre) throws Exception;

    List<Ciudad> listar();

    Ciudad obtenerCiudad(Integer id) throws Exception;
}
