package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.entidades.Entrada;
import co.edu.uniquindio.proyecto.entidades.Horario;

public interface EntradaServicio {

    Entrada crearEntrada(int fila, int column, Horario horario)throws Exception;

}
