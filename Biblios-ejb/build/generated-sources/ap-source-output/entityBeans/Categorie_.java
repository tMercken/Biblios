package entityBeans;

import entityBeans.Livre;
import entityBeans.Traductioncategorie;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-06T19:13:57")
@StaticMetamodel(Categorie.class)
public class Categorie_ { 

    public static volatile CollectionAttribute<Categorie, Livre> livreCollection;
    public static volatile CollectionAttribute<Categorie, Traductioncategorie> traductioncategorieCollection;
    public static volatile SingularAttribute<Categorie, Integer> id;

}