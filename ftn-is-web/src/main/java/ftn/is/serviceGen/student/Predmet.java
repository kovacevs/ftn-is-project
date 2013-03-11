
package ftn.is.serviceGen.student;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for predmet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="predmet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="predmetId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nastavnik" type="{http://service.is.ftn/}nastavnik" minOccurs="0"/>
 *         &lt;element name="odsek" type="{http://service.is.ftn/}odsek" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "predmet", propOrder = {
    "predmetId",
    "naziv",
    "nastavnik",
    "odsek"
})
public class Predmet {

    protected int predmetId;
    protected String naziv;
    protected Nastavnik nastavnik;
    protected Odsek odsek;

    /**
     * Gets the value of the predmetId property.
     * 
     */
    public int getPredmetId() {
        return predmetId;
    }

    /**
     * Sets the value of the predmetId property.
     * 
     */
    public void setPredmetId(int value) {
        this.predmetId = value;
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
     * Gets the value of the nastavnik property.
     * 
     * @return
     *     possible object is
     *     {@link Nastavnik }
     *     
     */
    public Nastavnik getNastavnik() {
        return nastavnik;
    }

    /**
     * Sets the value of the nastavnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link Nastavnik }
     *     
     */
    public void setNastavnik(Nastavnik value) {
        this.nastavnik = value;
    }

    /**
     * Gets the value of the odsek property.
     * 
     * @return
     *     possible object is
     *     {@link Odsek }
     *     
     */
    public Odsek getOdsek() {
        return odsek;
    }

    /**
     * Sets the value of the odsek property.
     * 
     * @param value
     *     allowed object is
     *     {@link Odsek }
     *     
     */
    public void setOdsek(Odsek value) {
        this.odsek = value;
    }

}
