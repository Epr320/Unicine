package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.entidades.Actor;
import co.edu.uniquindio.proyecto.entidades.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioRepo extends JpaRepository<Horario, Integer> {
    @Query("select  h from Horario h where h.peliculaSala.pelicula.nombre=:nombre")
    List<Horario> buscarPorPelicula(String nombre);
}
