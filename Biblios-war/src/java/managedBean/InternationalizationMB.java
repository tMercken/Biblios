/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Locale;


@Named(value = "internationalizationMB")
@SessionScoped
public class InternationalizationMB implements Serializable {

    /**
     * Creates a new instance of InternationalizationMB
     */
    public InternationalizationMB() {
    }
    
    public Locale getLocal() {
        return local;
    }
    
    public Boolean isInFrench() {
        return (this.local.getDisplayLanguage() == "français");
    }
    
    public Boolean isInEnglish() {
        return !(this.local.getDisplayLanguage() == "français");
    }
    
    public void setToFrench() {
        this.setLocal(new Locale("fr"));
    }
    
    public void setToEnglish() {
        this.setLocal(new Locale("en"));
    }
    public String getCurrentLanguage() {
        return this.local.getDisplayLanguage();
    }
    public void setLocal(Locale local) {
        this.local = local;
    }
    private Locale local = new Locale("en");
}
