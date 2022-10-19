package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.entidades.Actor;
import co.edu.uniquindio.proyecto.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepo extends JpaRepository<Pelicula, Integer> {

    @Query("select p from Pelicula p where p.nombre=:nombre")
    Pelicula buscarPeliculaPorNombre(String nombre);

}
