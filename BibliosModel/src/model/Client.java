/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.security.Key;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author client
 */
public class Client {
    private Integer id;
    private String mail;
    private String password;
    private String nom;
    private String prenom;
    private GregorianCalendar dateDeNaissance;
    private String sex;
    private Integer telephone;
    private String adresse;    
    private static final String ALGORITHM = "AES";    
    private static final byte[] keyValue = new byte[] { 'T', 'h', 'i', 's', 'I', 's', 'A', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y' };
    
    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        return key;
    }
    
    public String encrypt(String valueToEnc) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);        
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encValue = c.doFinal(valueToEnc.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encValue);
        return encryptedValue;
    }
     
     public String decrypt(String encryptedValue) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedValue);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
    
     
    public Client (){
        
    }
    
    //total, for entity to model
    public Client (String mail, String password, int id, String nom, String prenom, Date dateNaissance, String adresse, String sex, Integer telephone) {  
        this.mail = mail;         
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance.setTime(dateNaissance);
        this.adresse = adresse;
        this.sex = sex;
        this.telephone = telephone;
    }
    
    //minimal, for entity to model
    public Client (String mail, String password, int id, String nom, String prenom, Date dateNaissance, String adresse) {  
        this.mail = mail;
        this.password = password;
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance.setTime(dateNaissance);
        this.adresse = adresse;
        this.sex = null;
        this.telephone = null;
    }
    
    public Client (String mail, String password, int id, String nom, String prenom, String adresse) {  
        this.mail = mail;
        this.password = password;
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = new GregorianCalendar();
        this.adresse = adresse;
        this.sex = null;
        this.telephone = null;
    }
    
    //total, for client adding
    public Client (String mail, String password, String nom, String prenom, GregorianCalendar dateNaissance, String adresse, String sex, Integer telephone) {  
        this.mail = mail;
        this.password = password;
        this.id = null;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateNaissance;
        this.adresse = adresse;
        this.sex = sex;
        this.telephone = telephone;
    }
    
    //minimal, for client adding
    public Client (String mail, String password, String nom, String prenom,GregorianCalendar dateNaissance, String adresse) {  
        this.mail = mail;
        this.password = password;
        this.id = null;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateNaissance;
        this.adresse = adresse;
        this.sex = null;
        this.telephone = null;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public GregorianCalendar getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(GregorianCalendar dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    
    public void constructFromEntity(String mail, String password, int id, String nom, String prenom, Date dateNaissance, String adresse, String sex, Integer telephone){        
        this.mail = mail;
        this.password = password;
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance.setTime(dateNaissance);
        this.adresse = adresse;
        this.sex = sex;
        this.telephone = telephone;
    }
    
    
    
}
