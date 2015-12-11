package entityBeans;

import entityBeans.Client;
import entityBeans.Lignecommande;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-06T19:13:57")
@StaticMetamodel(Commande.class)
public class Commande_ { 

    public static volatile CollectionAttribute<Commande, Lignecommande> lignecommandeCollection;
    public static volatile SingularAttribute<Commande, Date> datecommande;
    public static volatile SingularAttribute<Commande, Client> idclientcommande;
    public static volatile SingularAttribute<Commande, Integer> id;

}