package com.cryptoeagle.RSS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "tCloudProtocol")
@XmlEnum
public enum TCloudProtocol {

    @XmlEnumValue("xml-rpc")
    XML_RPC("xml-rpc"),
    @XmlEnumValue("http-post")
    HTTP_POST("http-post"),
    @XmlEnumValue("soap")
    SOAP("soap");
    private final String value;

    TCloudProtocol(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TCloudProtocol fromValue(String v) {
        for (TCloudProtocol c: TCloudProtocol.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}