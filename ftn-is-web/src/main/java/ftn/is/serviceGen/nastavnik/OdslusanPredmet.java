
package ftn.is.serviceGen.nastavnik;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for odslusanPredmet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="odslusanPredmet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="odslusan" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="odslusanPredmetId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="predmet" type="{http://service.is.ftn/}predmet" minOccurs="0"/>
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
@XmlType(name = "odslusanPredmet", propOrder = {
    "odslusan",
    "odslusanPredmetId",
    "predmet",
    "student"
})
public class OdslusanPredmet {

    protected boolean odslusan;
    protected int odslusanPredmetId;
    protected Predmet predmet;
    protected Student student;

    /**
     * Gets the value of the odslusan property.
     * 
     */
    public boolean getOdslusan() {
        return odslusan;
    }

    /**
     * Sets the value of the odslusan property.
     * 
     */
    public void setOdslusan(boolean value) {
        this.odslusan = value;
    }

    /**
     * Gets the value of the odslusanPredmetId property.
     * 
     */
    public int getOdslusanPredmetId() {
        return odslusanPredmetId;
    }

    /**
     * Sets the value of the odslusanPredmetId property.
     * 
     */
    public void setOdslusanPredmetId(int value) {
        this.odslusanPredmetId = value;
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
