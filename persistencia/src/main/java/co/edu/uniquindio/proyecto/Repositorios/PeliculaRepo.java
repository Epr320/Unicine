package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.entidades.Actor;
import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Pelicula;
import co.edu.uniquindio.proyecto.entidades.PeliculaSala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PeliculaRepo extends JpaRepository<Pelicula, Integer> {

    @Query("select p from Pelicula p where upper(p.nombre) like concat ('%' , :nombre , '%')")
    List<Pelicula> buscarPeliculaPorNombre(String nombre);

    @Query("select p from Teatro t join Sala s join PeliculaSala  ps join Pelicula p where t.codigo=:teatro")
    List<Pelicula> buscarPeliculaPorTeatro(Integer teatro);
    @Query("select p from Pelicula p where p.estado='Estreno'")
    List<Pelicula> buscarPeliculasCarteleraEstreno();

    @Query("select p from Pelicula p where p.estado='Pre-Venta'")
    List<Pelicula> buscarPeliculasCarteleraPreVenta();



}
