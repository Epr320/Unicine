package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.TeatroServicio;
import co.edu.uniquindio.proyecto.Repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.Repositorios.TeatroRepo;
import co.edu.uniquindio.proyecto.entidades.Teatro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeatroServicioImpl implements TeatroServicio {

    @Autowired
    TeatroRepo teatroRepo;

    @Autowired
    CiudadRepo ciudadRepo;


    @Override
    public Teatro crearTeatro(String nombre, String direccion, Integer codigoCiudad) throws Exception {
        Teatro teatro=new Teatro();
        teatro.setDireccion(direccion);
        teatro.setNombre(nombre);
        teatro.setCiudad(ciudadRepo.getById(codigoCiudad));
        return teatroRepo.save(teatro);
    }

    @Override
    public Teatro actualizarTeatro(Integer codigo, String nombre, String direccion, Integer codigoCiudad) throws Exception {
        Teatro teatro=teatroRepo.getById(codigo);
        teatro.setDireccion(direccion);
        teatro.setNombre(nombre);
        teatro.setCiudad(ciudadRepo.getById(codigoCiudad));
        return teatroRepo.save(teatro);
    }

    @Override
    public Boolean eliminarTeatro(Integer codigo) throws Exception {

        teatroRepo.deleteById(codigo);
        return true;
    }

    @Override
    public List<Teatro> buscarTeatroPorCiudad(Integer codigo) throws Exception {
        return teatroRepo.buscarTeatrosPorCiudadCodigo(codigo);
    }
}
