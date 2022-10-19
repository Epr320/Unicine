package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.entidades.Actor;
import co.edu.uniquindio.proyecto.entidades.Cliente;
import co.edu.uniquindio.proyecto.entidades.Cupon;
import co.edu.uniquindio.proyecto.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, String> {

    Optional<Cliente> findByEmailAndPassword(String email, String Password);

    @Query("select c from Cupon c join c.reservas r join r.cliente cl where cl.cedula = :cedula")
    List<Cupon> buscarCuponesUsadosPorCliente(String cedula);

    @Query("select r from Reserva r where r.cliente.cedula=:cedula")
    List<Reserva> listarReservasPorCliente(String cedula);

    @Query("select c from Cliente  c where c.email=:email")
    Optional<Cliente> findByEmail(String email);

    @Query("select c.password from Cliente c where c.email = :email")
    String recuperarPasswordConEmail(String email);

}
