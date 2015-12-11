/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessSessionBean;

import javax.ejb.Local;
import model.Client;

/**
 *
 * @author client
 */
@Local
public interface ClientSessionBeanLocal {

    int countAllClient();
    
    model.Client getClientByMail(String mail);

    model.Client getClientByMailAndPassword(String mail, String password);

    Boolean isMailAlreadyUsed(String mail);

    void addClient(Client newClient);
    
}
