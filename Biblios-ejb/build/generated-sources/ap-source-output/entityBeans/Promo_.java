package entityBeans;

import entityBeans.Livre;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-06T19:13:57")
@StaticMetamodel(Promo.class)
public class Promo_ { 

    public static volatile CollectionAttribute<Promo, Livre> livreCollection;
    public static volatile SingularAttribute<Promo, Date> datedebut;
    public static volatile SingularAttribute<Promo, Date> datefin;
    public static volatile SingularAttribute<Promo, Integer> id;
    public static volatile SingularAttribute<Promo, Float> prctreduc;

}