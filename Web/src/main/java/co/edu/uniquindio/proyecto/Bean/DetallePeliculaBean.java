package co.edu.uniquindio.proyecto.Bean;

import co.edu.uniquindio.proyecto.Interfaces.PeliculaServicio;
import co.edu.uniquindio.proyecto.entidades.Pelicula;
import co.edu.uniquindio.proyecto.entidades.Persona;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
@ViewScoped
public class DetallePeliculaBean {

    @Getter
    @Value("#{param['teatro']}")
    private String teatro;


    @Getter
    @Value("#{param['pelicula']}")
    private String peliculacodigo;

    @Getter @Setter
    Pelicula pelicula;

    @Autowired
    PeliculaServicio peliculaServicio;

    @Getter @Setter
    LocalDateTime fechaFuncion;

    @PostConstruct
    public void init() {
        pelicula=peliculaServicio.obtenerPelicula(peliculacodigo);
    }

    public String verFunciones(){
        String fecha2=fechaFuncion.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return "/usuario/funciones.xhtml?faces-redirect=true&amp;fecha="+fecha2+"&amp;pelicula="+peliculacodigo;
    }
}
