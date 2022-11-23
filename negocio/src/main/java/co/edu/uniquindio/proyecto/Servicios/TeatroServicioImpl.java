package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.TeatroServicio;
import co.edu.uniquindio.proyecto.Repositorios.*;
import co.edu.uniquindio.proyecto.entidades.Horario;
import co.edu.uniquindio.proyecto.entidades.PeliculaSala;
import co.edu.uniquindio.proyecto.entidades.Sala;
import co.edu.uniquindio.proyecto.entidades.Teatro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeatroServicioImpl implements TeatroServicio {

    @Autowired
    TeatroRepo teatroRepo;

    @Autowired
    CiudadRepo ciudadRepo;

    @Autowired
    SalaRepo salaRepo;

    @Autowired
    PeliculaSalaRepo peliculaSalaRepo;

    @Autowired
    HorarioRepo horarioRepo;
    @Override
    public Teatro crearTeatro(String nombre, String direccion, Integer codigoCiudad) throws Exception {
        Teatro teatro=new Teatro();
        teatro.setDireccion(direccion);
        teatro.setNombre(nombre);
        teatro.setCiudad(ciudadRepo.getById(codigoCiudad));
        return teatroRepo.save(teatro);
    }

    @Override
    public Teatro actualizarTeatro(Teatro teatro) throws Exception {
        return teatroRepo.save(teatro);
    }

    @Override
    public Boolean eliminarTeatro(Integer codigo) throws Exception {

        List<Sala> salas = salaRepo.buscarSalasPorTeatro(codigo);
        List<PeliculaSala> ps =peliculaSalaRepo.listarPeliculaSalaPorTeatro(codigo);
        List<Horario> horarios = horarioRepo.buscarPorTeatro(codigo);
        horarioRepo.deleteAll(horarios);
        peliculaSalaRepo.deleteAll(ps);
        salaRepo.deleteAll(salas);
        teatroRepo.deleteById(codigo);
        return true;
    }

    @Override
    public List<Teatro> buscarTeatroPorCiudad(Integer codigo) throws Exception {
        return teatroRepo.buscarTeatrosPorCiudadCodigo(codigo);
    }

    @Override
    public Teatro buscarTeatroPorNombreYCiudad(String teatro, String ciudad) {
        return teatroRepo.buscarTeatroPorCiudadYNombre(teatro,ciudad);
    }

    @Override
    public List<Teatro> listarTeatros() {
        return teatroRepo.findAll();
    }

    @Override
    public Teatro obtenerTaetro(Integer teatro) {
        return teatroRepo.findById(teatro).get();
    }

    @Override
    public List<Teatro> buscarTeatrosPorAdmin(String cedula) {
        return teatroRepo.buscarTeatrosPorAdmin(cedula);
    }
}
