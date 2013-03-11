
package ftn.is.serviceGen.nastavnik;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for grupa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="grupa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="grupaId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pocetakNastave" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="brojTermina" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="predmet" type="{http://service.is.ftn/}predmet" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "grupa", propOrder = {
    "grupaId",
    "pocetakNastave",
    "brojTermina",
    "predmet"
})
public class Grupa {

    protected int grupaId;
    @XmlSchemaType(name = "dateTime")
    protected Date pocetakNastave;
    protected int brojTermina;
    protected Predmet predmet;

    /**
     * Gets the value of the grupaId property.
     * 
     */
    public int getGrupaId() {
        return grupaId;
    }

    /**
     * Sets the value of the grupaId property.
     * 
     */
    public void setGrupaId(int value) {
        this.grupaId = value;
    }

    /**
     * Gets the value of the pocetakNastave property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getPocetakNastave() {
        return pocetakNastave;
    }

    /**
     * Sets the value of the pocetakNastave property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPocetakNastave(Date value) {
        this.pocetakNastave = value;
    }

    /**
     * Gets the value of the brojTermina property.
     * 
     */
    public int getBrojTermina() {
        return brojTermina;
    }

    /**
     * Sets the value of the brojTermina property.
     * 
     */
    public void setBrojTermina(int value) {
        this.brojTermina = value;
    }

    /**
     * Gets the value of the predmet property.
     * 
     * @return
     *     possible object is
     *     {@link Predmet }
     *     
     */
    public Predmet getPredmet() {
        return predmet;
    }

    /**
     * Sets the value of the predmet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Predmet }
     *     
     */
    public void setPredmet(Predmet value) {
        this.predmet = value;
    }

	//Ova metoda je potrebna za ubacivanje objekta u SelectOneMeny u jsf (pored konvertera)
	public boolean equals(Object other) {
	    return other instanceof Grupa ? grupaId == ((Grupa)other).grupaId : other == this;
	}
}
