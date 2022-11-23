package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.entidades.Actor;
import co.edu.uniquindio.proyecto.entidades.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface HorarioRepo extends JpaRepository<Horario, Integer> {
    @Query("select  h from Horario h where h.peliculaSala.pelicula.nombre=:nombre")
    List<Horario> buscarPorPelicula(String nombre);


    @Query("select  h from Horario h where h.fecha=:fecha and  h.peliculaSala.pelicula.codigo=:pelicula and h.peliculaSala.sala.teatro.codigo=:teatro")
    List<Horario> buscarPorPeliculaYTeatro(Integer pelicula, Integer teatro, Date fecha);
    @Query("select  h from Horario h where h.peliculaSala.sala.teatro.codigo=:codigo")
     List<Horario> buscarPorTeatro(Integer codigo);

    @Query("select  h from Horario h where h.peliculaSala.pelicula.codigo=:codigo")
    List<Horario> buscarPorPelicula(Integer codigo);

    @Query("select h from Horario h join AdministradorCiudad a on a.ciudad=h.peliculaSala.sala.teatro.ciudad where a.cedula=:cedula")
    List<Horario> listarHorariosPorAdmin(String cedula);

    @Query("select h from Horario h where h.fecha=:fecha and h.peliculaSala.pelicula.codigo=:codigo and h.peliculaSala.sala.teatro.ciudad.codigo=:codigoCiudad")
    List<Horario> buscarHorarioPorPeliculaYFecha(Date fecha,Integer codigo,Integer codigoCiudad);
}
