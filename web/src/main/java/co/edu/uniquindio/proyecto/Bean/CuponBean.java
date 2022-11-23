package co.edu.uniquindio.proyecto.Bean;

import ch.qos.logback.classic.util.LogbackMDCAdapter;
import co.edu.uniquindio.proyecto.Interfaces.ConfiteriaServicio;
import co.edu.uniquindio.proyecto.Interfaces.CuponServicio;
import co.edu.uniquindio.proyecto.Servicios.CloudinaryServicio;
import co.edu.uniquindio.proyecto.entidades.Confiteria;
import co.edu.uniquindio.proyecto.entidades.Cupon;
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
public class CuponBean {
    @Autowired
    CuponServicio teatroServicio;

    @Getter
    @Setter
    List<Cupon> teatroList;

    @Getter @Setter
    List<Cupon> selectedTeatros;
    @Getter @Setter
    private Cupon selectedTeatro;

    @Getter @Setter
    Cupon teatroSeleccionado;

    @Autowired
    CloudinaryServicio cloudinaryService;

    @PostConstruct
    public void init() {

        teatroList=teatroServicio.listarCupon();
    }


    public void openNew(){
        this.selectedTeatro=new Cupon();
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
                teatroServicio.eliminarCupon(this.selectedTeatros.get(i).getCodigo());
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
                teatroServicio.ActualizarCupon(this.selectedTeatro);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            this.teatroList=teatroServicio.listarCupon();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Added"));
        }
        else {
            try {
                teatroServicio.ActualizarCupon(this.selectedTeatro);
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
            teatroServicio.eliminarCupon(this.selectedTeatro.getCodigo());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.selectedTeatro = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

}