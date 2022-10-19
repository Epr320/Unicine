package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.SalaServicio;
import co.edu.uniquindio.proyecto.Interfaces.TeatroServicio;
import co.edu.uniquindio.proyecto.Repositorios.SalaRepo;
import co.edu.uniquindio.proyecto.Repositorios.TeatroRepo;
import co.edu.uniquindio.proyecto.entidades.Sala;
import co.edu.uniquindio.proyecto.entidades.Teatro;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public Sala actualizarSala(Integer codigo,int numfilas, int numColumnas, int numAsientos) throws Exception {
        Sala sala=salaRepo.getById(codigo);
        sala.setNumAsientos(numAsientos);
        sala.setNumFilas(numfilas);
        sala.setNumColumnas(numColumnas);
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
}
