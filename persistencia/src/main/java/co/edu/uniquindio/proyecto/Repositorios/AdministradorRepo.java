package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.entidades.Actor;
import co.edu.uniquindio.proyecto.entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRepo extends JpaRepository<AdministradorRepo, String> {

    Optional<Administrador> findByEmailAndPassword(String email, String password);

    Optional<Administrador> findByEmail(String email);
}
