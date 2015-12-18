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

/**
 *
 * @author client
 */



@FacesValidator("PasswordValidator")
public class PasswordValidator implements Validator {         
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String passwordToConfirm = (String) value;
        String password = (String) component.getAttributes().get("PasswordChecking");
        if(! passwordToConfirm.equals(password)){
            FacesMessage message = new FacesMessage("error input");
            throw new ValidatorException(message);
        }      
        
    }
    
}