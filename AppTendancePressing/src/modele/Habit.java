package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Habit {
	// ***** VARIABLES ***** //
	Connection connection;
	PreparedStatement pst;
	Statement st;

	//int Numero;
	String Designation;
	String Marque;
	String[] couleurs;
	String Motifs;
	String Observation;
	int Prix;
	int Numero_facture;

	String requete="INSERT INTO habit (Designation,Marque,Couleur,Motifs,Observations,Prix,Numero_facture)"
			+ " VALUES(?,?,?,?,?,?,?)";

	// ***** CONSTRUCTEUR ***** //
public Habit(String Designation,String Marque,String[] couleurs,String Motifs,String Observation,int Prix,int Numero_facture) {
	//this.Numero=Numero;
	this.Designation=Designation;
	this.Marque=Marque;
	this.couleurs=couleurs;
	this.Motifs=Motifs;
	this.Observation=Observation;
	this.Prix=Prix;
	this.Numero_facture=Numero_facture;
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

public void enregistrer() {
	 try {
		 connect();
		pst=connection.prepareStatement(requete);
		//pst.setInt(1, Numero);
		pst.setString(1, Designation);
		pst.setString(2, Marque);
		pst.setString(3, couleurs[0]);
		pst.setString(4, Motifs);
		pst.setString(5, Observation);
		pst.setInt(6,Prix);
		pst.setInt(7, Numero_facture);
		pst.executeUpdate();
		//connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

/*public int getNumero() {
	return Numero;
}
public void setNumero(int numero) {
	Numero = numero;
}*/

public String getDesignation() {
	return Designation;
}
public void setDesignation(String designation) {
	Designation = designation;
}

public String getMarque() {
	return Marque;
}
public void setMarque(String marque) {
	Marque = marque;
}

public String[] getCouleurs() {
	return couleurs;
}
public void setCouleurs(String[] couleurs) {
	this.couleurs = couleurs;
}

public String getMotifs() {
	return Motifs;
}
public void setMotifs(String motifs) {
	Motifs = motifs;
}

public String getObservation() {
	return Observation;
}
public void setObservation(String observation) {
	Observation = observation;
}

public int getPrix() {
	return Prix;
}
public void setPrix(int prix) {
	Prix = prix;
}

public int getNumero_facture() {
	return Numero_facture;
}
public void setNumero_facture(int numero_facture) {
	Numero_facture = numero_facture;
}

}
