package model;

import java.awt.image.BufferedImage;
import java.io.InputStream;



public class Orders {
    protected int id;
    protected int agentId;
    protected int clientId;
    protected int flyerQty;
    protected String flyerLayout;
    protected String first;
    protected String cfirst;
    protected InputStream flyerImg;
    protected String flyerImgString;
    protected int personalCopy;
    protected String paymentInformation;
    protected String invoiceNumber;
    protected String comments;
    protected int isFlyerArtApproved;
    protected int isPaymentRecieved;
    
    public Orders()
    {
        
    }

    public String getCfirst() {
        return cfirst;
    }

    public void setCfirst(String cfirst) {
        this.cfirst = cfirst;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }
    public Orders(int id)
    {
        this.id = id;
    }
    public Orders( int id, int flyerQty, String flyerLayout, int personalCopy, String paymentInformation, String invoiceNumber, String comments, int flyerArtAppr, int paymentReceived) {
       this.id = id;
          this.agentId = agentId;
        this.clientId = clientId;
        this.flyerQty = flyerQty;
        this.flyerLayout = flyerLayout;
        this.personalCopy = personalCopy;
        this.paymentInformation = paymentInformation;
        this.invoiceNumber = invoiceNumber;
        this.comments = comments;
        this.isFlyerArtApproved = flyerArtAppr;
        this.isPaymentRecieved = isPaymentRecieved; }
 
   
    
      public Orders( String first,String client,int id,int agentId, int clientId, int flyerQty, String flyerLayout, String image, int personalCopy, String paymentInformation, String invoiceNumber, String comments, int flyerArtAppr, int paymentReceived) {
       this.id = id;
          this.agentId = agentId;
          this.first = first;
          this.cfirst = client;
        this.clientId = clientId;
        this.flyerQty = flyerQty;
        this.flyerLayout = flyerLayout;
        this.flyerImgString = image;
        this.personalCopy = personalCopy;
        this.paymentInformation = paymentInformation;
        this.invoiceNumber = invoiceNumber;
        this.comments = comments;
        this.isFlyerArtApproved = flyerArtAppr;
        this.isPaymentRecieved = isPaymentRecieved; }
      
 
      
      
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getFlyerQty() {
        return flyerQty;
    }

    public void setFlyerQty(int flyerQty) {
        this.flyerQty = flyerQty;
    }

    public String getFlyerLayout() {
        return flyerLayout;
    }

    public void setFlyerLayout(String flyerLayout) {
        this.flyerLayout = flyerLayout;
    }

    public InputStream getFlyerImg() {
        return flyerImg;
    }

    public void setFlyerImg(InputStream flyerImg) {
        this.flyerImg = flyerImg;
    }

     public String getFlyerImgStr() {
        return flyerImgString;
    }

    public void setFlyerImg(String flyerImg) {
        this.flyerImgString = flyerImg;
    }

    
    public int getPersonalCopy() {
        return personalCopy;
    }

    public void setPersonalCopy(int personalCopy) {
        this.personalCopy = personalCopy;
    }

    public String getPaymentInformation() {
        return paymentInformation;
    }

    public void setPaymentInformation(String paymentInformation) {
        this.paymentInformation = paymentInformation;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int isIsFlyerArtApproved() {
        return isFlyerArtApproved;
    }

    public void setIsFlyerArtApproved(int isFlyerArtApproved) {
        this.isFlyerArtApproved = isFlyerArtApproved;
    }

    public int isIsPaymentRecieved() {
        return isPaymentRecieved;
    }

    public void setIsPaymentRecieved(int isPaymentRecieved) {
        this.isPaymentRecieved = isPaymentRecieved;
    }
    
    
    
}
