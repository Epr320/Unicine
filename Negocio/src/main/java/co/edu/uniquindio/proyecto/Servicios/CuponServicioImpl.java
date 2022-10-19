package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.CuponServicio;
import co.edu.uniquindio.proyecto.Repositorios.CuponRepo;
import co.edu.uniquindio.proyecto.entidades.Cupon;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

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
    public Cupon ActualizarCupon(Integer codigo, String nombre, String descripcion, String criterio, int porcentaje) throws Exception {
        Optional<Cupon> cupon =cuponRepo.findById(codigo);
        if(cupon.isPresent()){
            cupon.get().setNombre(nombre);
            cupon.get().setPorcentaje(porcentaje);
            cupon.get().setCriterio(criterio);
            cupon.get().setDescripcion(descripcion);
            return cuponRepo.save(cupon.get());
        }else{
            throw new Exception("El codigo no se encuentra asociado a ningun cupon");
        }

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
}
