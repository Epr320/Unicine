package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.entidades.Cliente;

import java.util.List;

public interface ClienteServicio {

    Cliente login(String email, String password) throws Exception;

    Cliente registrarCliente (String cedula, String nombre, String email, String password, List<String> telefonos,String ruta) throws Exception;

    Cliente actualizarCliente (String cedula, String nombre, String email, String password,List<String> telefonos,String ruta) throws Exception;

    public void actualizarTelefonos(String cedula, List<String> telefonos) throws Exception;

    boolean eliminarClientePorCedula (String cedula) throws Exception;

    Cliente buscarClientePorCedula (String cedula) throws Exception;

    List<Cliente> listar() throws Exception;

    boolean recuperarPasswordUsandoCorreoElectronico(String email) throws Exception;


}
