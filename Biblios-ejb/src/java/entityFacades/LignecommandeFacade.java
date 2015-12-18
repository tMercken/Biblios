/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityFacades;

import businessSessionBean.CommandeSessionBeanLocal;
import entityBeans.Commande;
import entityBeans.Lignecommande;
import entityBeans.Livre;
import java.util.HashMap;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author client
 */
@Stateless
public class LignecommandeFacade extends AbstractFacade<Lignecommande> implements LignecommandeFacadeLocal {
    @EJB
    private CommandeFacadeLocal commandeFacade;
    
    
    @PersistenceContext(unitName = "Biblios-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LignecommandeFacade() {
        super(Lignecommande.class);
    }
    
    @Override
    public void addLigneCommandeHashMap(HashMap<Integer, model.LigneCommande> ligneCommandeMap, Commande idCommande) {        
        Iterator<Integer> keySetIterator = ligneCommandeMap.keySet().iterator();
        while(keySetIterator.hasNext()){
            Integer key = keySetIterator.next();
            //création livreCommande
            Query query;
            query = em.createNamedQuery("Livre.findById");
            query.setParameter("id", ligneCommandeMap.get(key).getLivreCommande().getId());
            Livre entityLivre = (Livre) query.getSingleResult();
            
            if(ligneCommandeMap.get(key).getQuantite() > 0){
                Lignecommande ligneCommandeEntity = new Lignecommande(null, ligneCommandeMap.get(key).getQuantite(),ligneCommandeMap.get(key).getPrix());
                ligneCommandeEntity.setIdlivre(entityLivre);
                ligneCommandeEntity.setIdcommande(idCommande);
                create(ligneCommandeEntity);
            }
        }        
    }    

    @Override
    public void addCommandeAndLigneCommande(model.Commande modelCommande) {
        Commande newEntityCommande = commandeFacade.addCommande(modelCommande);
        this.addLigneCommandeHashMap(modelCommande.getLigneCommandeHashMap(), newEntityCommande);
    }
}
