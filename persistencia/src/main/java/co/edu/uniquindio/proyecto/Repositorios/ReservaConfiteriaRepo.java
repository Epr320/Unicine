package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.entidades.Actor;
import co.edu.uniquindio.proyecto.entidades.Reserva_Confiteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaConfiteriaRepo extends JpaRepository<Reserva_Confiteria, Integer> {

    @Query("select c from Reserva_Confiteria  c where c.reserva.codigo=:codigo")
    List<Reserva_Confiteria> buscarPorReserva(Integer codigo);
}
