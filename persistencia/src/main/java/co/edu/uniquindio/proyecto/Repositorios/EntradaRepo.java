package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.entidades.Entrada;
import co.edu.uniquindio.proyecto.entidades.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EntradaRepo extends JpaRepository<Entrada, Integer> {

   @Query("select e from Entrada e where e.fila=:fila and e.columna=:columna and e.horario=:horario")
    Boolean buscarSillaOcupadada(int fila, int columna, Horario horario);
}
