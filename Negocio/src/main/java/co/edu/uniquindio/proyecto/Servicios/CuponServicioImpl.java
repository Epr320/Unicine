package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.CuponServicio;
import co.edu.uniquindio.proyecto.Repositorios.CuponRepo;
import co.edu.uniquindio.proyecto.entidades.Cupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CuponServicioImpl implements CuponServicio {

    @Autowired
    CuponRepo cuponRepo;

    @Override
    public Cupon crearCupon(String nombre, String descripcion, String criterio, int porcentaje) throws Exception {
       Cupon cupon =new Cupon();
       cupon.setNombre(nombre);
       cupon.setDescripcion(descripcion);
       cupon.setCriterio(descripcion);
       cupon.setPorcentaje(porcentaje);
       return cuponRepo.save(cupon);
    }

    @Override
    public Cupon ActualizarCupon(Cupon cupon) throws Exception {

            return cuponRepo.save(cupon);


    }

    @Override
    public Boolean eliminarCupon(Integer codigo) throws Exception {
        Optional<Cupon> cupon =cuponRepo.findById(codigo);
        if(cupon.isPresent()){
            cuponRepo.delete(cupon.get());
            return true;
        }else{
            throw new Exception("El codigo no se encuentra asociado a ningun cupon");
        }
    }

    @Override
    public Cupon buscarCupon(String nombre) throws Exception {
        Optional<Cupon> cupon = cuponRepo.buscarPorNombre(nombre);
        if(cupon.isPresent()){
            return cupon.get();
        }else{
            throw new Exception("No hay ningun cupon asociado");
        }
    }

    @Override
    public List<Cupon> listarCupon() {
        return cuponRepo.findAll();
    }
}
