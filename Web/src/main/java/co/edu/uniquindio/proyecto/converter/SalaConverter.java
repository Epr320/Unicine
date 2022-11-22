package co.edu.uniquindio.proyecto.converter;

import co.edu.uniquindio.proyecto.Interfaces.CiudadServicio;
import co.edu.uniquindio.proyecto.Interfaces.SalaServicio;
import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import java.io.Serializable;

@Component
public class SalaConverter implements Converter<Sala>, Serializable {
    @Autowired
    private SalaServicio ciudadRepo;

    @Override
    public Sala getAsObject(FacesContext arg0, UIComponent arg1, String value) {
        Sala c = null;
        if (value != null && !"".equals(value)) {
            try {
                c = ciudadRepo.obtenerSala(Integer.parseInt(value)); //Hacer casting si es necesario
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(arg1.getClientId() + ":id no válido"));
            }
        }
        return c;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Sala value) {
        if (value != null) {
            return value.getCodigo().toString();
        }
        return "";
    }
}
