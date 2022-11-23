package co.edu.uniquindio.proyecto.Bean;

import ch.qos.logback.classic.util.LogbackMDCAdapter;
import co.edu.uniquindio.proyecto.Interfaces.ClienteServicio;
import co.edu.uniquindio.proyecto.Servicios.CloudinaryServicio;
import co.edu.uniquindio.proyecto.entidades.Cliente;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

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

    @Getter @Setter
    private String ruta;

    @Autowired
    CloudinaryServicio cloudinaryService;

    @Autowired
    private ClienteServicio clienteServicio;

    public void registrar() {

        try {
            Cliente cliente=new Cliente(cedula,nombre,correo,contraseña);
            cliente.setRuta(ruta);
           clienteServicio.registrarCliente(cedula,nombre,correo,contraseña,null,ruta);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Exitoso", "Registro Exitoso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }
    public void subirImagenes(FileUploadEvent event) throws IOException {
        UploadedFile imagen = event.getFile();
        Map resultado = null;
        try {
            resultado = cloudinaryService.subirImagen(convertirUploadedFile(imagen),"peliculas");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        LogbackMDCAdapter imagenes;
        ruta=resultado.get("url").toString();
    }
    private File convertirUploadedFile(UploadedFile uploadedFile) throws IOException {
        File file = new File(uploadedFile.getFileName());
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(uploadedFile.getContent());
        return file;
    }
}
