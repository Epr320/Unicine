package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.entidades.Actor;
import co.edu.uniquindio.proyecto.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepo extends JpaRepository<Reserva, Integer> {
    @Query("select r from Reserva r where r.cliente.cedula=:cedula")
    List<Reserva> obtenerReservasPorCliente(String cedula);
}
