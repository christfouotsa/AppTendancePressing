package vue.admin;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class PageHistorique extends JPanel {
	// ***** VARIABLES **** //
	private JScrollPane scroll;
	private JTable table;
	JPanel pantitre;
	String[] entete= {"Num_Fac","Num_Hab","Nom_Client","Designation","Marque","Couleur","Motifs","Prix","Observations","Nb_Pieces",
	"Type_Fac","Statut_Fac","Avance","Prix_Total","Sexe_Client","Tel_Client","Date_Etabli"};

	// ***** CONSTRUCTEUR ***** //
	public PageHistorique(JFrame frame) {
		this.setLayout(new BorderLayout());

		this.table=new JTable(new DefaultTableModel(entete, ABORT));
		this.scroll=new JScrollPane(table);

		this.pantitre=new PanneauTitreAdmin("BIENVENUE DANS LA PAGE D'HISTORIQUE",this,frame);
		this.add(pantitre,BorderLayout.NORTH);
		this.add(scroll);
	}

	// ***** METHODES ***** //

}
