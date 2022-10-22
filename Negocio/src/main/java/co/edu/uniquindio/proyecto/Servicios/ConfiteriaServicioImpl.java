package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.ConfiteriaServicio;
import co.edu.uniquindio.proyecto.Repositorios.ConfiteriaRepo;
import co.edu.uniquindio.proyecto.entidades.Confiteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ConfiteriaServicioImpl implements ConfiteriaServicio {

   @Autowired
    ConfiteriaRepo confiteriaRepo;

    @Override
    public Confiteria crearProducto(String nombre, double precio) throws Exception {
        Confiteria confiteria = new Confiteria();
        confiteria.setNombre(nombre);
        confiteria.setPrecio(precio);

        return confiteriaRepo.save(confiteria);
    }

    @Override
    public Confiteria actualizarProducto(Integer codigo, String nombre, double precio) throws Exception {

        Optional<Confiteria> confiteria = confiteriaRepo.findById(codigo);
        if(confiteria.isPresent()){
            confiteria.get().setNombre(nombre);
            confiteria.get().setPrecio(precio);
            return confiteriaRepo.save(confiteria.get());
        }else{
            throw new Exception("No hay un producto con este codigo");
        }
    }

    @Override
    public boolean eliminarProducto(Integer codigo) throws Exception {
        Optional<Confiteria> confiteria = confiteriaRepo.findById(codigo);
        if(confiteria.isPresent()){
           confiteriaRepo.delete(confiteria.get());
            return true;
        }else{
            throw new Exception("No hay un producto con este codigo");
        }
    }
}
