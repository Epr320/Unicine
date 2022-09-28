package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.entidades.Actor;
import co.edu.uniquindio.proyecto.entidades.Teatro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeatroRepo extends JpaRepository<Teatro, Integer> {

    @Query("Select t from Teatro t join t.ciudad c where c.nombre=:nombreCiudad")
    List<Teatro> buscarTeatrosPorCiudad(String nombreCiudad);

}
