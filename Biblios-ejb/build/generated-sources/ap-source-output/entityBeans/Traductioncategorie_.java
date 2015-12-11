package entityBeans;

import entityBeans.Categorie;
import entityBeans.Langue;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-06T19:13:57")
@StaticMetamodel(Traductioncategorie.class)
public class Traductioncategorie_ { 

    public static volatile SingularAttribute<Traductioncategorie, String> libelle;
    public static volatile SingularAttribute<Traductioncategorie, Langue> idlangue;
    public static volatile SingularAttribute<Traductioncategorie, Integer> id;
    public static volatile SingularAttribute<Traductioncategorie, Categorie> idcategorie;

}