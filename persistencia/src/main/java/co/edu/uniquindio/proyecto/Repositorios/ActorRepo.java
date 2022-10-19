package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.entidades.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepo extends JpaRepository<Actor, Integer> {

    @Query("select a from Actor a join a.peliculas pa where upper(pa.nombre) like concat ('%' , :nombre , '%') ")
    List<Actor> buscarActoresPorPelicula(String nombre);

}
