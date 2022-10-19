package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.entidades.Actor;
import co.edu.uniquindio.proyecto.entidades.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.ListResourceBundle;

@Repository
public interface SalaRepo extends JpaRepository<Sala, Integer> {

    @Query("select s from Sala s where s.teatro.codigo=:codigo")
    List<Sala> buscarSalasPorTeatro(Integer codigo);
}
