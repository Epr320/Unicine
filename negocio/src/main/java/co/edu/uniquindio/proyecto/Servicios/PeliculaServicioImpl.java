package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.PeliculaServicio;
import co.edu.uniquindio.proyecto.Repositorios.HorarioRepo;
import co.edu.uniquindio.proyecto.Repositorios.PeliculaRepo;
import co.edu.uniquindio.proyecto.Repositorios.PeliculaSalaRepo;
import co.edu.uniquindio.proyecto.Repositorios.SalaRepo;
import co.edu.uniquindio.proyecto.entidades.Horario;
import co.edu.uniquindio.proyecto.entidades.Pelicula;
import co.edu.uniquindio.proyecto.entidades.PeliculaSala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PeliculaServicioImpl implements PeliculaServicio {

    @Autowired
    PeliculaRepo peliculaRepo;

    @Autowired
    PeliculaSalaRepo salaRepo;

    @Autowired
    HorarioRepo horarioRepo;
    @Override
    public Pelicula crearPelicula(String nombre, String descripcion, String sinopsis, String genero, String trailer, String ruta) throws Exception {
       Pelicula pelicula =new Pelicula();
        pelicula.setNombre(nombre);
       pelicula.setGenero(genero);
       pelicula.setRuta(ruta);
       pelicula.setDescripcion(descripcion);
       pelicula.setSinopsis(sinopsis);
       pelicula.setTrailer(trailer);
        return peliculaRepo.save(pelicula);
    }

    @Override
    public Pelicula modificarPelicula(Pelicula pelicula) throws Exception {

        return peliculaRepo.save(pelicula);
    }

    @Override
    public Boolean eliminarPelicula(Integer codigo) throws Exception {
        Pelicula pelicula =peliculaRepo.findById(codigo).get();
        List<PeliculaSala> ps = salaRepo.listarPeliculaSalaPorPelicula(codigo);
        List<Horario> h =horarioRepo.buscarPorPelicula(codigo);
        horarioRepo.deleteAll(h);
        salaRepo.deleteAll(ps);
        peliculaRepo.deleteById(codigo);

        return true;
    }

    @Override
    public List<Pelicula> buscarPeliculaPorNombre(String nombre) throws Exception {
        return peliculaRepo.buscarPeliculaPorNombre(nombre);
    }

    @Override
    public List<Pelicula> buscarPeliculaPorTeatro(Integer teatro) {
        return peliculaRepo.buscarPeliculaPorTeatro(teatro);
    }

    @Override
    public List<Pelicula> listarPeliculas() {
        return peliculaRepo.findAll();
    }

    @Override
    public List<Pelicula> listarPeliculasCartelera() {
        List<Pelicula> pelis;
        pelis=peliculaRepo.buscarPeliculasCarteleraPreVenta();
        pelis.addAll(peliculaRepo.buscarPeliculasCarteleraEstreno());
        return pelis;
    }

    @Override
    public Pelicula obtenerPelicula(String peliculacodigo) {
        return peliculaRepo.findById(Integer.parseInt(peliculacodigo)).get();
    }
}

