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
import javax.inject.Inject;
import model.Categorie;


@Named(value = "categorieManager")
@ApplicationScoped
public class CategorieManager {
    @EJB
    private CategorieSessionBeanLocal categorieSessionBean; 
    
    @Inject
    private LivreManager livreManager;
    
    List<Categorie> categoriesToManage;

    public CategorieManager() {
    }
    
    public List<Categorie> getCategoriesToManage() {
        return categoriesToManage;
    }

    public void setCategoriesToManage(List<Categorie> categoriesToManage) {
        this.categoriesToManage = categoriesToManage;
    }
    
    @PostConstruct
    public void init () {
        this.categoriesToManage = categorieSessionBean.getCategorieTrad();
    }
    
    public String chooseCategorie(Categorie selectedCategorie){
        this.livreManager.setSelectedCategory(selectedCategorie);
        return "livreByCategoriesPage.xhtml";
    }

    public LivreManager getLivreManager() {
        return livreManager;
    }

    public void setLivreManager(LivreManager livreManager) {
        this.livreManager = livreManager;
    }

    /**
     * Creates a new instance of CategorieManager
     */
    
    
}
