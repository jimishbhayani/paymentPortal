package com.veritrans.paymentportal.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author jbhayani
 *
 */
@XmlRootElement
public class PaymentService {

    private int id;
    private String name;
    private String image;
    private String description;
    private boolean branding;
    private double rating;
    private double setupFee;
    private String transactionFee;
    private String howToUrl;
    private String currencies;

    /**
     * 
     */
    public PaymentService() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the branding
     */
    public boolean isBranding() {
        return branding;
    }

    /**
     * @param branding the branding to set
     */
    public void setBranding(boolean branding) {
        this.branding = branding;
    }

    /**
     * @return the rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * @return the setupFee
     */
    public double getSetupFee() {
        return setupFee;
    }

    /**
     * @param setupFee the setupFee to set
     */
    public void setSetupFee(double setupFee) {
        this.setupFee = setupFee;
    }

    /**
     * @return the transactionFee
     */
    public String getTransactionFee() {
        return transactionFee;
    }

    /**
     * @param transactionFee the transactionFee to set
     */
    public void setTransactionFee(String transactionFee) {
        this.transactionFee = transactionFee;
    }

    /**
     * @return the howToUrl
     */
    public String getHowToUrl() {
        return howToUrl;
    }

    /**
     * @param howToUrl the howToUrl to set
     */
    public void setHowToUrl(String howToUrl) {
        this.howToUrl = howToUrl;
    }

    /**
     * @return the currencies
     */
    public String getCurrencies() {
        return currencies;
    }

    /**
     * @param currencies the currencies to set
     */
    public void setCurrencies(String currencies) {
        this.currencies = currencies;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PaymentService [id=" + id + ", name=" + name + ", image=" + image + ", description=" + description + ", branding=" + branding + ", rating=" + rating + ", setupFee=" + setupFee + ", transactionFee=" + transactionFee + ", howToUrl=" + howToUrl
                + ", currencies=" + currencies + "]";
    }

  

}
