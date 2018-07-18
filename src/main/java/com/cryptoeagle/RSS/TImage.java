package com.cryptoeagle.RSS;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tImage", propOrder = {
        "url",
        "title",
        "link",
        "width",
        "height",
        "description"
})
public class TImage {

    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String url;
    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String link;
    @XmlElement(defaultValue = "88")
    protected Integer width;
    @XmlElement(defaultValue = "31")
    protected Integer height;
    protected String description;

    /**
     * Gets the value of the url property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the title property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the link property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets the value of the link property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLink(String value) {
        this.link = value;
    }

    /**
     * Gets the value of the width property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setWidth(Integer value) {
        this.width = value;
    }

    /**
     * Gets the value of the height property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setHeight(Integer value) {
        this.height = value;
    }

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

}