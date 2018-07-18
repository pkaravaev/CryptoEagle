package com.cryptoeagle.RSS;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _Rss_QNAME = new QName("", "rss");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cz.jiripinkas.jba.rss
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TRss }
     *
     */
    public TRss createTRss() {
        return new TRss();
    }

    /**
     * Create an instance of {@link TRssChannel }
     *
     */
    public TRssChannel createTRssChannel() {
        return new TRssChannel();
    }

    /**
     * Create an instance of {@link TTextInput }
     *
     */
    public TTextInput createTTextInput() {
        return new TTextInput();
    }

    /**
     * Create an instance of {@link TCategory }
     *
     */
    public TCategory createTCategory() {
        return new TCategory();
    }

    /**
     * Create an instance of {@link TEnclosure }
     *
     */
    public TEnclosure createTEnclosure() {
        return new TEnclosure();
    }

    /**
     * Create an instance of {@link TImage }
     *
     */
    public TImage createTImage() {
        return new TImage();
    }

    /**
     * Create an instance of {@link TSource }
     *
     */
    public TSource createTSource() {
        return new TSource();
    }

    /**
     * Create an instance of {@link TCloud }
     *
     */
    public TCloud createTCloud() {
        return new TCloud();
    }

    /**
     * Create an instance of {@link TRssItem }
     *
     */
    public TRssItem createTRssItem() {
        return new TRssItem();
    }

    /**
     * Create an instance of {@link TGuid }
     *
     */
    public TGuid createTGuid() {
        return new TGuid();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TRss }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "rss")
    public JAXBElement<TRss> createRss(TRss value) {
        return new JAXBElement<TRss>(_Rss_QNAME, TRss.class, null, value);
    }

}