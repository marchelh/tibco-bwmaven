//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.03 at 10:20:18 AM CEST 
//


package com.tibco.xmlns.bw.process._2003;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.tibco.com/bw/process/2003}NamedType">
 *       &lt;sequence>
 *         &lt;element ref="{http://xmlns.tibco.com/bw/process/2003}description" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="resourceType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="y" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="config" type="{http://www.w3.org/2001/XMLSchema}anyType" form="unqualified"/>
 *         &lt;element name="inputBindings" type="{http://xmlns.tibco.com/bw/process/2003}BindingSpec"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "description",
    "type",
    "resourceType",
    "x",
    "y",
    "config",
    "inputBindings"
})
@XmlRootElement(name = "activity")
public class Activity
    extends NamedType
{

    protected String description;
    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected String resourceType;
    protected int x;
    protected int y;
    @XmlElement(namespace = "", required = true)
    protected Object config;
    @XmlElement(required = true)
    protected BindingSpec inputBindings;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the resourceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     * Sets the value of the resourceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResourceType(String value) {
        this.resourceType = value;
    }

    /**
     * Gets the value of the x property.
     * 
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the value of the x property.
     * 
     */
    public void setX(int value) {
        this.x = value;
    }

    /**
     * Gets the value of the y property.
     * 
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the value of the y property.
     * 
     */
    public void setY(int value) {
        this.y = value;
    }

    /**
     * Gets the value of the config property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getConfig() {
        return config;
    }

    /**
     * Sets the value of the config property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setConfig(Object value) {
        this.config = value;
    }

    /**
     * Gets the value of the inputBindings property.
     * 
     * @return
     *     possible object is
     *     {@link BindingSpec }
     *     
     */
    public BindingSpec getInputBindings() {
        return inputBindings;
    }

    /**
     * Sets the value of the inputBindings property.
     * 
     * @param value
     *     allowed object is
     *     {@link BindingSpec }
     *     
     */
    public void setInputBindings(BindingSpec value) {
        this.inputBindings = value;
    }

}
