-- *********************************************            
-- * Generator date: Oct 16 2014              
-- * Generation date: Tue Nov 24 10:35:18 2015 
-- * LUN file: E:\USB\javaWeb\BDjavaWebRel.lun 
-- * Schema: BDventeLivre/SQL 
-- * Author : Thierry Mercken and Mohamed Toure
-- ********************************************* 


-- Database Section
-- ________________ 

-- create database BDventeLivre;


-- DBSpace Section
-- _______________

-- DBSpace Section
-- _______________
-- Tables Section
-- _____________ 


drop table LigneCommande;
drop table Commande;
drop table TraductionCategorie;
drop table TraductionLivre;
drop table Livre;
drop table Promo;
drop table Langue;
drop table Auteur;
drop table Client;
drop table MaisonEdition;
Drop table Categorie;



-- Tables Section
-- _____________ 

create table Auteur (
     id int not null primary key GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
     nom VARCHAR(50) not null,
     prenom VARCHAR(50) not null
);

create table Categorie (
     id int not null primary key --GENERATED ALWAYS AS IDENTITY
        --(START WITH 1, INCREMENT BY 1)
);

create table Client (
     id int not null primary key GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
     mail VARCHAR(50) not null,
     password VARCHAR(250) not null,
     nom VARCHAR(50) not null,
     prenom VARCHAR(50) not null,
     dateDeNaissance date not null,
     sex char(1),
     telephone numeric(12),
     adresse VARCHAR(50) not null
);

create table Commande (
     id int not null primary key GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
     dateCommande date not null,
     idClientCommande int not null
);

create table Langue (
     id int not null primary key GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
     libelle VARCHAR(50) not null,
     drapeau VARCHAR(50) not null
);

create table LigneCommande (
     id int not null primary key GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
     q int not null,
     prix float(7) not null,
     idLivre int not null,
     idCommande int not null
);

create table Livre(
     id int not null primary key GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
     image VARCHAR(50),
     note float(3),
     prix float(5) not null,
     Promo_id int,
     auteur_id int not null,
     maisonEdition_id int not null,
     categorieLivre_id int not null
);

create table MaisonEdition (
     id int not null primary key GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
     nom VARCHAR(50) not null
);

create table Promo (
     id int not null primary key GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
     dateDebut date not null,
     dateFin date not null,
     prctReduc float(5) not null
);

create table TraductionLivre (
     id int not null primary key GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
     idLivre int not null,
     idLangue int not null,
     titre VARCHAR(70) not null,
     resume VARCHAR(150) not null
);

create table TraductionCategorie (
     id int not null primary key GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
     idLangue int not null,
     idCategorie int not null,
     libelle VARCHAR(70) not null
);


-- Constraints Section
-- ___________________ 

alter table Promo add constraint Date_Promo_CHK
    check(dateDebut < dateFin);

alter table LigneCommande add constraint Quantite_Achat_Positif_CHK
    check(q > 0);

--alter table Client add constraint No_Voyageur_temporel_CHK
--    check(dateDeNaissance < CURRENT_TIMESTAMP);

alter table Livre add constraint Note_Positive_CHK
    check(note >=0);

alter table Commande add constraint REF_comma_clien_FK
     foreign key (idClientCommande)
     references Client;

alter table LigneCommande add constraint REF_ligne_Livre
     foreign key (idLivre)
     references livre;

alter table LigneCommande add constraint EQU_ligne_comma_FK
     foreign key (idCommande)
     references Commande;

alter table Livre add constraint REF_Auteu__FK
     foreign key (auteur_id)
     references Auteur;

alter table Livre add constraint REF_Livre_Promo_FK
     foreign key (promo_id)
     references Promo;

alter table Livre add constraint REF_Livre_Maiso_FK
     foreign key (maisonEdition_id)
     references MaisonEdition;

alter table Livre add constraint REF_Livre_categ_FK
     foreign key (categorieLivre_id)
     references Categorie;

alter table TraductionLivre add constraint REF_Tradu_Livre_FK
     foreign key (idLivre)
     references Livre;

alter table TraductionLivre add constraint REF_Tradu_Langa_1
     foreign key (idLangue)
     references Langue;

alter table TraductionCategorie add constraint REF_Tradu_Langa
     foreign key (idLangue)
     references Langue;

