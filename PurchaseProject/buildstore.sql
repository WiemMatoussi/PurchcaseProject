
# création de la base de données :
 
DROP DATABASE IF EXISTS `buildstore`;
CREATE DATABASE `buildstore` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `buildstore`;

#
# création des tables
#

CREATE TABLE `Livre`(
`reference` integer NOT NULL,
`prixUnitaire` double default NULL,
`nomProduit` varchar(50) default NULL,
`categorie` varchar(50) default NULL,
`quantitestock` integer,
`titre` varchar(50) default NULL,
`auteur` varchar(50) default NULL,
`DateDeSortie` Date,
primary key (`reference` )


) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Facture` (
  `idFacture` integer NOT NULL,
  PRIMARY KEY  (`idFacture`)
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `LigneCommande` (
`idLigneCommande` integer NOT NULL,
`quantiteLigne` integer  NOT NULL,
`referenceLivre` integer NOT NULL,
`referenceFacture` integer NOT NULL,
  PRIMARY KEY  (`idLigneCommande`),
  FOREIGN KEY (`referenceLivre`) REFERENCES Livre(`reference`),
  FOREIGN KEY (`referenceFacture`) REFERENCES Facture(`idFacture`)
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Personne` (
  `id` integer NOT NULL,
  `nom` varchar(50) default NULL,
  `prenom` varchar(50) default NULL,
  `email` varchar(50) default NULL,
  `session` varchar(50)  default NULL,
  PRIMARY KEY  (`id`),
  constraint ch_personne check (`session` in ("utilisateur", "administrateur"))
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;






#
# Insertion des lignes de données
#

INSERT INTO `Facture` VALUES (1);
