/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessSessionBean;

import entityBeans.Categorie;
import entityFacades.CategorieFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author client
 */
@Stateless
public class CategorieSessionBean implements CategorieSessionBeanLocal {
    @EJB
    private CategorieFacadeLocal categorieFacade;
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<model.Categorie> getCategorieTrad() {        
        return categorieFacade.getAllCategorie();
    }
    
}
