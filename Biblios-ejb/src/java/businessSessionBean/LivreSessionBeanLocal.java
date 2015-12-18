/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessSessionBean;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author client
 */
@Local
public interface LivreSessionBeanLocal {

    List<model.Livre> getLivreByCategorieId(int idCategorie);
    
    List<model.Livre> search(String rechercheString, Integer idlangue);
}
