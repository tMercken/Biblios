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
@FacesValidator("PhoneValidator")
public class PhoneValidator implements Validator {         
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(value != null){
            String phoneNumber = (String) value;
            try { 
                Integer num = Integer.parseInt(phoneNumber); 
                if(num <= 9999999){
                    FacesMessage message = new FacesMessage("error input");
                    throw new ValidatorException(message);                
                }
            } catch(NumberFormatException e) { 
                FacesMessage message = new FacesMessage("error input");
                throw new ValidatorException(message);
            } 
        }
        
    }
    
}
