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
    private String passwordToConfirm;
    private String street,areaCode,city,country;
    private Integer day,month,year;    
    private String testString = "ceci est un test";
    
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
    
    public Client clientFromMailAndPassword(String m, String p){
        return clientSessionBean.getClientByMailAndPassword(m, p);
    }  

    public void addClient () {
        clientSessionBean.addClient(clientToManage);
    }    
   
    public int countNbClient(){
        return clientSessionBean.countAllClient();
    }
    
    public ClientManager() {
        this.clientToManage = new model.Client("bobMail", "bobPassword", "Bob","Bob","BobAdresse","M",4003);
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

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }
    
    public void setClientToManage(Client clientToManage) {
        this.clientToManage = clientToManage;
    }
}
