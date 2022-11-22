package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.ConfiteriaServicio;
import co.edu.uniquindio.proyecto.Repositorios.ConfiteriaRepo;
import co.edu.uniquindio.proyecto.entidades.Confiteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Confiteria actualizarProducto(Confiteria confiteria) throws Exception {


            return confiteriaRepo.save(confiteria);

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

    @Override
    public List<Confiteria> listarConfiteria() {
        return confiteriaRepo.findAll();
    }
}
