
package ftn.is.serviceGen.nastavnik;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ocena complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ocena">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ocenaId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ocena" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ocena", propOrder = {
    "ocenaId",
    "ocena",
    "datum"
})
public class Ocena {

    protected int ocenaId;
    protected int ocena;
    @XmlSchemaType(name = "dateTime")
    protected Date datum;

    /**
     * Gets the value of the ocenaId property.
     * 
     */
    public int getOcenaId() {
        return ocenaId;
    }

    /**
     * Sets the value of the ocenaId property.
     * 
     */
    public void setOcenaId(int value) {
        this.ocenaId = value;
    }

    /**
     * Gets the value of the ocena property.
     * 
     */
    public int getOcena() {
        return ocena;
    }

    /**
     * Sets the value of the ocena property.
     * 
     */
    public void setOcena(int value) {
        this.ocena = value;
    }

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatum(Date value) {
        this.datum = value;
    }

}
