/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityFacades;

import entityBeans.Maisonedition;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author client
 */
@Local
public interface MaisoneditionFacadeLocal {

    void create(Maisonedition maisonedition);

    void edit(Maisonedition maisonedition);

    void remove(Maisonedition maisonedition);

    Maisonedition find(Object id);

    List<Maisonedition> findAll();

    List<Maisonedition> findRange(int[] range);

    int count();
    
}
