package co.edu.uniquindio.proyecto.Bean;

import co.edu.uniquindio.proyecto.Interfaces.HorarioServicio;
import co.edu.uniquindio.proyecto.Interfaces.ReservaConfiteriaServicio;
import co.edu.uniquindio.proyecto.Interfaces.ReservaServicio;
import co.edu.uniquindio.proyecto.entidades.Reserva;
import co.edu.uniquindio.proyecto.entidades.Reserva_Confiteria;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@ViewScoped
public class CompraFinalBean {


    @Getter
    @Value("#{param['reserva']}")
    private String reserva;

    @Getter
    @Value("#{param['precio']}")
    private String precioSillas;

    @Getter
    @Value("#{param['horario']}")
    private String horario;
    @Getter
    @Setter
    List<Reserva_Confiteria> reserva_confiteriaList;

    @Autowired
    ReservaConfiteriaServicio reservaConfiteriaServicio;

    @Autowired
    ReservaServicio reservaServicio;

    @Getter
    @Setter
    Reserva reserva1;

    @Getter
    @Setter
    double precioFinal;

    @Getter
    @Setter
    String cupon;

    @Getter
    @Setter
    List<String> medioPago =new ArrayList<>();

    @Autowired
    HorarioServicio horarioServicio;

    @PostConstruct
    public void init() {
        reserva_confiteriaList = reservaConfiteriaServicio.buscarPorReserva(Integer.parseInt(reserva));
        reserva1 = reservaServicio.obtenerReservar(Integer.parseInt(reserva));
        for (int i = 0; i < reserva_confiteriaList.size(); i++) {
            precioFinal = precioFinal+reserva_confiteriaList.get(i).getConfiteria().getPrecio() * reserva_confiteriaList.get(i).getCantidad();
        }
        precioFinal = precioFinal + Double.parseDouble(precioSillas);
        medioPago.add("Tarjeta de Credito");
        medioPago.add("Pse");
        medioPago.add("Cuenta ahorros");
        medioPago.add("PuntoFisico");
    }

    public String completarCompra() {
        LocalDate localDate1 = LocalDate.now();
        Date fecha1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
        reserva1.setFecha(fecha1);
        reserva1.setPrecio(precioFinal);
        reserva1.setHorario(horarioServicio.obtenerHorario(Integer.parseInt(horario)));

        reservaServicio.guardarReservarFinal(reserva1,cupon);
         return "/usuario/reservas.xhtml?faces-redirect=true&amp";
    }

}
