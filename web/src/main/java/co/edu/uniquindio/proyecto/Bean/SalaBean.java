package co.edu.uniquindio.proyecto.Bean;

import co.edu.uniquindio.proyecto.Interfaces.CuponServicio;
import co.edu.uniquindio.proyecto.Interfaces.SalaServicio;
import co.edu.uniquindio.proyecto.Interfaces.TeatroServicio;
import co.edu.uniquindio.proyecto.Servicios.CloudinaryServicio;
import co.edu.uniquindio.proyecto.entidades.Cupon;
import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.entidades.Sala;
import co.edu.uniquindio.proyecto.entidades.Teatro;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.util.List;

@ViewScoped
@Component
public class SalaBean {

    @Value(value = "#{seguridadBean.usuarioSeccion}")
    private Persona usuarioSesion;

    @Autowired
    SalaServicio teatroServicio;

    @Getter
    @Setter
    List<Sala> teatroList;

    @Getter
    @Setter
    List<Teatro> teatros;

    @Autowired
    TeatroServicio teatroServicio1;
    @Getter @Setter
    List<Sala> selectedTeatros;
    @Getter @Setter
    private Sala selectedTeatro;

    @Getter @Setter
    Sala teatroSeleccionado;

    @Autowired
    CloudinaryServicio cloudinaryService;

    @PostConstruct
    public void init() {

        teatroList=teatroServicio.listar(usuarioSesion.getCedula());
        teatros=teatroServicio1.buscarTeatrosPorAdmin(usuarioSesion.getCedula());
    }


    public void openNew(){
        this.selectedTeatro=new Sala();
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
                teatroServicio.eliminarSala(this.selectedTeatros.get(i).getCodigo());
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
                teatroServicio.actualizarSala(this.selectedTeatro);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            this.teatroList=teatroServicio.listar(usuarioSesion.getCedula());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Added"));
        }
        else {
            try {
                teatroServicio.actualizarSala(this.selectedTeatro);
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
            teatroServicio.eliminarSala(this.selectedTeatro.getCodigo());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.selectedTeatro = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

}