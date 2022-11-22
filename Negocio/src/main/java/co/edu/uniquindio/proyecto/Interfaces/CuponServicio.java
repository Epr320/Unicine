package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.entidades.Cupon;

import java.util.List;

public interface CuponServicio {
    Cupon crearCupon(String nombre,String descripcion,String criterio,int porcentaje)throws Exception;
    Cupon ActualizarCupon(Cupon cupon)throws Exception;
    Boolean eliminarCupon(Integer codigo)throws Exception;
    Cupon buscarCupon(String nombre)throws Exception;

    List<Cupon> listarCupon();
}
