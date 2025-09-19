
# Gestion de Pressing

Une application Java pour gérer un pressing : employés, factures, habits et paiements.  
Le projet utilise **Java**, **MySQL** et une interface graphique Swing.

---

## 🚀 Fonctionnalités

- Gestion des employés : ajout, modification, suppression.
- Gestion des factures : création, suivi du paiement.
- Gestion des habits associés aux factures.
- Stockage des données dans une base MySQL (`pressing`).
- Documentation générée avec **Javadoc**.
- Graphiques de bilan (actuellement statiques).
- Interface graphique avec toutes les pages prévues, même celles non complètement fonctionnelles.

---

## 🛠 Installation

1. Installer [Java JDK](https://www.oracle.com/java/technologies/javase-jdk.html).  
2. Installer [MySQL](https://dev.mysql.com/downloads/mysql/) ou utiliser XAMPP.  
3. Importer le fichier `pressing.sql` dans MySQL pour créer la base et les tables.  
4. Configurer le fichier `*.java` de connexion si nécessaire :  

```java
connection = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/pressing","root","");
Remplacer root et le mot de passe si nécessaire.

Compiler et exécuter le projet avec ton IDE (NetBeans, IntelliJ, Eclipse…).

📂 Structure du projet
graphql
Copier le code
src/
 └── modele/          # Classes Java pour la logique métier
      ├── Employe.java
      ├── Facture.java
      └── Habit.java
docs/                  # Documentation générée avec Javadoc
pressing.sql           # Script SQL pour créer la base de données
README.md              # Ce fichier
⚡ Limitations actuelles
L’historique des factures n’est pas encore affiché dynamiquement.

Les graphiques du bilan sont statiques et ne reflètent pas encore les données réelles.

Certaines pages sont prévues mais pas encore entièrement fonctionnelles.

📖 Documentation
La documentation Javadoc est générée dans le dossier docs/.

Pour consulter, ouvrez index.html dans un navigateur.
