package co.edu.uniquindio.proyecto.Bean;

import ch.qos.logback.classic.util.LogbackMDCAdapter;
import co.edu.uniquindio.proyecto.Interfaces.ConfiteriaServicio;
import co.edu.uniquindio.proyecto.Interfaces.PeliculaServicio;
import co.edu.uniquindio.proyecto.Servicios.CloudinaryServicio;
import co.edu.uniquindio.proyecto.entidades.Confiteria;
import co.edu.uniquindio.proyecto.entidades.Pelicula;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@ViewScoped
@Component
public class ConfiteriaBean {
    @Autowired
    ConfiteriaServicio teatroServicio;

    @Getter
    @Setter
    List<Confiteria> teatroList;

    @Getter @Setter
    List<Confiteria> selectedTeatros;
    @Getter @Setter
    private Confiteria selectedTeatro;

    @Getter @Setter
    Confiteria teatroSeleccionado;

    @Autowired
    CloudinaryServicio cloudinaryService;

    @PostConstruct
    public void init() {

        teatroList=teatroServicio.listarConfiteria();
    }


    public void openNew(){
        this.selectedTeatro=new Confiteria();
    }
    public String getDeleteButtonMessage() {
        if (hasSelectedProducts()) {
            int size = this.selectedTeatros.size();
            return size > 1 ? size + " products selected" : "1 product selected";
        }

        return "Delete";
    }
    public boolean hasSelectedProducts() {
        return this.selectedTeatros != null && !this.selectedTeatros.isEmpty();
    }
    public void deleteSelectedProducts() {
        this.teatroList.removeAll(this.selectedTeatros);
        for(int i=0;i<this.selectedTeatros.size();i++){
            try {
                teatroServicio.eliminarProducto(this.selectedTeatros.get(i).getCodigo());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            this.selectedTeatros = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Products Removed"));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
            PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
        }

    }
    public void saveProduct() {
        if (this.selectedTeatro.getCodigo() == null) {
            try {
                teatroServicio.actualizarProducto(this.selectedTeatro);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            this.teatroList=teatroServicio.listarConfiteria();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Added"));
        }
        else {
            try {
                teatroServicio.actualizarProducto(this.selectedTeatro);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Updated"));
        }

        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }
    public void deleteProduct() {
        this.teatroList.remove(this.selectedTeatro);
        try {
            teatroServicio.eliminarProducto(this.selectedTeatro.getCodigo());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.selectedTeatro = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }
    public void subirImagenes(FileUploadEvent event) throws IOException {
        UploadedFile imagen = event.getFile();
        Map resultado = null;
        try {
            resultado = cloudinaryService.subirImagen(convertirUploadedFile(imagen),"confiteria");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        LogbackMDCAdapter imagenes;
        selectedTeatro.setRuta(resultado.get("url").toString());
    }
    private File convertirUploadedFile(UploadedFile uploadedFile) throws IOException {
        File file = new File(uploadedFile.getFileName());
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(uploadedFile.getContent());
        return file;
    }
}