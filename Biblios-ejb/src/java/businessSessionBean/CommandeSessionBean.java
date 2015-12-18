/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessSessionBean;

import entityFacades.CommandeFacadeLocal;
import entityFacades.LignecommandeFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Commande;

/**
 *
 * @author client
 */
@Stateless
public class CommandeSessionBean implements CommandeSessionBeanLocal {
    @EJB
    private LignecommandeFacadeLocal lignecommandeFacade;
    

    @Override
    public void addCommande(model.Commande commande) {
        if(commande != null && ! commande.getLigneCommandeHashMap().isEmpty()){
            lignecommandeFacade.addCommandeAndLigneCommande(commande);
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
