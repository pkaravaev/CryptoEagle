package com.cryptoeagle.RSS;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCloud")
public class TCloud {

    @XmlAttribute(name = "domain", required = true)
    protected String domain;
    @XmlAttribute(name = "port", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger port;
    @XmlAttribute(name = "path", required = true)
    protected String path;
    @XmlAttribute(name = "registerProcedure", required = true)
    protected String registerProcedure;
    @XmlAttribute(name = "protocol", required = true)
    protected TCloudProtocol protocol;

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

    /**
     * Gets the value of the port property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getPort() {
        return port;
    }

    /**
     * Sets the value of the port property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setPort(BigInteger value) {
        this.port = value;
    }

    /**
     * Gets the value of the path property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the value of the path property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPath(String value) {
        this.path = value;
    }

    /**
     * Gets the value of the registerProcedure property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRegisterProcedure() {
        return registerProcedure;
    }

    /**
     * Sets the value of the registerProcedure property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRegisterProcedure(String value) {
        this.registerProcedure = value;
    }

    /**
     * Gets the value of the protocol property.
     *
     * @return
     *     possible object is
     *     {@link TCloudProtocol }
     *
     */
    public TCloudProtocol getProtocol() {
        return protocol;
    }

    /**
     * Sets the value of the protocol property.
     *
     * @param value
     *     allowed object is
     *     {@link TCloudProtocol }
     *
     */
    public void setProtocol(TCloudProtocol value) {
        this.protocol = value;
    }

}