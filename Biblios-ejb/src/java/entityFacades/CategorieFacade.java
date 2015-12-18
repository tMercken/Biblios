/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityFacades;

import entityBeans.Categorie;
import entityBeans.Langue;
import entityBeans.Traductioncategorie;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author client
 */
@Stateless
public class CategorieFacade extends AbstractFacade<Categorie> implements CategorieFacadeLocal {
    @PersistenceContext(unitName = "Biblios-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategorieFacade() {
        super(Categorie.class);
    }

    @Override
    public List<model.Categorie> getAllCategorie() {
        List<model.Categorie> myListModel = new ArrayList<model.Categorie>();
        List<Categorie> myListEntity = (List<Categorie>) findAll();
        
        for(int i = 0; i < myListEntity.size(); i++ ){
            Categorie categorieEntity = myListEntity.get(i);
            
            List<Traductioncategorie> traductionCategorieListEntity = (List<Traductioncategorie>) categorieEntity.getTraductioncategorieCollection();
            
            model.Categorie newCategorie = new model.Categorie();
            newCategorie.setId(categorieEntity.getId());
            newCategorie.setTradFR(traductionCategorieListEntity.get(0).getLibelle());
            newCategorie.setTradEN(traductionCategorieListEntity.get(1).getLibelle());           
            myListModel.add(newCategorie);
        }
        return myListModel;    
    }
    
    
        
}
