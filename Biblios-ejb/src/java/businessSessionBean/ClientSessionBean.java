/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessSessionBean;

import entityFacades.ClientFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Client;

/**
 *
 * @author client
 */
@Stateless
public class ClientSessionBean implements ClientSessionBeanLocal {
    @EJB
    private ClientFacadeLocal clientFacade;
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public int countAllClient() {
        return clientFacade.count();
    }
   
    @Override
    public model.Client getClientByMail(String mail) {
        return clientFacade.getClientFromMail(mail);
    }

    @Override
    public model.Client getClientByMailAndPassword(String mail, String password) {
        return clientFacade.getClientFromMailAndPassword(mail, password);
    }

    @Override
    
    public Boolean isMailAlreadyUsed(String mail) {
        model.Client client = clientFacade.getClientFromMail(mail);
        
        if (client == null){
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public void addClient(Client newClient) {
        clientFacade.addClient(newClient);
    }
    
    
}
