package modele;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Employe {
	// ***** VARIABLES ***** //
	Connection connection;
	PreparedStatement pst;
	Statement st;

	String requete="INSERT INTO employe (Matricule,Nom_et_Prenom,Telephone,Sexe,Salaire,Poste,Date_de_Naissance,Heure_Arriver,Paye_Confirmer)"
			+ " VALUES(?,?,?,?,?,?,?,?,?)";

	// ***** CONSTRUCTEUR ***** //
public Employe() {
	ajouter(1,"john paul",675948847,"homme",500000,"Repasseur",Date.valueOf(LocalDate.now()),Time.valueOf(LocalTime.now()),1);
}

// ***** METHODES ***** //
public void connect() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/pressing","root","");
		System.out.println("connexion a la base de donnee reussie");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void valider() {
}
public void signaler() {
}

public void ajouter(int Matricule,String Nom_et_Prenom,int Telephone,String Sexe,int Salaire,String Poste,Date Date_Naissance,Time Heure_Arriver,int Paye_Confirmer ) {
	 try {
		 connect();
		pst=connection.prepareStatement(requete);
		pst.setInt(1, Matricule);
		pst.setString(2, Nom_et_Prenom);
		pst.setInt(3, Telephone);
		pst.setString(4, Sexe);
		pst.setInt(5, Salaire);
		pst.setString(6, Poste);
		pst.setDate(7,Date_Naissance);
		pst.setTime(8, Heure_Arriver);
		pst.setInt(9, Paye_Confirmer);
		pst.executeUpdate();
		//connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void modifier() {
}
public void supprimer() {
}
public void payer() {
}

}
