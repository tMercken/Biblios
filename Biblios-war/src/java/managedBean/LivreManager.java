/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import businessSessionBean.LivreSessionBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import model.Categorie;
import model.Livre;


@Named(value = "livreManager")
@SessionScoped
public class LivreManager implements Serializable {
    @EJB
    private LivreSessionBeanLocal livreSessionBean;
    private Categorie selectedCategory;
    private Livre livreDetail;
    private List<Livre> listLivre;
    private String rechercheString;
    private List<Livre> listLivreRecherche;
    private List<Integer> listQuantiteCommande;
    private Integer quantiteCommande;
    
    @Inject
    private CommandeManager commandeManager;
    
    @Inject
    private InternationalizationMB internationalManager;
    /**
     * Creates a new instance of LivreManager
     */
    public LivreManager() {
        this.generateNbQuantityUpToTen();
        this.quantiteCommande = 1;
    }
    
    @PostConstruct
    public void init () {
       
    }
    
    public String seeMore(Livre selectedLivre){
        this.livreDetail = selectedLivre;
        return "detailLivre.xhtml";
    }
    
    public String chooseCategory(Categorie categorie){
        this.selectedCategory = categorie;
        listLivre = this.livreSessionBean.getLivreByCategorieId(selectedCategory.getId());
        return "livreByCategoriesPage.xhtml";
    }
    
    public String addLivreToBasket(){
        commandeManager.addLivreToBasket(livreDetail, quantiteCommande);
        return "index.xhtml";
    }
    
    public String search(){
        int idLangue;
        if(internationalManager.isInFrench()){
            idLangue = 1;
        }
        else {
            idLangue = 2;
        }
        String rechercheStringDetail = rechercheString.substring(0,1).toUpperCase() + rechercheString.substring(1);

        this.listLivreRecherche = this.livreSessionBean.search(rechercheStringDetail, idLangue);
        return "livreBySearch.xhtml";
    }

    public void generateNbQuantityUpToTen() {
        this.listQuantiteCommande = new ArrayList<>();        
        Integer i=1;
        while(i <= 10) {            
            this.listQuantiteCommande.add(i);
            i++;
        }            
    }
    
    public Categorie getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(Categorie selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    public List<Livre> getListLivre() {
        return listLivre;
    }

    public void setListLivre(List<Livre> listLivre) {
        this.listLivre = listLivre;
    }

    public Livre getLivreDetail() {
        return livreDetail;
    }

    public void setLivreDetail(Livre livreDetail) {
        this.livreDetail = livreDetail;
    }

    public CommandeManager getCommandeManager() {
        return commandeManager;
    }

    public void setCommandeManager(CommandeManager commandeManager) {
        this.commandeManager = commandeManager;
    }

    public String getRechercheString() {
        return rechercheString;
    }

    public void setRechercheString(String rechercheString) {
        this.rechercheString = rechercheString;
    }

    public List<Livre> getListLivreRecherche() {
        return listLivreRecherche;
    }

    public void setListLivreRecherche(List<Livre> listLivreRecherche) {
        this.listLivreRecherche = listLivreRecherche;
    }

    public InternationalizationMB getInternationalManager() {
        return internationalManager;
    }

    public void setInternationalManager(InternationalizationMB internationalManager) {
        this.internationalManager = internationalManager;
    }

    public LivreSessionBeanLocal getLivreSessionBean() {
        return livreSessionBean;
    }

    public void setLivreSessionBean(LivreSessionBeanLocal livreSessionBean) {
        this.livreSessionBean = livreSessionBean;
    }

    public List<Integer> getListQuantiteCommande() {
        return listQuantiteCommande;
    }

    public void setListQuantiteCommande(List<Integer> listQuantiteCommande) {
        this.listQuantiteCommande = listQuantiteCommande;
    }

    public Integer getQuantiteCommande() {
        return quantiteCommande;
    }

    public void setQuantiteCommande(Integer quantiteCommande) {
        this.quantiteCommande = quantiteCommande;
    }
    
    
    
}
