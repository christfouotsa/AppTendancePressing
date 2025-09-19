package modele;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JSpinner;

public class Facture {
	// ***** VARIABLES ***** //
	Connection connection;
	PreparedStatement pst;
	Statement st;
	

	ArrayList<Habit> Panierhabits;

	String requete="INSERT INTO facture (Nom_et_Prenom,Telephone,Sexe,Type,Statut,Date_etabli,Nb_pieces,Prix_total,Avance,Matricule_employe)"
			+ " VALUES(?,?,?,?,?,?,?,?,?,?)";
	
	String requete1="INSERT INTO facture (Avance) VALUES(?)";
	
	private int numero;

	// ***** CONSTRUCTEUR ***** //
public Facture() {
	Panierhabits=new ArrayList<>();
	connect();
	ResultSet rs;
	try {
		pst=connection.prepareStatement("select * from facture");

		rs = pst.executeQuery();
		if(rs.last()) {
			this.numero=rs.getInt("Numero");
		System.out.println(rs.getInt("Numero"));}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//enregistrer(19,"paul barnabas",675948847,"homme","express","en_cours",Date.valueOf(LocalDate.now()),02,3000,2500,1);
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


public void regler(int Avance,JSpinner textavance,JLabel textavancefac) {
	 try {
		 textavancefac.setText(textavance.getValue().toString());
		 connect();
		pst=connection.prepareStatement(requete1);
		pst.setInt(1, Avance);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

public void enregistrer(String Nom_et_Prenom,int Telephone,String Sexe,String Type,String Statut,Date DateDate_etabli,int Nb_pieces,int Prix_total,int Avance,int Matricule_employe) {
	 try {
		 connect();
		pst=connection.prepareStatement(requete);
		//pst.setInt(1, Numero);
		pst.setString(1, Nom_et_Prenom);
		pst.setInt(2, Telephone);
		pst.setString(3, Sexe);
		pst.setString(4, Type);
		pst.setString(5, Statut);
		pst.setDate(6,DateDate_etabli);
		pst.setInt(7, Nb_pieces);
		pst.setInt(8, Prix_total);
		pst.setInt(9, Avance);
		pst.setInt(10, Matricule_employe);
		pst.executeUpdate();
		
			
		/*for (Habit panierhabit : Panierhabits) {
			panierhabit.enregistrer();
		}*/
		for(int i=0;i<Panierhabits.size();i++) {
			Panierhabits.get(i).enregistrer();
		}
		//Panierhabits.clear();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public ArrayList<Habit> getPanierhabits() {
	return Panierhabits;
}

public int getNumero() {
	return this.numero;
	
}

}
