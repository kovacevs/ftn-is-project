package ftn.is.util.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import ftn.is.controller.*;
import ftn.is.serviceGen.administrator.*;


/*
 * Ovaj konverter nam je potreban za dodavanje objekta nastavnik u SelectOneMeny na stranici
 * posto je za dodavanje objekta potrebno prebaciti ga u string, bez ovog konvertera
 * dobijamo exception no converter for class... a ovako je jos bolje jer u html stranicu
 * ne serijalizujemo ceo objekat nego stavljamo samo njegov ID.
 * (da bi sve radilo ocekivano potrebna je i equals metoda u originalnom objektu
 * - rucno je potrebno dodati ovu metodu u generisanu klasu Nastavnik)
 */
@FacesConverter(forClass=Odsek.class)
public class OdsekConverter implements Converter {

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return (value instanceof Odsek) ? String.valueOf(((Odsek)value).getOdsekId()) : null;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        AdminController admController = context.getApplication().evaluateExpressionGet(context, "#{adminController}", AdminController.class);
        int id = Integer.parseInt(value);
        for (Odsek ods : admController.getOdseci()) {
            if (ods.getOdsekId()==id) {
                return ods;
            }
        }

        throw new ConverterException(new FacesMessage(String.format("Cannot convert %s to Odsek", value)));
    }

}
