package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.entidades.AdministradorCiudad;

import java.util.List;

public interface AdministradorCiudadServicio {

    AdministradorCiudad login (String email, String password) throws Exception;

    AdministradorCiudad agregarAdministradorDeCiudad (String cedula, String nombre, String email, String password) throws Exception;

    AdministradorCiudad actualizarAdministradorDeCiudad (String cedula, String nombre,  String email, String password, Integer codigo) throws Exception;

    boolean eliminarAdministradorDeCiudadPorCedula (String cedula) throws Exception;

    AdministradorCiudad buscarAdministradorDeCiudadPorCedula (String cedula) throws Exception;

    AdministradorCiudad buscarAdministradorDeCiudadPorCodigo (Integer codigo) throws Exception;

    AdministradorCiudad buscarAdministradorDeCiudadPorCiudad (Integer codigo) throws Exception;

    List<AdministradorCiudad> listar();
}
