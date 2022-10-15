package co.edu.uniquindio.proyecto.Interfaces;

import java.util.List;

public interface CiudadServicio {
    CiudadServicio agregarCiudad (String nombre) throws Exception;

    CiudadServicio actualizarCiudad (Integer codigo, String nombreNuevo) throws Exception;

    boolean eliminarCiudad (Integer codigo) throws Exception;

    List<CiudadServicio> buscarCiudad (String nombre) throws Exception;

    List<CiudadServicio> listar();

    CiudadServicio obtenerCuidad(Integer id) throws Exception;
}
