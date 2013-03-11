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
@FacesConverter(forClass=Grupa.class)
public class GrupaConverter implements Converter {

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return (value instanceof Grupa) ? String.valueOf(((Grupa)value).getGrupaId()) : null;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        
        int id = Integer.parseInt(value);

        if(component.getId().equals("pripadnostGrupe")){
        	//Konverter pozvan sa stranice nastavnikPripadnost, pa treba da vrati objekat iz tog bina
        	NastavnikPripadnost nasPrip = context.getApplication().evaluateExpressionGet(context, "#{nastavnikPripadnost}", NastavnikPripadnost.class);
            for (Grupa grupa : nasPrip.getGrupe())
                if (grupa.getGrupaId()==id)
                    return grupa;
        }else 
        	if(component.getId().equals("prisustvoGrupe")){
            	NastavnikPrisustvo nasPris = context.getApplication().evaluateExpressionGet(context, "#{nastavnikPrisustvo}", NastavnikPrisustvo.class);
                for (Grupa grupa : nasPris.getGrupe())
                    if (grupa.getGrupaId()==id)
                        return grupa;
        	}else
            	if(component.getId().equals("obavezeGrupe")){
                	NastavnikObaveze nasObav = context.getApplication().evaluateExpressionGet(context, "#{nastavnikObaveze}", NastavnikObaveze.class);
                    for (Grupa grupa : nasObav.getGrupe())
                        if (grupa.getGrupaId()==id)
                            return grupa;
            	}
        
        throw new ConverterException(new FacesMessage(String.format("Cannot convert %s to Grupa", value)));
    }

}
