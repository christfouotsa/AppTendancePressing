package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import controller.ControllerChoixSexe;
import vue.admin.PageEmploye;

@SuppressWarnings("serial")
public class FenetreNouvelEmploye extends JFrame {

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
	private JLabel textMatricule;

	private JPanel textSexe;
	private JRadioButton homme;
	private JRadioButton femme;
	private JTextField textNom;
	private JSpinner textsalaire;
	private JTextField textDate_Naiss;
	private JComboBox<String> textPoste;

	private JButton enregistrer;

	// ***** CONSTRUCTEUR *****//
	@SuppressWarnings("exports")
	public FenetreNouvelEmploye(PageEmploye employe) {

		this.panGeneral=new JPanel();
		this.panGeneral.setLayout(new BorderLayout());

		this.panPrincipal=new JPanel();
		this.panPrincipal.setBackground(new Color(209,196,233));
		this.panPrincipal.setLayout(new BorderLayout());

		this.panTitre=new PanneauTitreAutre("AJOUT D'UN COMPTE EMPLOYE");
		this.panBas=new PanneauBas();

		this.icone=new JLabel();
		this.icone.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		this.icone.setIcon(new ImageIcon(getClass().getResource("/images/compteA.png")));
		this.icone.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));

		this.enregistrer=new JButton();
		this.enregistrer.setBackground(Color.WHITE);
		this.enregistrer.setText("Enregistrer");
		this.enregistrer.setFont(new Font(getName(), Font.BOLD, 16));
		this.enregistrer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				employe.setNbCompte(employe.getNbCompte()+1);
				employe.ajoutPanneauEmploye();
				employe.getPanprincipal().setModel(new DefaultTableModel(employe.tabpanneaux, employe.getNbCompte()));
				employe.miseAJour(textNom, textDate_Naiss);
				FenetreNouvelEmploye.this.dispose();
			}
		});

		this.nom=new JLabel("Nom et Prenom:");
		this.sexe=new JLabel("Sexe:");
		this.poste=new JLabel("Poste Occupé:");
		this.salaire=new JLabel("Salaire Mensuel:");
		this.matricule=new JLabel("Matricule:");
		this.date_Naiss=new JLabel("Date de Naissance");

		this.textMatricule=new JLabel("000000");
		this.textMatricule.setFont(new Font(getName(), Font.BOLD, 18));

		this.textNom=new JTextField();

		this.homme=new JRadioButton("Homme");
		this.femme=new JRadioButton("Femme");
		this.homme.setBackground(new Color(209,196,233));
		this.homme.setSelected(true);
		this.homme.addActionListener(new ControllerChoixSexe(this.homme,this.femme));
		this.femme.addActionListener(new ControllerChoixSexe(this.femme,this.homme));
		this.femme.setBackground(new Color(209,196,233));




		this.textSexe=new JPanel();
		//this.textSexe.setLayout(new FlowLayout());
		this.textSexe.add(homme);
		this.textSexe.add(femme);
        this.textSexe.setBackground(new Color(209,196,233));
		this.textsalaire=new JSpinner();
		this.textsalaire.setBackground(new Color(209,196,233));

		this.textPoste=new JComboBox<>();

		this.textDate_Naiss=new JTextField();


		this.contenue=new JPanel();
		this.contenue.setBackground(new Color(209,196,233));
		this.contenue.setLayout(new GridLayout(12,1));
		this.contenue.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
		this.contenue.add(matricule);
		this.contenue.add(textMatricule);
		this.contenue.add(nom);
		this.contenue.add(textNom);
		this.contenue.add(sexe);
		this.contenue.add(textSexe);
		this.contenue.add(poste);
		this.contenue.add(textPoste);
		this.contenue.add(salaire);
		this.contenue.add(textsalaire);
		this.contenue.add(date_Naiss);
		this.contenue.add(textDate_Naiss);


		this.panPrincipal.add(icone,BorderLayout.NORTH);
		this.panPrincipal.add(contenue,BorderLayout.CENTER);
		this.panPrincipal.add(enregistrer,BorderLayout.SOUTH);

		this.panGeneral.add(panTitre,BorderLayout.NORTH);
		this.panGeneral.add(panPrincipal,BorderLayout.CENTER);
		this.panGeneral.add(panBas,BorderLayout.SOUTH);

		this.setContentPane(panGeneral);
		this.setFocusable(true);
		this.requestFocusInWindow(true);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(540, 720);
		this.setLocation(400, 10);
		this.setResizable(false);
		this.setVisible(true);
	}
	// ***** METHODES ***** //

}
