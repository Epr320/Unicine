package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.entidades.Actor;
import co.edu.uniquindio.proyecto.entidades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CiudadRepo extends JpaRepository<Ciudad, Integer> {
    @Query("select c from Ciudad c where upper(c.nombre) = :nombre")
    Optional<Ciudad> buscarPorNombre(String nombre);

    @Query("select c from Ciudad c where upper(c.nombre) like concat('%', :nombre, '%')")
    Ciudad listarPorNombre(String nombre);

    List<Ciudad> findAll();
}
