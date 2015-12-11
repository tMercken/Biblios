/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import businessSessionBean.CategorieSessionBeanLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import model.Categorie;

/**
 *
 * @author client
 */
@Named(value = "categorieManager")
@ApplicationScoped
public class CategorieManager {
    @EJB
    private CategorieSessionBeanLocal categorieSessionBean;    
    
    List<Categorie> categoriesToManage;

    public CategorieManager() {
    }
    
    public List<Categorie> getCategoriesToManage() {
        return categoriesToManage;
    }

    public void setCategoriesToManage(List<Categorie> categoriesToManage) {
        this.categoriesToManage = categoriesToManage;
    }
    
    //@PostConstruct
    // bon sang, pourquoi ça marche pas ???
    //public void init () {
     //   this.categoriesToManage = categorieSessionBean.getCategorieTrad();
    //}

    /**
     * Creates a new instance of CategorieManager
     */
    
    
}
