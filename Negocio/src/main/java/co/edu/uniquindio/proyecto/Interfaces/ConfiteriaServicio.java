package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.entidades.Confiteria;

import java.util.List;

public interface ConfiteriaServicio {

    Confiteria crearProducto(String nombre,double precio)throws Exception;
    Confiteria actualizarProducto(Confiteria confiteria)throws Exception;
    boolean eliminarProducto(Integer codigo)throws Exception;


    List<Confiteria> listarConfiteria();
}
