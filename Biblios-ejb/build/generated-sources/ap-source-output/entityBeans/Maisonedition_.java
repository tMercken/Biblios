package entityBeans;

import entityBeans.Livre;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-06T19:13:57")
@StaticMetamodel(Maisonedition.class)
public class Maisonedition_ { 

    public static volatile CollectionAttribute<Maisonedition, Livre> livreCollection;
    public static volatile SingularAttribute<Maisonedition, Integer> id;
    public static volatile SingularAttribute<Maisonedition, String> nom;

}