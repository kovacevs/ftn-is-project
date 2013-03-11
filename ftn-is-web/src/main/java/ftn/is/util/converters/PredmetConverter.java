package ftn.is.util.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import ftn.is.controller.*;
import ftn.is.serviceGen.nastavnik.*;

/*
 * Ovaj konverter nam je potreban za dodavanje objekta nastavnik u SelectOneMeny na stranici
 * posto je za dodavanje objekta potrebno prebaciti ga u string, bez ovog konvertera
 * dobijamo exception no converter for class... a ovako je jos bolje jer u html stranicu
 * ne serijalizujemo ceo objekat nego stavljamo samo njegov ID.
 * (da bi sve radilo ocekivano potrebna je i equals metoda u originalnom objektu
 * - rucno je potrebno dodati ovu metodu u generisanu klasu Nastavnik)
 */
@FacesConverter(forClass=Predmet.class)
public class PredmetConverter implements Converter {

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return (value instanceof Predmet) ? String.valueOf(((Predmet)value).getPredmetId()) : null;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        NastavnikGrupe nasGrupe = context.getApplication().evaluateExpressionGet(context, "#{nastavnikGrupe}", NastavnikGrupe.class);
        //ISPITATI - ako je pozvano iz drugog bina ovo nece raditi
        //iz NastavnikPripadnost (ustvari ovo hoce, jer za jednog nastavnika uvek su isti predmeti)
        int id = Integer.parseInt(value);
        for (Predmet pred : nasGrupe.getPredmeti()) {
            if (pred.getPredmetId()==id) {
                return pred;
            }
        }

        throw new ConverterException(new FacesMessage(String.format("Cannot convert %s to Predmet", value)));
    }

}
