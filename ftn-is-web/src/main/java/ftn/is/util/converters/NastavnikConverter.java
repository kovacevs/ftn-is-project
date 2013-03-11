package ftn.is.util.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import ftn.is.controller.*;
import ftn.is.serviceGen.administrator.*;


@FacesConverter(forClass=Nastavnik.class)
public class NastavnikConverter implements Converter {

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return (value instanceof Nastavnik) ? String.valueOf(((Nastavnik)value).getNastavnikId()) : null;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        AdminController admController = context.getApplication().evaluateExpressionGet(context, "#{adminController}", AdminController.class);
        int id = Integer.parseInt(value);
        for (Nastavnik nas : admController.getNastavnici()) {
            if (nas.getNastavnikId()==id) {
                return nas;
            }
        }

        throw new ConverterException(new FacesMessage(String.format("Cannot convert %s to Nastavnik", value)));
    }

}
