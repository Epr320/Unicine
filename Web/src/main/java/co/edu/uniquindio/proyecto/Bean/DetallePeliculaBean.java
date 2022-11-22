package co.edu.uniquindio.proyecto.Bean;

import co.edu.uniquindio.proyecto.Interfaces.PeliculaServicio;
import co.edu.uniquindio.proyecto.entidades.Pelicula;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
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
    Date fechaFuncion;

    @PostConstruct
    public void init() {
        pelicula=peliculaServicio.obtenerPelicula(peliculacodigo);
    }
}
