
package ftn.is.serviceGen.student;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for prijavljenIspit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="prijavljenIspit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="predmet" type="{http://service.is.ftn/}predmet" minOccurs="0"/>
 *         &lt;element name="prijavljenIspitId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="student" type="{http://service.is.ftn/}student" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prijavljenIspit", propOrder = {
    "datum",
    "predmet",
    "prijavljenIspitId",
    "student"
})
public class PrijavljenIspit {

    @XmlSchemaType(name = "dateTime")
    protected Date datum;
    protected Predmet predmet;
    protected int prijavljenIspitId;
    protected Student student;

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

    /**
     * Gets the value of the prijavljenIspitId property.
     * 
     */
    public int getPrijavljenIspitId() {
        return prijavljenIspitId;
    }

    /**
     * Sets the value of the prijavljenIspitId property.
     * 
     */
    public void setPrijavljenIspitId(int value) {
        this.prijavljenIspitId = value;
    }

    /**
     * Gets the value of the student property.
     * 
     * @return
     *     possible object is
     *     {@link Student }
     *     
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Sets the value of the student property.
     * 
     * @param value
     *     allowed object is
     *     {@link Student }
     *     
     */
    public void setStudent(Student value) {
        this.student = value;
    }

}
