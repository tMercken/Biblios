package entityBeans;

import entityBeans.Commande;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-06T19:13:57")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> password;
    public static volatile SingularAttribute<Client, String> mail;
    public static volatile SingularAttribute<Client, Character> sex;
    public static volatile SingularAttribute<Client, String> adresse;
    public static volatile SingularAttribute<Client, Long> telephone;
    public static volatile SingularAttribute<Client, Integer> id;
    public static volatile SingularAttribute<Client, String> nom;
    public static volatile SingularAttribute<Client, String> prenom;
    public static volatile SingularAttribute<Client, Date> datedenaissance;
    public static volatile CollectionAttribute<Client, Commande> commandeCollection;

}