package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.CiudadServicio;
import co.edu.uniquindio.proyecto.Repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.entidades.Ciudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CiudadServicioImpl implements CiudadServicio {

    @Autowired
    CiudadRepo ciudadRepo;

    @Override
    public Ciudad agregarCiudad(String nombre) throws Exception {
        Optional<Ciudad> buscar = ciudadRepo.buscarPorNombre(nombre);

        if(buscar.isPresent()){
            throw new Exception("El nombre de la ciudad ya esta registrado");
        }
        Ciudad ciudad = new Ciudad();
        ciudad.setNombre(nombre);
        return ciudadRepo.save(ciudad);
    }

    @Override
    public Ciudad actualizarCiudad(Integer codigo, String nombreNuevo) throws Exception {
        Ciudad ciudad = ciudadRepo.getById(codigo);
        ciudad.setNombre(nombreNuevo.trim());

        return ciudadRepo.save(ciudad);
    }

    @Override
    public boolean eliminarCiudad(Integer codigo) throws Exception {

        if(ciudadRepo.findById(codigo).isPresent()) {
            ciudadRepo.deleteById(codigo);
            return true;
        } else {
            throw new Exception("No existe una ciudad con ese codigo.");
        }
    }

    @Override
    public List<Ciudad> buscarCiudad(String nombre) throws Exception {
        return ciudadRepo.listarPorNombre(nombre);
    }

    @Override
    public List<Ciudad> listar() {
        return ciudadRepo.findAll();
    }

    @Override
    public Ciudad obtenerCiudad(Integer id) throws Exception {
       Ciudad ciudad=ciudadRepo.getById(id);
       if(ciudad!=null){
           return ciudad;
       }else{
           throw new Exception("No existe Ciudad con este id");
       }
    }
}
