package co.edu.uniquindio.proyecto.Bean;

import co.edu.uniquindio.proyecto.Interfaces.*;
import co.edu.uniquindio.proyecto.entidades.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Scope("session")
@Component
public class SeguridadBean implements Serializable {

    @Getter
    @Setter
    @NotBlank
    private String correo, emailR, contraseña;

    @Getter
    @Setter
    private boolean autenticado;

    @Getter
    @Setter
    private boolean autenticadoA;

    @Getter
    @Setter
    private boolean autenticadoAC;

    @Getter
    @Setter
    private Persona usuarioSeccion;

    @Getter
    @Setter
    private Administrador administradorSeccion;

    @Autowired
    private PersonaServicio personaServicio;

    @Autowired
    private AdministradorServicio administradorServicio;

    @Autowired
    ClienteServicio clienteServicio;

    @Autowired
    AdministradorCiudadServicio administradorCiudadServicio;

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
    private Ciudad city;

    @Getter @Setter
    private String teatro1;

    @Getter @Setter
    int teatroCodigo;
    @PostConstruct
    public void inicializar() {
        autenticado = false;
        autenticadoA = false;
        autenticadoAC = false;
        teatroCodigo=0;
        ciudades=ciudadServicio.listar();
    }
    public String iniciarSesion() {
        int tipoPersona = 0;
        usuarioSeccion=new Persona();
        if (!correo.isEmpty() && !contraseña.isEmpty()) {
            try {
                tipoPersona = personaServicio.verificarTipoDeUsuario(correo);
                if (tipoPersona == 3) {
                    Cliente cliente = clienteServicio.login(correo, contraseña);
                    autenticado = true;
                    usuarioSeccion=cliente;
                    return "cliente_index.xhtml?faces-redirect=true&amp;";
                }
                if (tipoPersona == 2) {
                    AdministradorCiudad administradorCiudad = administradorCiudadServicio.login(correo, contraseña);
                    autenticadoAC = true;
                    usuarioSeccion=administradorCiudad;
                    return "empleado_index.xhtml?faces-redirect=true&amp;cedula=" + administradorCiudad.getCedula();
                }
                if (tipoPersona == 1) {
                    Administrador administrador = administradorServicio.login(correo, contraseña);
                    autenticadoA = true;
                    usuarioSeccion=administrador;
                    return "administrador_index.xhtml?faces-redirect=true&amp;cedula=" + administrador.getCedula();
                }
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
            return null;
        }

    public void iniciarSesion1() {
    System.out.println(city.toString());

    }

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }
}


