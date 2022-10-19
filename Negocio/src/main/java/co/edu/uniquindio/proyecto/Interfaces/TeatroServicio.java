package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.entidades.Teatro;

import java.util.List;

public interface TeatroServicio {

    Teatro crearTeatro(String nombre,String direccion,Integer codigoCiudad)throws Exception;
    Teatro actualizarTeatro(Integer codigo,String nombre,String direccion,Integer codigoCiudad)throws Exception;
    Boolean eliminarTeatro(Integer codigo)throws Exception;
    List<Teatro> buscarTeatroPorCiudad(Integer codigo)throws Exception;

}
