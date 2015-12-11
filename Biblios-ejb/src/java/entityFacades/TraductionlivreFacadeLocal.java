/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityFacades;

import entityBeans.Traductionlivre;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author client
 */
@Local
public interface TraductionlivreFacadeLocal {

    void create(Traductionlivre traductionlivre);

    void edit(Traductionlivre traductionlivre);

    void remove(Traductionlivre traductionlivre);

    Traductionlivre find(Object id);

    List<Traductionlivre> findAll();

    List<Traductionlivre> findRange(int[] range);

    int count();
    
}
