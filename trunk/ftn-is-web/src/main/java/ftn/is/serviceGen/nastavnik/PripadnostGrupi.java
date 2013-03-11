
package ftn.is.serviceGen.nastavnik;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pripadnostGrupi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pripadnostGrupi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pripadnostId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="student" type="{http://service.is.ftn/}student" minOccurs="0"/>
 *         &lt;element name="grupa" type="{http://service.is.ftn/}grupa" minOccurs="0"/>
 *         &lt;element name="prisustva" type="{http://service.is.ftn/}prisustvo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pripadnostGrupi", propOrder = {
    "pripadnostId",
    "student",
    "grupa",
    "prisustva"
})
public class PripadnostGrupi {

    protected int pripadnostId;
    protected Student student;
    protected Grupa grupa;
    @XmlElement(nillable = true)
    protected List<Prisustvo> prisustva;

    /**
     * Gets the value of the pripadnostId property.
     * 
     */
    public int getPripadnostId() {
        return pripadnostId;
    }

    /**
     * Sets the value of the pripadnostId property.
     * 
     */
    public void setPripadnostId(int value) {
        this.pripadnostId = value;
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
     * Gets the value of the grupa property.
     * 
     * @return
     *     possible object is
     *     {@link Grupa }
     *     
     */
    public Grupa getGrupa() {
        return grupa;
    }

    /**
     * Sets the value of the grupa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Grupa }
     *     
     */
    public void setGrupa(Grupa value) {
        this.grupa = value;
    }

    /**
     * Gets the value of the prisustva property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prisustva property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrisustva().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Prisustvo }
     * 
     * 
     */
    public List<Prisustvo> getPrisustva() {
        if (prisustva == null) {
            prisustva = new ArrayList<Prisustvo>();
        }
        return this.prisustva;
    }

}
