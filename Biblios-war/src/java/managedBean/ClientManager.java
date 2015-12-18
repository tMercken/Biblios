/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

//import businessSessionBean.ClientSessionBeanLocal;
import businessSessionBean.ClientSessionBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import model.Client;
//import model.Client;

/**
 *
 * @author client
 */
@Named(value = "clientManager")
@SessionScoped
public class ClientManager implements Serializable {
    @EJB
    private ClientSessionBeanLocal clientSessionBean;  
    
    private model.Client clientToManage;
    //register
    private String sex;
    private Integer phoneNumber;
    private String nom;
    private String prenom;
    private String street,areaCode,city,country;    
    private Integer day,month,year;
    private String emailRegistration;
    private String passwordRegistration;
    private String passwordToConfirm;
    //connection
    private String emailConnection;
    private String passwordConnection;
    private Boolean showNoResultErrorMessage;
    private Boolean connectionExecuted;
    
    public void exitClient (){
        this.clientToManage = null;
    }
    
    //@PostConstruct
    //public void init(){
    //    this.clientToManage = new model.Client();//"bobMail", "bobPassword", "Bob","Bob","BobAdresse","M",4003);
    //}
    
    public Client clientFromMail(String m){
        return clientSessionBean.getClientByMail(m);
    }
    
    public Boolean clientFromMailAndPassword(String m, String p){
        return clientSessionBean.getClientByMailAndPassword(m, p);
    }  

    public void addClient () {
        clientSessionBean.addClient(clientToManage);
    }    
    
    public String login(){
        if (passwordConnection != null && emailConnection != null){
            if (clientSessionBean.getClientByMailAndPassword(emailConnection, passwordConnection)){
                this.clientToManage = clientSessionBean.getClientByMail(emailConnection);
                this.connectionExecuted = true;
                return "index.xhtml";
            }
            else {
                showNoResultErrorMessage = true;
            }
        }
        return "connectionPage.xhtml";
    } 
    
    public String showWelcomAfterConnect(){
        this.connectionExecuted = false;
        return "#{message.connectionExecuted}";
    }
    
    public String register(){
        if( nom != null && prenom != null && street != null && areaCode != null && city != null && country != null && emailRegistration != null && passwordRegistration != null &&  passwordToConfirm.equals(passwordRegistration)){
            String adresse = street + " " + areaCode + " " + city + " " + country;
            GregorianCalendar dateDeNaissance = new GregorianCalendar(year, month, day );
            
            this.clientToManage = new model.Client(emailRegistration, passwordRegistration, nom, prenom, dateDeNaissance, adresse, sex, phoneNumber);
            clientSessionBean.addClient(clientToManage);
            this.connectionExecuted = true;
            return "index.xhtml";            
        }        
        return "index.xhtml";
    }
   
    public int countNbClient(){
        return clientSessionBean.countAllClient();
    }
    
    public ClientManager() {
        this.showNoResultErrorMessage = false;
        this.connectionExecuted = false;
    }  
    
    public Boolean isMailAlreadyUsed(String mail){
        return clientSessionBean.isMailAlreadyUsed(mail);
    }

    public String getPasswordToConfirm() {
        return passwordToConfirm;
    }

    public void setPasswordToConfirm(String passwordToConfirm) {
        this.passwordToConfirm = passwordToConfirm;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
   
    public Client getClientToManage() {
        return clientToManage;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }    
    
    public void setClientToManage(Client clientToManage) {
        this.clientToManage = clientToManage;
    }

    public String getEmailConnection() {
        return emailConnection;
    }

    public void setEmailConnection(String emailConnection) {
        this.emailConnection = emailConnection;
    }

    public String getPasswordConnection() {
        return passwordConnection;
    }

    public Boolean getShowNoResultErrorMessage() {
        return showNoResultErrorMessage;
    }

    public void setShowNoResultErrorMessage(Boolean showNoResultErrorMessage) {
        this.showNoResultErrorMessage = showNoResultErrorMessage;
    }

    public void setPasswordConnection(String passwordConnection) {
        this.passwordConnection = passwordConnection;
    }

    public String getEmailRegistration() {
        return emailRegistration;
    }

    public void setEmailRegistration(String emailRegistration) {
        this.emailRegistration = emailRegistration;
    }

    public String getPasswordRegistration() {
        return passwordRegistration;
    }

    public void setPasswordRegistration(String passwordRegistration) {
        this.passwordRegistration = passwordRegistration;
    }

    public Boolean getConnectionExecuted() {
        return connectionExecuted;
    }

    public void setConnectionExecuted(Boolean connectionExecuted) {
        this.connectionExecuted = connectionExecuted;
    }
    
    
    
}
