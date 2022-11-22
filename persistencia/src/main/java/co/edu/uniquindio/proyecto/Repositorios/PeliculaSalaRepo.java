package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.entidades.Actor;
import co.edu.uniquindio.proyecto.entidades.PeliculaSala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaSalaRepo extends JpaRepository<PeliculaSala, Integer> {

    @Query("select ps from PeliculaSala  ps where ps.sala.teatro.codigo=:codigo")
    List<PeliculaSala> listarPeliculaSalaPorTeatro(Integer codigo);

    @Query("select ps from PeliculaSala  ps where ps.pelicula.codigo=:pelicula")
    List<PeliculaSala> listarPeliculaSalaPorPelicula(Integer pelicula);
}