alter table TraductionCategorie add constraint REF_Tradu_categ_FK
     foreign key (idCategorie)
     references Categorie;



-- Insert Section
-- ___________________
INSERT INTO Auteur (nom, prenom)
VALUES ('Bambelle','Larry');

INSERT INTO Auteur (nom, prenom)
VALUES ('Kan','Jerry');

INSERT INTO Auteur (nom, prenom)
VALUES ('Meurdesoif','Jean');


INSERT INTO MaisonEdition (nom)
VALUES ('Dupuis');

INSERT INTO MaisonEdition (nom)
VALUES ('Dupont');

INSERT INTO MaisonEdition (nom)
VALUES ('SuperLivre');

INSERT INTO MaisonEdition (nom)
VALUES ('unPeuMoinsSuperLivre');


INSERT INTO Langue (libelle, drapeau)
VALUES ('Francais','temp001');

INSERT INTO Langue (libelle, drapeau)
VALUES ('English', 'temp002');


INSERT INTO Promo (dateDebut, dateFin, prctReduc)
VALUES (date('30.10.2015'), date('06.11.2015'), 0.2 );

INSERT INTO Promo (dateDebut, dateFin, prctReduc)
VALUES (date('20.11.2015'), date('27.11.2015'), 0.5 );

INSERT INTO Promo (dateDebut, dateFin, prctReduc)
VALUES (date('04.11.2015'), date('11.11.2015'), 0.7 );


INSERT INTO Categorie VALUES(1);

INSERT INTO Categorie VALUES(2);

INSERT INTO Categorie VALUES(3);

INSERT INTO Categorie VALUES(4);


INSERT INTO Livre (image, note, prix, promo_id, auteur_id, maisonEdition_id, categorieLivre_id)
VALUES (null, null, 17, 1, 1, 1, 1 );

INSERT INTO Livre (image, note, prix, promo_id, auteur_id, maisonEdition_id, categorieLivre_id)
VALUES (null, 10, 9.99, null, 1, 1, 2 );

INSERT INTO Livre (image, note, prix, promo_id, auteur_id, maisonEdition_id, categorieLivre_id)
VALUES (null, 12, 11.98, null, 1, 1, 4 );

INSERT INTO Livre (image, note, prix, promo_id, auteur_id, maisonEdition_id, categorieLivre_id)
VALUES (null, 19, 7.28, 3, 1, 1, 3 );

INSERT INTO Livre (image, note, prix, promo_id, auteur_id, maisonEdition_id, categorieLivre_id)
VALUES (null, 6, 17.56, 2, 1, 1, 2 );

INSERT INTO Livre (image, note, prix, promo_id, auteur_id, maisonEdition_id, categorieLivre_id)
VALUES (null, 4, 30.1, 2, 1, 1, 3 );


INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (1, 1, 'Nécronomicon', 'Ph nglui mglw nafh Cthulhu R lyeh wgah nagl fhtagn');

INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (1, 2, 'Necronomicon', 'Ph nglui mglw nafh Cthulhu R lyeh wgah nagl fhtagn');

INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (2, 1, 'Le Guide du voyageur galactique', 'Ne paniquez pas, et emportez une serviette');

INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (2, 2, 'The Hitchhiker s Guide to the Galaxy', 'Don t worry, and carry a towel');

INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (3, 1, 'Twilight', 'La saga de Stephenie Meyer, très populaire parmi les lectrices adolescentes');

INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (3, 2, 'Twilight', 'Twilight is a vampire-themed fantasy romance novel by American author Stephenie Meyer');

INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (4, 1, 'Le Père Porcher', 'Le Père Porcher est le vingtième livre des Annales du Disque-monde');

INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (4, 2, 'Hogfather', 'Hogfather is the 20th Discworld novel');

INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (5, 1, 'Le Crime de l Orient-Express', 'Hercule Poirot prend le train');

INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (5, 2, 'Murder on the Orient Express', 'Hercule Poirot take the train');

INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (6, 1, 'How to writte english very good', 'dat book is very good pour aprenndre englich correctly');


INSERT INTO TraductionCategorie (idLangue, idCategorie,libelle )
VALUES(1, 1, 'Fantasy');

