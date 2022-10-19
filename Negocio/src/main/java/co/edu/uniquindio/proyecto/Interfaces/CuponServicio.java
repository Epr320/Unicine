package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.entidades.Cupon;

public interface CuponServicio {
    Cupon crearCupon(String nombre,String descripcion,String criterio,int porcentaje)throws Exception;
    Cupon ActualizarCupon(Integer codigo,String nombre,String descripcion,String criterio,int porcentaje)throws Exception;
    Boolean eliminarCupon(Integer codigo)throws Exception;
    Cupon buscarCupon(String nombre)throws Exception;

}
