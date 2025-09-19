-- pressing.sql
-- Base de données complète pour ton application de gestion de pressing

-- Créer la base de données
CREATE DATABASE IF NOT EXISTS pressing;
USE pressing;

-- Table employe
CREATE TABLE IF NOT EXISTS employe (
    Matricule INT PRIMARY KEY,
    Nom_et_Prenom VARCHAR(255),
    Telephone INT,
    Sexe VARCHAR(10),
    Salaire INT,
    Poste VARCHAR(255),
    Date_de_Naissance DATE,
    Heure_Arriver TIME,
    Paye_Confirmer INT
);

-- Exemple d'employé
INSERT INTO employe 
(Matricule, Nom_et_Prenom, Telephone, Sexe, Salaire, Poste, Date_de_Naissance, Heure_Arriver, Paye_Confirmer)
VALUES
(1, 'john paul', 675948847, 'homme', 500000, 'Repasseur', CURDATE(), CURTIME(), 1);

-- Table facture
CREATE TABLE IF NOT EXISTS facture (
    Numero INT AUTO_INCREMENT PRIMARY KEY,
    Nom_et_Prenom VARCHAR(255),
    Telephone INT,
    Sexe VARCHAR(10),
    Type VARCHAR(50),
    Statut VARCHAR(50),
    Date_etabli DATE,
    Nb_pieces INT,
    Prix_total INT,
    Avance INT,
    Matricule_employe INT,
    FOREIGN KEY (Matricule_employe) REFERENCES employe(Matricule)
);

-- Table habit
CREATE TABLE IF NOT EXISTS habit (
    Numero INT AUTO_INCREMENT PRIMARY KEY,
    Designation VARCHAR(255),
    Marque VARCHAR(255),
    Couleur VARCHAR(100),
    Motifs VARCHAR(255),
    Observations VARCHAR(255),
    Prix INT,
    Numero_facture INT,
    FOREIGN KEY (Numero_facture) REFERENCES facture(Numero)
);
