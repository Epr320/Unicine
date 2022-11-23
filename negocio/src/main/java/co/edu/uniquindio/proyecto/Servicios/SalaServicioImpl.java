package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.SalaServicio;
import co.edu.uniquindio.proyecto.Interfaces.TeatroServicio;
import co.edu.uniquindio.proyecto.Repositorios.SalaRepo;
import co.edu.uniquindio.proyecto.Repositorios.TeatroRepo;
import co.edu.uniquindio.proyecto.entidades.Sala;
import co.edu.uniquindio.proyecto.entidades.Teatro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SalaServicioImpl implements SalaServicio {

    @Autowired
    SalaRepo salaRepo;

    @Autowired
    TeatroRepo teatroRepo;

    @Override
    public Sala crearSala(int numfilas, int numColumnas, int numAsientos, Integer codigoTeatro) throws Exception {
        Sala sala=new Sala();

        sala.setTeatro(teatroRepo.getById(codigoTeatro));
        sala.setNumAsientos(numAsientos);
        sala.setNumFilas(numfilas);
        sala.setNumColumnas(numColumnas);

        return salaRepo.save(sala);
    }

    @Override
    public Sala actualizarSala(Sala sala) throws Exception {

        return salaRepo.save(sala);

    }

    @Override
    public Boolean eliminarSala(Integer codigo) throws Exception {
        salaRepo.deleteById(codigo);

        if(salaRepo.getById(codigo)==null){
           return true;
        }

        return false;
    }

    @Override
    public List<Sala> buscarSalaPorTeatro(Integer codigo) throws Exception {
        return salaRepo.buscarSalasPorTeatro(codigo);
    }

    @Override
    public List<Sala> listar(String cedula) {
        return salaRepo.buscarSalasPorCiudad(cedula);
    }

    @Override
    public Sala obtenerSala(Integer parseInt) {
        return salaRepo.findById(parseInt).get();
    }
}
