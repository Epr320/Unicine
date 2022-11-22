package co.edu.uniquindio.proyecto.Bean;

import co.edu.uniquindio.proyecto.Interfaces.ClienteServicio;
import co.edu.uniquindio.proyecto.entidades.Cliente;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class RegistrarUsuarioBean implements Serializable {

    @Getter
    @Setter
    private String correo;

    @Getter @Setter
    private String contraseña;

    @Getter
    @Setter
    private String nombre;

    @Getter @Setter
    private String cedula;

    @Autowired
    private ClienteServicio clienteServicio;

    public void registrar() {

        try {
            Cliente cliente=new Cliente(cedula,nombre,correo,contraseña);
          //  clienteServicio.registarCliente(cliente);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Exitoso", "Registro Exitoso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }
}
