package co.edu.uniquindio.proyecto.Bean;

import co.edu.uniquindio.proyecto.Interfaces.HorarioServicio;
import co.edu.uniquindio.proyecto.Interfaces.PeliculaServicio;
import co.edu.uniquindio.proyecto.Interfaces.SalaServicio;
import co.edu.uniquindio.proyecto.Interfaces.TeatroServicio;
import co.edu.uniquindio.proyecto.entidades.*;
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
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class HorarioBean {

    @Value(value = "#{seguridadBean.usuarioSeccion}")
    private Persona usuarioSesion;
    @Autowired
    HorarioServicio teatroServicio;

    @Getter
    @Setter
    List<Horario> teatroList;

    @Getter @Setter
    List<Horario> selectedTeatros;

    @Getter @Setter
    private Horario selectedTeatro;

    @Getter @Setter
    Horario teatroSeleccionado;

    @Getter @Setter
    List<Pelicula> peliculaList;

    @Autowired
    PeliculaServicio peliculaServicio;

    @Getter @Setter
    List<Teatro> teatros;
    @Autowired
    TeatroServicio teatroServicio1;

    @Getter @Setter
    List<Sala> salasTeatro;

    @Autowired
    SalaServicio salaServicio;
    @PostConstruct
    public void init() {

        teatroList=teatroServicio.listarHorariosPorAdmin(usuarioSesion.getCedula());
        peliculaList=peliculaServicio.listarPeliculas();
        teatros=teatroServicio1.buscarTeatrosPorAdmin(usuarioSesion.getCedula());


    }

    public void onCountryChange() {
        if (selectedTeatro.getPeliculaSala().getSala().getTeatro() != null && !"".equals(selectedTeatro.getPeliculaSala().getSala().getTeatro())) {
            try {

                salasTeatro = salaServicio.buscarSalaPorTeatro(selectedTeatro.getPeliculaSala().getSala().getTeatro().getCodigo());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else {
            salasTeatro = new ArrayList<>();
        }
    }
    public void openNew(){
        this.selectedTeatro=new Horario();
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
                teatroServicio.eliminarHorario(this.selectedTeatros.get(i).getCodigo());
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
                teatroServicio.actualizarHorario(this.selectedTeatro);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            this.teatroList=teatroServicio.listarHorariosPorAdmin(usuarioSesion.getCedula());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Added"));
        }
        else {
            try {
                teatroServicio.actualizarHorario(this.selectedTeatro);
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
            teatroServicio.eliminarHorario(this.selectedTeatro.getCodigo());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.selectedTeatro = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }
}
