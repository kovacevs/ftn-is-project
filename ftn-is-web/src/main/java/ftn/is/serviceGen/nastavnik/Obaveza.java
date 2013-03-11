
package ftn.is.serviceGen.nastavnik;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for obaveza complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="obaveza">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="obavezaId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="student" type="{http://service.is.ftn/}student" minOccurs="0"/>
 *         &lt;element name="predmet" type="{http://service.is.ftn/}predmet" minOccurs="0"/>
 *         &lt;element name="ocena" type="{http://service.is.ftn/}ocena" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obaveza", propOrder = {
    "obavezaId",
    "naziv",
    "student",
    "predmet",
    "ocena"
})
public class Obaveza {

    protected int obavezaId;
    protected String naziv;
    protected Student student;
    protected Predmet predmet;
    @XmlElement(nillable = true)
    protected Ocena ocena;

    /**
     * Gets the value of the obavezaId property.
     * 
     */
    public int getObavezaId() {
        return obavezaId;
    }

    /**
     * Sets the value of the obavezaId property.
     * 
     */
    public void setObavezaId(int value) {
        this.obavezaId = value;
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
     * Gets the value of the ocena property.
     * 
     * @return
     *     possible object is
     *     {@link Ocena }
     *     
     */
    public Ocena getOcena() {
        return ocena;
    }

    /**
     * Sets the value of the ocena property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ocena }
     *     
     */
    public void setOcena(Ocena value) {
        this.ocena = value;
    }

}
