package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.entidades.Confiteria;
import co.edu.uniquindio.proyecto.entidades.Cupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CuponRepo extends JpaRepository<Cupon, Integer> {

    @Query("select c from Cupon c where c.nombre=:nombre")
    Optional<Cupon> buscarPorNombre(String nombre);
}
