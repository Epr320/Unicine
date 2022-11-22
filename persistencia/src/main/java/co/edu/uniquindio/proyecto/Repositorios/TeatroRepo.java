package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.entidades.Actor;
import co.edu.uniquindio.proyecto.entidades.Teatro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeatroRepo extends JpaRepository<Teatro, Integer> {

    @Query("Select t from Teatro t join t.ciudad c where c.nombre=:nombreCiudad")
    List<Teatro> buscarTeatrosPorCiudadNombre(String nombreCiudad);

    @Query("Select t from Teatro t join t.ciudad c where c.codigo=:codigo")
    List<Teatro> buscarTeatrosPorCiudadCodigo(Integer codigo);

    @Query("select t from Teatro t where t.nombre=:teatro  and t.ciudad.nombre=:ciudad")
    Teatro buscarTeatroPorCiudadYNombre(String teatro, String ciudad);

    @Query("select t from Teatro t join AdministradorCiudad  a on a.ciudad=t.ciudad where a.cedula=:cedula")
    List<Teatro> buscarTeatrosPorAdmin(String cedula);
}