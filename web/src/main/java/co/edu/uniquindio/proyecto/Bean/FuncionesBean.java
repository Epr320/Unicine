package co.edu.uniquindio.proyecto.Bean;

import co.edu.uniquindio.proyecto.Interfaces.HorarioServicio;
import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Horario;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
@ViewScoped
public class FuncionesBean {

    @Getter
    @Value("#{param['fecha']}")
    private String fecha;

    @Value(value = "#{seguridadBean.city}")
    private Ciudad ciudad;
    @Getter
    @Value("#{param['pelicula']}")
    private String peliculacodigo;
    @Getter @Setter
    List<Horario> horarios;

    @Getter @Setter
    Horario selectedHorario;

    @Autowired
    HorarioServicio horarioServicio;

@PostConstruct
public void init(){

    horarios=horarioServicio.buscarHorarioPorPeliculaYFecha(fecha,peliculacodigo,ciudad.getCodigo());
}
public String detallePelicula(Integer codigo){
    return "/usuario/detalleCompra.xhtml?faces-redirect=true&amp;horario="+codigo;

}

}
