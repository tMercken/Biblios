package entityBeans;

import entityBeans.Traductioncategorie;
import entityBeans.Traductionlivre;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-06T19:13:57")
@StaticMetamodel(Langue.class)
public class Langue_ { 

    public static volatile CollectionAttribute<Langue, Traductionlivre> traductionlivreCollection;
    public static volatile SingularAttribute<Langue, String> libelle;
    public static volatile CollectionAttribute<Langue, Traductioncategorie> traductioncategorieCollection;
    public static volatile SingularAttribute<Langue, Integer> id;
    public static volatile SingularAttribute<Langue, String> drapeau;

}