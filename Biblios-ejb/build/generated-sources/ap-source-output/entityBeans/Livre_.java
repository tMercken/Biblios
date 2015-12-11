package entityBeans;

import entityBeans.Auteur;
import entityBeans.Categorie;
import entityBeans.Lignecommande;
import entityBeans.Maisonedition;
import entityBeans.Promo;
import entityBeans.Traductionlivre;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-06T19:13:57")
@StaticMetamodel(Livre.class)
public class Livre_ { 

    public static volatile CollectionAttribute<Livre, Lignecommande> lignecommandeCollection;
    public static volatile SingularAttribute<Livre, String> image;
    public static volatile SingularAttribute<Livre, Float> note;
    public static volatile CollectionAttribute<Livre, Traductionlivre> traductionlivreCollection;
    public static volatile SingularAttribute<Livre, Float> prix;
    public static volatile SingularAttribute<Livre, Maisonedition> maisoneditionId;
    public static volatile SingularAttribute<Livre, Integer> id;
    public static volatile SingularAttribute<Livre, Promo> promoId;
    public static volatile SingularAttribute<Livre, Auteur> auteurId;
    public static volatile SingularAttribute<Livre, Categorie> categorielivreId;

}