package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.EntradaServicio;
import co.edu.uniquindio.proyecto.Repositorios.EntradaRepo;
import co.edu.uniquindio.proyecto.entidades.Entrada;
import co.edu.uniquindio.proyecto.entidades.Horario;
import org.springframework.beans.factory.annotation.Autowired;

public class EntradaServicioImpl implements EntradaServicio {

    @Autowired
    EntradaRepo entradaRepo;

    @Override
    public Entrada crearEntrada(int fila, int columna, Horario horario) throws Exception {
        boolean ocupada = entradaRepo.buscarSillaOcupadada(fila,columna,horario);
        if(ocupada){
            throw new Exception("Silla ocupada");
        }
        Entrada entrada =new Entrada();
        entrada.setFila(fila);
        entrada.setColumna(columna);
        entrada.setHorario(horario);

        return entrada;
    }
}