INSERT INTO TraductionCategorie (idLangue, idCategorie,libelle )
VALUES(2, 1, 'Fantasy');

INSERT INTO TraductionCategorie (idLangue, idCategorie,libelle )
VALUES(1, 2, 'Science-fiction');

INSERT INTO TraductionCategorie (idLangue, idCategorie,libelle )
VALUES(2, 2, 'Sci Fi');

INSERT INTO TraductionCategorie (idLangue, idCategorie,libelle )
VALUES(1, 3, 'Policier');

INSERT INTO TraductionCategorie (idLangue, idCategorie,libelle )
VALUES(2, 3, 'Crime fiction');

INSERT INTO TraductionCategorie (idLangue, idCategorie,libelle )
VALUES(1, 4, 'Romance');

INSERT INTO TraductionCategorie (idLangue, idCategorie,libelle )
VALUES(2, 4, 'Romance');


INSERT INTO Client (mail, password, nom, prenom, dateDeNaissance, sex, telephone, adresse)
VALUES ('bob.Mail@mail.com','123', 'bobEgalement', 'bob', date('04.11.2010'), null, null, 'dans ton C... Carnet');

INSERT INTO Client (mail, password, nom, prenom, dateDeNaissance, sex, telephone, adresse)
VALUES ('truc.Mail@mail.com','456', 'Samob', 'Ivan', date('04.11.2009'), null, 0459643562, 'rue dicule');

INSERT INTO Client (mail, password, nom, prenom, dateDeNaissance, sex, telephone, adresse)
VALUES ('machin.Mail@mail.com','789', 'Pop', 'Iggy', date('04.11.2009'), null, null, 'rue binette');

INSERT INTO Client (mail, password, nom, prenom, dateDeNaissance, sex, telephone, adresse)
VALUES ('kickstart.Mail@mail.com','741', 'Lee', 'Tommy', date('04.11.2008'), 'M', null, 'rue binette');

INSERT INTO Client (mail, password, nom, prenom, dateDeNaissance, sex, telephone, adresse)
VALUES ('motor.Mail@mail.com','852', 'Kilmister', 'Lemmy', date('04.11.2008'), 'M', 0476958312, 'rue le');

INSERT INTO Client (mail, password, nom, prenom, dateDeNaissance, sex, telephone, adresse)
VALUES ('river.Mail@mail.com','963', 'Dio', 'Ronnie', date('04.11.2008'), 'M', null, 'rue matisme');


INSERT INTO  Commande (dateCommande, idClientCommande)
VALUES (date('26.11.2015'), 4);

INSERT INTO  Commande (dateCommande, idClientCommande)
VALUES (date('27.11.2015'), 1);

INSERT INTO  Commande (dateCommande, idClientCommande)
VALUES (date('28.11.2015'), 4);


INSERT INTO LigneCommande ( q, prix, idLivre, idCommande)
VALUES (4,27.05,1,1);

INSERT INTO LigneCommande ( q, prix, idLivre, idCommande)
VALUES (1,8.95,3,1);

INSERT INTO LigneCommande ( q, prix, idLivre, idCommande)
VALUES (6,58.75,2,2);

INSERT INTO LigneCommande ( q, prix, idLivre, idCommande)
VALUES (1,8,3,3);

INSERT INTO LigneCommande ( q, prix, idLivre, idCommande)
VALUES (3,31.65,2,3);

INSERT INTO LigneCommande ( q, prix, idLivre, idCommande)
VALUES (2,18.03,1,3);

-- suite

UPDATE Promo 
SET dateFin = date('25.12.2015')  
where id = 1;

INSERT INTO Auteur (nom, prenom)
VALUES ('LeCelebreAuteur','Bob');

INSERT INTO Auteur (nom, prenom)
VALUES ('Margot','Rene');

INSERT INTO Auteur (nom, prenom)
VALUES ('Petit','Rene');


INSERT INTO MaisonEdition (nom)
VALUES ('MaisonMasson');


INSERT INTO Promo (dateDebut, dateFin, prctReduc)
VALUES (date('30.10.2015'), date('01.02.2016'), 0.1 );

INSERT INTO Promo (dateDebut, dateFin, prctReduc)
VALUES (date('20.12.2015'), date('27.12.2015'), 0.5 );

