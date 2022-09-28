package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.entidades.Actor;
import co.edu.uniquindio.proyecto.entidades.AdministradorCiudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorCiudadRepo extends JpaRepository<AdministradorCiudad, String> {

    Optional<AdministradorCiudad> findByEmailAndAndPassword(String email, String password);

    Optional<AdministradorCiudad> findByCodigo(Integer codigo);

    boolean existsByCodigo(Integer codigo);

    Optional<AdministradorCiudad> deleteByCodigo(Integer codigo);

    Optional<AdministradorCiudad> findByNombre(String nombre);

    @Query("select a from AdministradorCiudad a where upper(a.nombre) = :nombre ")
    Optional<AdministradorCiudad> buscarPorNombre(String nombre);

    Optional<AdministradorCiudad> findByEmail(String email);

    @Query("select c.adminsC from Ciudad c where c.codigo = :codigo")
    Optional<AdministradorCiudad> buscarPorCodigoDeHotel(Integer codigo);
}
