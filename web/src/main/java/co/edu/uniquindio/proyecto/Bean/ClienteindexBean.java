package co.edu.uniquindio.proyecto.Bean;

import co.edu.uniquindio.proyecto.Interfaces.PeliculaServicio;
import co.edu.uniquindio.proyecto.entidades.Pelicula;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.ResponsiveOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class ClienteindexBean {
    @Getter
    @Value("#{param['teatro']}")
    private String teatro;


    @Autowired
    PeliculaServicio peliculaServicio;

    @Getter @Setter
    private List<ResponsiveOption> responsiveOptions;
    @Getter @Setter
    private List<Pelicula> peliculascarousel=new ArrayList<>();

    @Getter @Setter
    private String busqueda;

    @PostConstruct
    public void init() {
       peliculascarousel=peliculaServicio.listarPeliculasCartelera();
        responsiveOptions = new ArrayList<>();
        responsiveOptions.add(new ResponsiveOption("1024px", 3, 3));
        responsiveOptions.add(new ResponsiveOption("768px", 2, 2));
        responsiveOptions.add(new ResponsiveOption("560px", 1, 1));
     peliculascarousel=peliculascarousel;
    }

    public String buscar(){
        return "/usuario/listapeliculas.xhtml?faces-redirect=true&amp;teatro="+teatro+"&amp;busqueda="+busqueda;

    }
    public String detallePelicula(Integer pelicula){
        return "/usuario/detallePelicula.xhtml?faces-redirect=true&amp;pelicula="+pelicula;
    }
}
