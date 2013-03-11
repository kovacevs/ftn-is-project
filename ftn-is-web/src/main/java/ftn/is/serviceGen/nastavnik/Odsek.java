
package ftn.is.serviceGen.nastavnik;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for odsek complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="odsek">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="odsekId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "odsek", propOrder = {
    "odsekId",
    "naziv"
})
public class Odsek {

    protected int odsekId;
    protected String naziv;

    /**
     * Gets the value of the odsekId property.
     * 
     */
    public int getOdsekId() {
        return odsekId;
    }

    /**
     * Sets the value of the odsekId property.
     * 
     */
    public void setOdsekId(int value) {
        this.odsekId = value;
    }

    /**
     * Gets the value of the naziv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaziv(String value) {
        this.naziv = value;
    }
    
	//Ova metoda je potrebna za ubacivanje objekta u SelectOneMeny u jsf (pored konvertera)
	public boolean equals(Object other) {
	    return other instanceof Odsek ? odsekId == ((Odsek)other).odsekId : other == this;
	}
}
