
package ftn.is.serviceGen.nastavnik;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for prisustvo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="prisustvo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="prisustvoId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="prisutan" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="termin" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prisustvo", propOrder = {
    "prisustvoId",
    "prisutan",
    "termin"
})
public class Prisustvo {

    protected int prisustvoId;
    protected Boolean prisutan;
    @XmlSchemaType(name = "dateTime")
    protected Date termin;

    /**
     * Gets the value of the prisustvoId property.
     * 
     */
    public int getPrisustvoId() {
        return prisustvoId;
    }

    /**
     * Sets the value of the prisustvoId property.
     * 
     */
    public void setPrisustvoId(int value) {
        this.prisustvoId = value;
    }

    /**
     * Gets the value of the prisutan property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getPrisutan() {
        return prisutan;
    }

    /**
     * Sets the value of the prisutan property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPrisutan(Boolean value) {
        this.prisutan = value;
    }

    /**
     * Gets the value of the termin property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getTermin() {
        return termin;
    }

    /**
     * Sets the value of the termin property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTermin(Date value) {
        this.termin = value;
    }

}
