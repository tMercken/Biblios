/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import businessSessionBean.CommandeSessionBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import model.Client;
import model.Commande;
import model.LigneCommande;
import model.Livre;


@Named(value = "commandeManager")
@SessionScoped
public class CommandeManager implements Serializable {
    @EJB
    private CommandeSessionBeanLocal commandeSessionBean;
    
    private HashMap<Integer, LigneCommande> ligneCommandeHashMap;
    private List<LigneCommande> listTemp;
    
    @Inject
    private ClientManager clientManager;

    /**
     * Creates a new instance of CommandeManagedBean
     */
    public CommandeManager() {
        ligneCommandeHashMap = new HashMap<Integer, LigneCommande>();
    }
    
    public void addLivreToBasket(Livre livre, Integer quantiteCommande){
        LigneCommande ligneCommande = new LigneCommande(quantiteCommande, livre.returnPriceWithPromo(), livre);        
        ligneCommandeHashMap.putIfAbsent(livre.getId(), ligneCommande);        
    }
    
    public String removeLivreFromBasket(Integer id){
        this.ligneCommandeHashMap.remove(id);
        if (this.ligneCommandeHashMap.containsKey(id)){
            String s = "bon sang, pourquoi ça se met pas à jour alors que ça passe pas par ici !!!!!!!!!!!!!!!!!!!";
        }
        else{
            String s = "bon sang !!!!!!!!!!!!!!!!!!!";
            String p = "Aaaaaargg";
        }
        return "shoppingBagPage.xhtml";
    }
    
    public String saveCommande(){
        Date today = Calendar.getInstance().getTime();
        if(! this.ligneCommandeHashMap.isEmpty()){
            Commande commande = new Commande(today, this.ligneCommandeHashMap, clientManager.getClientToManage());        
            commandeSessionBean.addCommande(commande);
            this.ligneCommandeHashMap.clear();
        }
        this.listTemp.clear();
        return "index.xhtml";
    }
    
    public String totalPriceString(){
        Float price = (float) 0;
        
        Iterator<Integer> keySetIterator = ligneCommandeHashMap.keySet().iterator();

        while(keySetIterator.hasNext()){
            Integer key = keySetIterator.next();
            price += ligneCommandeHashMap.get(key).getPrix();
        }
        
        Long priceLong = Math.round(100 * price.doubleValue());  
        Double priceDouble = priceLong.doubleValue()/100;
        return priceDouble.toString();
    }

    public String countNbItemInBasket(){
        Integer i = 0;
        Iterator<Integer> keySetIterator = ligneCommandeHashMap.keySet().iterator();

        while(keySetIterator.hasNext()){
            Integer key = keySetIterator.next();
            i ++;
        }
        return i.toString();
    }
    
    public String addOne(LigneCommande ligneCommande){
        ligneCommande.setQuantite(ligneCommande.getQuantite() + 1);
        ligneCommande.setPrix(ligneCommande.getLivreCommande().returnPriceWithPromo()* ligneCommande.getQuantite());
        ligneCommandeHashMap.replace(ligneCommande.getId(), ligneCommande);
        return "shoppingBagPage.xhtml";
    }
    
    public String removeOne(LigneCommande ligneCommande){
        if (ligneCommande.getQuantite() > 1) {
            ligneCommande.setQuantite(ligneCommande.getQuantite() - 1);
            ligneCommande.setPrix(ligneCommande.getLivreCommande().returnPriceWithPromo()* ligneCommande.getQuantite());
            ligneCommandeHashMap.replace(ligneCommande.getId(), ligneCommande);
        }        
        return "shoppingBagPage.xhtml";
    }

    public HashMap<Integer, LigneCommande> getLigneCommandeHashMap() {
        return ligneCommandeHashMap;
    }

    public void setLigneCommandeHashMap(HashMap<Integer, LigneCommande> ligneCommandeHashMap) {
        this.ligneCommandeHashMap = ligneCommandeHashMap;
    } 

    //list temp sert à 'remplacer' hasMap, qui pour d'obscure raisons ne fonctionne pas avec dataTable
    public List<LigneCommande> getListTemp() {
        listTemp = new ArrayList<LigneCommande>();
        Iterator<Integer> keySetIterator = ligneCommandeHashMap.keySet().iterator();

        while(keySetIterator.hasNext()){
            Integer key = keySetIterator.next();
            listTemp.add(ligneCommandeHashMap.get(key));
        }
        return listTemp;
    }    

    public void setListTemp(List<LigneCommande> listTemp) {
        this.listTemp = listTemp;
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }
    
    
    
    
    
}
