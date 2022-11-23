package co.edu.uniquindio.proyecto.Bean;

import co.edu.uniquindio.proyecto.Interfaces.*;
import co.edu.uniquindio.proyecto.entidades.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class detalleCompraBean {

    @Value(value = "#{seguridadBean.usuarioSeccion}")
    private Persona usuarioSesion;

    @Getter
    @Value("#{param['horario']}")
    private String horario;

    @Getter @Setter
    int numSillas =1;

    double precioSillas;

    @Getter @Setter
    List<Confiteria> confiteriaList;

    @Getter @Setter
    Horario horario1;


    @Autowired
    HorarioServicio horarioServicio;
    @Autowired
    ConfiteriaServicio confiteriaServicio;

    @Getter @Setter
    List<Reserva_Confiteria> confiterias = new ArrayList<>();

    @Getter @Setter
    List<Reserva_Confiteria> confiteriasC = new ArrayList<>();

    @Autowired
    ReservaConfiteriaServicio rconfiteriaServicio;

    @Autowired
    ReservaServicio reservaServicio;

    @Autowired
    ClienteServicio clienteServicio;

    @PostConstruct
    public void init(){
        confiteriaList=confiteriaServicio.listarConfiteria();
        horario1=horarioServicio.obtenerHorario(Integer.parseInt(horario));
        for (int i=0;i<confiteriaList.size();i++){
            Reserva_Confiteria reserva_confiteria=new Reserva_Confiteria();
            reserva_confiteria.setConfiteria(confiteriaList.get(i));
            reserva_confiteria.setCantidad(0);
            confiterias.add(reserva_confiteria);
        }


    }

    public void aumentarCantidad(Integer codigo){
        Boolean bandera =false;
        for (int i=0;i<confiterias.size();i++){
            if(confiterias.get(i).getConfiteria().getCodigo()==codigo){
                confiterias.get(i).setCantidad(confiterias.get(i).getCantidad()+1);

                }


        }
    }
    public void disminuirCantidad(Integer codigo){
        for (int i=0;i<confiterias.size();i++){
            if(confiterias.get(i).getConfiteria().getCodigo()==codigo){
                confiterias.get(i).setCantidad(confiterias.get(i).getCantidad()-1);
            }
        }
    }
    public String completarReservas(){
        Reserva reserva = new Reserva();
        try {
            reserva.setCliente(clienteServicio.buscarClientePorCedula(usuarioSesion.getCedula()));
            reserva=reservaServicio.crearReserva(reserva);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for(int i=0;i<confiterias.size();i++){
            if(confiterias.get(i).getCantidad()>0){
                confiterias.get(i).setReserva(reserva);
                confiteriasC.add(confiterias.get(i));
            }
        }


        List<Reserva_Confiteria> reservas= rconfiteriaServicio.guardarTodas(confiteriasC);
        precioSillas=numSillas*horario1.getPrecio();
        return "/usuario/finalizarCompra.xhtml?faces-redirect=true&amp;reserva="+reserva.getCodigo()+"&amp;precio="+precioSillas+"&amp;horario="+horario1.getCodigo();
    }

}
