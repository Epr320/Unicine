package co.edu.uniquindio.proyecto.converter;

import co.edu.uniquindio.proyecto.Interfaces.CiudadServicio;
import co.edu.uniquindio.proyecto.Repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.entidades.Ciudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.management.relation.Role;
import java.io.Serializable;

@Component
public class CiudadConverter implements Converter<Ciudad>, Serializable {

    @Autowired
    private CiudadServicio ciudadServicio;

    @Autowired
    private CiudadServicio ciudadRepo;

    @Override
    public Ciudad getAsObject(FacesContext arg0, UIComponent arg1, String value) {
        Ciudad c = null;
        if (value != null && !"".equals(value)) {
            try {
                c = ciudadRepo.obtenerCiudad(Integer.parseInt(value)); //Hacer casting si es necesario
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(arg1.getClientId() + ":id no válido"));
            }
        }
        return c;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Ciudad value) {
        if (value != null) {
            return value.getCodigo().toString();
        }
        return "";
    }
}
