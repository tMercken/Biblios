/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityFacades;

import entityBeans.Auteur;
import entityBeans.Client;
import entityBeans.Langue;
import entityBeans.Livre;
import entityBeans.Maisonedition;
import entityBeans.Promo;
import entityBeans.Traductionlivre;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author client
 */
@Stateless
public class LivreFacade extends AbstractFacade<Livre> implements LivreFacadeLocal {
    @PersistenceContext(unitName = "Biblios-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LivreFacade() {
        super(Livre.class);
    }

    @Override
    public List<model.Livre> getLivreByCategorie(int idCategorie) {
        Query query;
        query = em.createNamedQuery("Livre.findByCategorie");
        query.setParameter("idCategorie", idCategorie);
        
        List<Livre> myListEntity = (List<Livre>) query.getResultList();        
        List<model.Livre> myListModel = new ArrayList<model.Livre>();
        
        for(int i = 0; i < myListEntity.size(); i++ ){
            Livre livreEntity = myListEntity.get(i);
            
            Promo promoEntity = livreEntity.getPromoId();
            model.Promo promoModel = new model.Promo(promoEntity.getId(),promoEntity.getDatedebut(), promoEntity.getDatefin(), promoEntity.getPrctreduc());
            
            Auteur auteurEntity = livreEntity.getAuteurId();
            model.Auteur auteurModel = new model.Auteur(auteurEntity.getId(), auteurEntity.getNom(), auteurEntity.getPrenom());
            
            Maisonedition maisonEditionEntity = livreEntity.getMaisoneditionId();
            model.MaisonEdition maisonEditionModel = new model.MaisonEdition(maisonEditionEntity.getId(), maisonEditionEntity.getNom());
            
            List<Traductionlivre> traductionLivreListEntity = (List) livreEntity.getTraductionlivreCollection();
            List<model.TraductionLivre> traductionLivreListModel = new ArrayList<model.TraductionLivre>();
            for (int j = 0; j < traductionLivreListEntity.size(); j++ ) {
                Traductionlivre tradLivreEntity = traductionLivreListEntity.get(j);
                Langue langueTraductionEntity = tradLivreEntity.getIdlangue();
                model.Langue langueTraductionModel = new model.Langue(langueTraductionEntity.getId(), langueTraductionEntity.getLibelle(), langueTraductionEntity.getDrapeau()); 
                
                model.TraductionLivre newTraductionModel = new model.TraductionLivre(tradLivreEntity.getId(),tradLivreEntity.getTitre(),tradLivreEntity.getResume(), langueTraductionModel);
                traductionLivreListModel.add(newTraductionModel);
            }            
            
            model.Livre newLivre = new model.Livre(livreEntity.getId(), livreEntity.getImage(), livreEntity.getNote().doubleValue(), livreEntity.getPrix(), promoModel, maisonEditionModel,auteurModel, traductionLivreListModel);
            myListModel.add(newLivre);
        }
        return myListModel; 
    }

    
    
}
