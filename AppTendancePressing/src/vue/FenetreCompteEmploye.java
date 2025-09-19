package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.time.LocalDateTime;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

@SuppressWarnings("serial")
public class FenetreCompteEmploye extends JFrame {

	// ***** VARIABLES ***** //
	private JPanel panPrincipal;
	private JPanel panGeneral;
	private JPanel contenue;
	private JPanel panTitre;
	private JPanel panBas;

	private JLabel icone;
	private JLabel nom;
	private JLabel sexe;
	private JLabel poste;
	private JLabel salaire;
	private JLabel matricule;
	private JLabel date_Naiss;
	private JLabel heure_Arriv;
	private JLabel statut_Paye;

	private JPanel panBoutons;
	private JButton signaler;
	private JButton confirmer;

	LocalDateTime time;

	// ***** CONSTRUCTEUR *****//
		public FenetreCompteEmploye() {
			this.panGeneral=new JPanel();
			this.panGeneral.setLayout(new BorderLayout());

			this.panPrincipal=new JPanel();
			this.panPrincipal.setBackground(new Color(209,196,233));
			this.panPrincipal.setLayout(new BorderLayout());

			this.panTitre=new PanneauTitreAutre("ESPACE DE COMPTE EMPLOYE");
			this.panBas=new PanneauBas();

			this.icone=new JLabel();
			this.icone.setHorizontalAlignment((int) CENTER_ALIGNMENT);
			this.icone.setIcon(new ImageIcon(getClass().getResource("/images/compteA.png")));
			this.icone.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));

			this.signaler=new JButton();
			//this.signaler.setBorderPainted(false);
			this.signaler.setContentAreaFilled(false);
			this.signaler.setIcon(new ImageIcon(getClass().getResource("/images/signaler.jpg")));
			this.confirmer=new JButton();
			//this.confirmer.setBorderPainted(false);
			this.confirmer.setContentAreaFilled(false);
			this.confirmer.setIcon(new ImageIcon(getClass().getResource("/images/confirmer.jpg")));
			this.panBoutons=new JPanel();
			this.panBoutons.setLayout(new GridLayout(2,1));
			this.panBoutons.setBackground(new Color(209,196,233));
			this.panBoutons.add(signaler);
			this.panBoutons.add(confirmer);

			this.time=LocalDateTime.now();

			this.nom=new JLabel("Nom et Prenom:   ");
			this.sexe=new JLabel("Sexe:");
			this.poste=new JLabel("Poste Occupé:   ");
			this.salaire=new JLabel("Salaire Mensuel:   ");
			this.matricule=new JLabel("Matricule:   ");
			this.date_Naiss=new JLabel("Date de Naissance:   ");
			this.heure_Arriv=new JLabel("Heure d'arriver du jour:   "+this.time.toString());
			this.statut_Paye=new JLabel("Statut du payement mensuel:   "+"none");

			this.contenue=new JPanel();
			this.contenue.setBackground(new Color(209,196,233));
			this.contenue.setLayout(new GridLayout(8,1));
			this.contenue.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
			this.contenue.add(matricule);
			this.contenue.add(nom);
			this.contenue.add(sexe);
			this.contenue.add(date_Naiss);
			this.contenue.add(poste);
			this.contenue.add(salaire);
			this.contenue.add(heure_Arriv);
			this.contenue.add(statut_Paye);

			this.panPrincipal.add(icone,BorderLayout.NORTH);
			this.panPrincipal.add(contenue,BorderLayout.CENTER);
			this.panPrincipal.add(panBoutons,BorderLayout.SOUTH);

			this.panGeneral.add(panTitre,BorderLayout.NORTH);
			this.panGeneral.add(panPrincipal,BorderLayout.CENTER);
			this.panGeneral.add(panBas,BorderLayout.SOUTH);

			this.setContentPane(panGeneral);
			this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setSize(540, 720);
			this.setLocation(400, 10);
			this.setResizable(false);
			this.setVisible(true);
		}


}
