/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import managedBean.ClientManager;

/**
 *
 * @author client
 */
@FacesValidator("EmailValidator")
public class EmailValidator implements Validator {         
    @Inject
    private ClientManager clientManager;
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {        
        String email = (String) value;
        
        if (!(email.contains("@"))){
            FacesMessage message = new FacesMessage("#{message.invalidEmail}");
            throw new ValidatorException(message);
        }
        
        if (!clientManager.isMailAlreadyUsed(email)){
        } 
        else {
            FacesMessage message = new FacesMessage("#{message.alreadyUsedEmail}");
            throw new ValidatorException(message);
        }
    }
    
}
