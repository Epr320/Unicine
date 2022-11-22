package co.edu.uniquindio.proyecto.Bean;

import co.edu.uniquindio.proyecto.Interfaces.CiudadServicio;
import co.edu.uniquindio.proyecto.Interfaces.TeatroServicio;
import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Teatro;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class SeleccionarTeatroBean {


    @Autowired
    TeatroServicio teatroServicio;

    @Autowired
    CiudadServicio ciudadServicio;

    @Getter @Setter
    List<Ciudad> ciudades = new ArrayList<>();

    @Getter @Setter
    List<String> ciudades2 = new ArrayList<>();

    @Getter @Setter
    List<Teatro> teatros;

    @Getter @Setter
    List<String> teatros2 ;

    @Getter @Setter
    private String city;

    @Getter @Setter
    private String teatro1;

    @PostConstruct
    public void init() {
        ciudades=ciudadServicio.listar();
        for(int i = 0 ; i<ciudades.size();i++){
            ciudades2.add(ciudades.get(i).getNombre());
        }
    }
    public void onCountryChange() {
        if (city != null && !"".equals(city)) {
            try {
                Ciudad ciudad =ciudadServicio.buscarCiudad(city);
                teatros = teatroServicio.buscarTeatroPorCiudad(ciudad.getCodigo());
                teatros2= new ArrayList<>();
                for(int i=0;i<teatros.size();i++){
                    teatros2.add(teatros.get(i).getNombre());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else {
            teatros2 = new ArrayList<>();
        }
    }
    public String iniciarSesion() {

        Teatro teatro = teatroServicio.buscarTeatroPorNombreYCiudad(teatro1,city);
        return "cliente_index.xhtml?faces-redirect=true&amp;"+teatro.getCodigo();
    }

}
