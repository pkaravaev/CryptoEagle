package com.cryptoeagle.RSS;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCategory", propOrder = {
        "value"
})
public class TCategory {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "domain")
    protected String domain;

    /**
     * Gets the value of the value property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the domain property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Sets the value of the domain property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDomain(String value) {
        this.domain = value;
    }

}