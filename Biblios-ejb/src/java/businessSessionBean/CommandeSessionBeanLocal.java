/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessSessionBean;

import javax.ejb.Local;
import model.Commande;

/**
 *
 * @author client
 */
@Local
public interface CommandeSessionBeanLocal {

    void addCommande(model.Commande commande);
    
}
