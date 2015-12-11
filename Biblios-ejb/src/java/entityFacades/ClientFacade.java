/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityFacades;

import entityBeans.Client;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author client
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {
    @PersistenceContext(unitName = "Biblios-ejbPU")
    private EntityManager em;

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
        Client entityClient = (Client) query.getSingleResult();
        
        if (entityClient == null)
            return null;
        
        model.Client modelClient = new model.Client(entityClient.getMail(), entityClient.getPassword(), entityClient.getId(), entityClient.getNom(), entityClient.getPrenom(), entityClient.getDatedenaissance(), entityClient.getAdresse(), entityClient.getSex().toString(), entityClient.getTelephone().intValue());
        return modelClient;
    }

    @Override
    public model.Client getClientFromMailAndPassword(String mail, String password) {
        Query query;
        query = em.createNamedQuery("Client.findByMail");
        query.setParameter("mail", mail);
        Client entityClient = (Client) query.getSingleResult();
        
        if (entityClient == null)
            return null;
        
        model.Client modelClient = new model.Client(entityClient.getMail(), entityClient.getPassword(), entityClient.getId(), entityClient.getNom(), entityClient.getPrenom(), entityClient.getDatedenaissance(), entityClient.getAdresse(), entityClient.getSex().toString(), entityClient.getTelephone().intValue());
        return modelClient;
    }

    @Override
    public void addClient(model.Client modelClient) {
        Client entityClient = new Client(null, modelClient.getMail(), modelClient.getPassword(), modelClient.getNom(), modelClient.getPrenom(), modelClient.getDateDeNaissance().getTime(), modelClient.getAdresse());
        entityClient.setSex(modelClient.getSex().charAt(0));
        entityClient.setTelephone(modelClient.getTelephone().longValue());
        create(entityClient);
    }
    
    
    
    
}
