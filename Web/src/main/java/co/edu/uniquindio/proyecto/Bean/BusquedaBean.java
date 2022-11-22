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
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class BusquedaBean {

    @Getter
    @Value("#{param['teatro']}")
    private String teatro;

    @Getter
    @Value("#{param['busqueda']}")
    private String busqueda;

    @Getter @Setter
    private List<Pelicula> peliculas =new ArrayList<>();

    @Autowired
    PeliculaServicio peliculaServicio;



    @PostConstruct
    public void init() {
        try {
            peliculas=peliculaServicio.buscarPeliculaPorNombre(busqueda);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public String detallePelicula(Integer pelicula){
         return "detallePelicula.xhtml?faces-redirect=true&amp;teatro="+teatro+"&amp;pelicula="+pelicula;
    }


}
