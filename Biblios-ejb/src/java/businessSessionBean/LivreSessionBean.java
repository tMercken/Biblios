/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessSessionBean;

import entityFacades.LivreFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author client
 */
@Stateless
public class LivreSessionBean implements LivreSessionBeanLocal {
    @EJB
    private LivreFacadeLocal livreFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<model.Livre> getLivreByCategorieId(int idCategorie) {
        return livreFacade.getLivreByCategorie(idCategorie);
    }
    
    @Override
    public List<model.Livre> search(String rechercheString, Integer idlangue){
        return livreFacade.search(rechercheString, idlangue);
    }
}