INSERT INTO Promo (dateDebut, dateFin, prctReduc)
VALUES (date('04.01.2016'), date('11.01.2016'), 0.7 );


INSERT INTO Categorie VALUES(5);

INSERT INTO Categorie VALUES(6);

INSERT INTO Categorie VALUES(7);

INSERT INTO Categorie VALUES(8);


INSERT INTO Livre (image, note, prix, promo_id, auteur_id, maisonEdition_id, categorieLivre_id)
VALUES ('./images/cover (1).jpg', 2.5, 10, 1, 4, 2, 5 );

INSERT INTO Livre (image, note, prix, promo_id, auteur_id, maisonEdition_id, categorieLivre_id)
VALUES ('./images/cover (2).jpg', 13.5, 21, 2, 4, 3, 6 );

INSERT INTO Livre (image, note, prix, promo_id, auteur_id, maisonEdition_id, categorieLivre_id)
VALUES ('./images/cover (3).jpg', 5.5, 15.98, null, 5, 4, 8 );

INSERT INTO Livre (image, note, prix, promo_id, auteur_id, maisonEdition_id, categorieLivre_id)
VALUES ('./images/cover (4).jpg', 16.9, 8.28, 4, 3, 3, 7 );

INSERT INTO Livre (image, note, prix, promo_id, auteur_id, maisonEdition_id, categorieLivre_id)
VALUES ('./images/cover (5).jpg', 18, 7.56, 5, 4, 2, 6 );

INSERT INTO Livre (image, note, prix, promo_id, auteur_id, maisonEdition_id, categorieLivre_id)
VALUES ('./images/cover (6).jpg', 10., 14.15, 6, 5, 2, 7 );

INSERT INTO Livre (image, note, prix, promo_id, auteur_id, maisonEdition_id, categorieLivre_id)
VALUES ('./images/cover (7).jpg', 15, 15.98, 2, 2, 3, 8 );


INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (7, 1, 'Le livre qui fait peur', 'Ce livre parle de math');

INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (7, 2, 'The scary book', 'That book is about math');

INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (8, 1, 'Salut, et merci pour le poisson', 'Livre écrit par un dauphin');

INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (8, 2, 'So long, and thanks for all the fish', 'That book was written by a daulphin');

INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (9, 1, 'Divergente', 'Un peu comme twilight, mais avec moins de vampires');

INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (9, 2, 'Divergente', 'A bit like twilight, but with less vampires');

INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (10, 1, 'La raclette', 'La raclette est un plat délicieux. A base de fromage');

INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (10, 2, 'Melted cheese', 'So deliscious, made out of love and cheese');

INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (11, 1, 'Le noble art de la pétanque', 'Des math, de la physique et des actions à couper le soufle');

INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (11, 2, 'The noble art of throwing lead balls', 'A sport fort intellectual');

INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (12, 1, 'Pourquoi le ciel est bleu ?', 'ouvrage de vulgarisation scientifique');

INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (12, 2, 'Why is the sky blue ?', 'Science made easy for everyone');

INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (13, 1, 'Le throne de fer', 'Spoiler : ils meurent tous à la fin');

INSERT INTO TraductionLivre (idLivre, idLangue, titre, resume)
VALUES (13, 2, 'a song of fire and ice', 'Spoiler : they all die by the end');


INSERT INTO TraductionCategorie (idLangue, idCategorie,libelle )
VALUES(1, 5, 'Cuisine');

INSERT INTO TraductionCategorie (idLangue, idCategorie,libelle )
VALUES(2, 5, 'Food');

INSERT INTO TraductionCategorie (idLangue, idCategorie,libelle )
VALUES(1, 6, 'Science');

INSERT INTO TraductionCategorie (idLangue, idCategorie,libelle )
VALUES(2, 6, 'Science');

INSERT INTO TraductionCategorie (idLangue, idCategorie,libelle )
VALUES(1, 7, 'Comédie');

INSERT INTO TraductionCategorie (idLangue, idCategorie,libelle )
VALUES(2, 7, 'Comedy');

INSERT INTO TraductionCategorie (idLangue, idCategorie,libelle )
VALUES(1, 8, 'Tragédie');

INSERT INTO TraductionCategorie (idLangue, idCategorie,libelle )
VALUES(2, 8, 'Drama');
