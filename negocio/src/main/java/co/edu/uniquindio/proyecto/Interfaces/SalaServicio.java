package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.entidades.Sala;
import co.edu.uniquindio.proyecto.entidades.Teatro;

import java.util.List;

public interface SalaServicio {
    Sala crearSala(int numfilas, int numColumnas, int numAsientos, Integer codigoteatro)throws Exception;
    Sala actualizarSala(Sala sala)throws Exception;
    Boolean eliminarSala(Integer codigo)throws Exception;
    List<Sala> buscarSalaPorTeatro(Integer codigo)throws Exception;

    List<Sala> listar(String cedula);

    Sala obtenerSala(Integer parseInt);


}
