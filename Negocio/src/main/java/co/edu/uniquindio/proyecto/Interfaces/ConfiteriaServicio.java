package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.entidades.Confiteria;

public interface ConfiteriaServicio {

    Confiteria crearProducto(String nombre,double precio)throws Exception;
    Confiteria actualizarProducto(Integer codigo,String nombre,double precio)throws Exception;
    boolean eliminarProducto(Integer codigo)throws Exception;


}
