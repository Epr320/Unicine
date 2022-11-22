package co.edu.uniquindio.proyecto.Bean;

import co.edu.uniquindio.proyecto.Interfaces.AdministradorCiudadServicio;
import co.edu.uniquindio.proyecto.Interfaces.AdministradorServicio;
import co.edu.uniquindio.proyecto.Interfaces.ClienteServicio;
import co.edu.uniquindio.proyecto.Interfaces.PersonaServicio;
import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.entidades.AdministradorCiudad;
import co.edu.uniquindio.proyecto.entidades.Cliente;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.time.LocalDateTime;

@Component
@ViewScoped
public class IniciarSesionBean implements Serializable {

    @Getter
    @Value("#{param['cedula']}")
    private String cedula;

    @Getter
    @Setter
    private String correo;

    @Getter @Setter
    private String contraseña;

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private AdministradorCiudadServicio administradorCiudadServicio;

    @Autowired
    private AdministradorServicio administradorServicio;

    @Autowired
    private PersonaServicio personaServicio;

    public String iniciarSesion() {
        int tipoPersona= 0;
        try {
            tipoPersona = personaServicio.verificarTipoDeUsuario(correo);
            if(tipoPersona==3){
                Cliente cliente=clienteServicio.login(correo,contraseña);
                return "SeleccionarTeatro.xhtml?faces-redirect=true&amp;cedula="+cliente.getCedula();
            }
            if(tipoPersona==2){
                AdministradorCiudad administradorCiudad = administradorCiudadServicio.login(correo,contraseña);
                return "empleado_index.xhtml?faces-redirect=true&amp;cedula="+administradorCiudad.getCedula();
            }
            if(tipoPersona==1){
                Administrador administrador = administradorServicio.login(correo,contraseña);
                return "administrador_index.xhtml?faces-redirect=true&amp;cedula="+administrador.getCedula();
            }
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }


        return null;
    }

}
