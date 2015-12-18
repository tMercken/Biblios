/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityFacades;

import entityBeans.Client;
import entityBeans.Commande;
import entityBeans.Lignecommande;
import entityBeans.Livre;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author client
 */
@Stateless
public class CommandeFacade extends AbstractFacade<Commande> implements CommandeFacadeLocal {
    @PersistenceContext(unitName = "Biblios-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommandeFacade() {
        super(Commande.class);
    }

    @Override
    public Commande addCommande(model.Commande modelCommande) {
        Commande entityCommande = new Commande();
        entityCommande.setDatecommande(modelCommande.getDate());
        
        Query query;
        query = em.createNamedQuery("Client.findByMail");
        query.setParameter("mail", modelCommande.getClient().getMail());
        
        Client entityClientCommande = (Client) query.getSingleResult();
        
        if (entityClientCommande != null){
            entityCommande.setIdclientcommande(entityClientCommande);
        }   
        create(entityCommande);
        return entityCommande;
        
    }
    
    
    
}
