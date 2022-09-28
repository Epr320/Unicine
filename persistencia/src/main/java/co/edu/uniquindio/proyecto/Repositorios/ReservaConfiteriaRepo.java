package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.entidades.Actor;
import co.edu.uniquindio.proyecto.entidades.Reserva_Confiteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaConfiteriaRepo extends JpaRepository<Reserva_Confiteria, Integer> {

}
