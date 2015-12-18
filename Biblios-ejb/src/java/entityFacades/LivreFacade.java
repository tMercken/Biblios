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
import java.util.Date;
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
            model.Livre livreModel = this.getModelLivreById(livreEntity.getId());  
            myListModel.add(livreModel);
        }
        return myListModel; 
    
    }
    
    
    @Override
    public List<model.Livre> search(String stringRecherche, int idlangue){
        List<model.Livre> resultatList = new ArrayList<model.Livre>();
        model.Livre livreModel;
        
        Query queryLangue;
        queryLangue = em.createNamedQuery("Traductionlivre.search");
        
        Langue lang = new Langue();
        lang.setId(idlangue);
        queryLangue.setParameter("itemRech", stringRecherche + "%");
        queryLangue.setParameter("idlangue", lang);
        
        List<Traductionlivre> listTradEntity = queryLangue.getResultList();
        
        int i = 0;        
        if(!listTradEntity.isEmpty()){
            while(i<listTradEntity.size())
            {
                livreModel = this.getModelLivreById(listTradEntity.get(i).getIdlivre().getId());
                resultatList.add(livreModel);
                i++;
            }
        
        }
        return resultatList;
        
    }

    @Override
    public model.Livre getModelLivreById(Integer id) {
        Query query;
        query = em.createNamedQuery("Livre.findById");     
        query.setParameter("id",id);
        Livre livreEntity = (Livre) query.getSingleResult();
            
        model.Promo promoModel;
        Promo promoentity;
        if(livreEntity.getPromoId() != null){
            promoentity = livreEntity.getPromoId();
            Date promoDateDebut = promoentity.getDatedebut();
            Date promoDateFin = promoentity.getDatefin();
            int promoID = livreEntity.getPromoId().getId();
            float prct = promoentity.getPrctreduc();
            promoModel = new model.Promo(promoID, promoDateDebut, promoDateFin, prct);
        }
        else{
            promoModel = null;
        }
            
        model.Auteur auteurModel = new model.Auteur(livreEntity.getAuteurId().getId(), livreEntity.getAuteurId().getNom(), livreEntity.getAuteurId().getPrenom());
        model.MaisonEdition maisonEditionModel = new model.MaisonEdition(livreEntity.getMaisoneditionId().getId(), livreEntity.getMaisoneditionId().getNom());

        Double noteModel;
        if(livreEntity.getNote() != null){
            noteModel = livreEntity.getNote().doubleValue();
        }
        else {
            noteModel = 0.0;
        }
            
        String imageModel;
        if (livreEntity.getImage() != null){
            imageModel = livreEntity.getImage();
        }
        else {
            imageModel = "./images/defaultCover.jpg";
        }
            
        model.Livre newLivre = new model.Livre(livreEntity.getId(), imageModel, noteModel, livreEntity.getPrix(), promoModel, maisonEditionModel, auteurModel);
            
        List<Traductionlivre> listTradEntity = (List<Traductionlivre>) livreEntity.getTraductionlivreCollection();
        for(int j = 0; j < listTradEntity.size();j++){
            if(j == 0){
                newLivre.setTradResumeFR(listTradEntity.get(0).getResume());
                newLivre.setTradTitreFR(listTradEntity.get(0).getTitre());
            }
                
            if(j == 1){
                newLivre.setTradResumeEN(listTradEntity.get(1).getResume());
                newLivre.setTradTitreEN(listTradEntity.get(1).getTitre());
            }
                
        }            
            
        return newLivre;
    }
    
}
