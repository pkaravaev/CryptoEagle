package com.cryptoeagle.RSS;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tGuid", propOrder = {
        "value"
})
public class TGuid {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "isPermaLink")
    protected Boolean isPermaLink;

    /**
     * Gets the value of the value property.
     *
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
     * Gets the value of the isPermaLink property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public boolean isIsPermaLink() {
        if (isPermaLink == null) {
            return true;
        } else {
            return isPermaLink;
        }
    }

    /**
     * Sets the value of the isPermaLink property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setIsPermaLink(Boolean value) {
        this.isPermaLink = value;
    }

}