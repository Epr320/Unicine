package co.edu.uniquindio.proyecto.Bean;

import co.edu.uniquindio.proyecto.Interfaces.ReservaServicio;
import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.entidades.Reserva;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.util.List;

@Component
@ViewScoped
public class reservasBean {

    @Value(value = "#{seguridadBean.usuarioSeccion}")
    private Persona usuarioSesion;


    @Autowired
    ReservaServicio reservaServicio;

    @Getter @Setter
    List<Reserva> misReservas;

@PostConstruct
public void init (){
    misReservas=reservaServicio.obtenerReservasPorCliente(usuarioSesion.getCedula());
}


}
