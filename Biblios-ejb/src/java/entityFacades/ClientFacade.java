/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityFacades;

import entityBeans.Client;
import java.security.Key;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author client
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {
    @PersistenceContext(unitName = "Biblios-ejbPU")
    private EntityManager em;
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

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }
    
    @Override
    public model.Client getClientFromMail(String mail) {
        Query query;
        query = em.createNamedQuery("Client.findByMail");        
        query.setParameter("mail", mail);
            
        if (query.getResultList().isEmpty())
            return null;
        
        Client entityClient = (Client) query.getSingleResult();        
        //entityClient.getMail(), entityClient.getPassword(), entityClient.getId(), entityClient.getNom(), entityClient.getPrenom(), entityClient.getAdresse());
        model.Client modelClient = new model.Client();
        
        GregorianCalendar dateNais = new GregorianCalendar();
        dateNais.setTime(entityClient.getDatedenaissance());
        
        modelClient.setId(entityClient.getId());
        modelClient.setMail(entityClient.getMail());
        modelClient.setPassword(entityClient.getPassword());
        modelClient.setNom(entityClient.getNom());
        modelClient.setPrenom(entityClient.getPrenom());
        modelClient.setDateDeNaissance(dateNais);
        modelClient.setAdresse(entityClient.getAdresse());

        if(entityClient.getSex() != null){
            modelClient.setSex(entityClient.getSex().toString()); 
        }
        if (entityClient.getTelephone() != null){
            modelClient.setTelephone(entityClient.getTelephone().intValue());
        }
        return modelClient;
    }

    @Override
    public Boolean getClientFromMailAndPassword(String mail, String password) {        
        Client entityClient;
        Query query;
        query = em.createNamedQuery("Client.findByMailAndPassword");
        query.setParameter("mail", mail);
        try {
            String encyptedPassword = encrypt(password);
            query.setParameter("password", encyptedPassword);
        }
        catch(Exception e) {
            return false;            
        }
 
        entityClient = (Client) query.getSingleResult();
        if (entityClient == null){
            return false;
        }
        else {
            return true;
        }
        
        /*
        model.Client modelClient = new model.Client(entityClient.getMail(), entityClient.getPassword(), entityClient.getId(), entityClient.getNom(), entityClient.getPrenom(), entityClient.getAdresse());
        return modelClient;*/
        
    }

    @Override
    public void addClient(model.Client modelClient) {
        try{ 
            String cryptedPassword = encrypt(modelClient.getPassword());
            Client entityClient = new Client(null, modelClient.getMail(), cryptedPassword, modelClient.getNom(), modelClient.getPrenom(), modelClient.getDateDeNaissance().getTime(), modelClient.getAdresse());
        
            if(modelClient.getSex() != null){
                entityClient.setSex(modelClient.getSex().charAt(0));
            }
            if(modelClient.getTelephone() != null){
                entityClient.setTelephone(modelClient.getTelephone().longValue());
            }
            create(entityClient);
        }
        catch(Exception e){
            
        }
        
    }
    
    
    
    
}
