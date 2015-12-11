/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityFacades;

import entityBeans.Commande;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
