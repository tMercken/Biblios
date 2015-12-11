package entityBeans;

import entityBeans.Commande;
import entityBeans.Livre;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-06T19:13:57")
@StaticMetamodel(Lignecommande.class)
public class Lignecommande_ { 

    public static volatile SingularAttribute<Lignecommande, Integer> q;
    public static volatile SingularAttribute<Lignecommande, Float> prix;
    public static volatile SingularAttribute<Lignecommande, Commande> idcommande;
    public static volatile SingularAttribute<Lignecommande, Livre> idlivre;
    public static volatile SingularAttribute<Lignecommande, Integer> id;

}