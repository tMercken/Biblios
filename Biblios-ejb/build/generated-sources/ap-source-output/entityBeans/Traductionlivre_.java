package entityBeans;

import entityBeans.Langue;
import entityBeans.Livre;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-06T19:13:57")
@StaticMetamodel(Traductionlivre.class)
public class Traductionlivre_ { 

    public static volatile SingularAttribute<Traductionlivre, String> resume;
    public static volatile SingularAttribute<Traductionlivre, String> titre;
    public static volatile SingularAttribute<Traductionlivre, Livre> idlivre;
    public static volatile SingularAttribute<Traductionlivre, Langue> idlangue;
    public static volatile SingularAttribute<Traductionlivre, Integer> id;

}