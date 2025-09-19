package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.ControllerChoixSexe;
import modele.Facture;
import modele.Habit;

@SuppressWarnings("serial")
public class FenetreFacture extends JFrame {

	// ***** VARIABLES ***** //
	private JPanel panGeneral;
	private JPanel panPrincipal1;
	private JPanel panPrincipal2;
	private JPanel panSecondaire1a;
	private JPanel panSecondaire1b;
	private JPanel panSecondaire1b1;
	private JPanel panSecondaire1b2;
	private JPanel panSecondaire1c;
	private JPanel panSecondaire1c1;
	private JPanel panSecondaire1c2;
	private JPanel panSecondaire2;
	private JPanel panSecondaire2a;
	private JPanel actionButton;
	private JPanel titre;

	private DefaultTableModel model;
	private JScrollPane scroll;
	private JTable panier;

	private JLabel nom;
	private JLabel tel;
	private JLabel sexe;


	private JLabel motifs;
	private JLabel marque;
	private JLabel prix;
	private JLabel couleur;
	private JLabel observation;
	private JLabel designation;
	private JLabel avance;
	private JLabel prixTotal;
	private JLabel type;
	private JLabel statut;
	private JLabel nbPieces;

	private JLabel titrefacture;
	private JLabel nomfac;
	private JLabel telfac;
	private JLabel sexefac;
	private JLabel prixTotalfac;
	private JLabel typefac;
	private JLabel statutfac;
	private JLabel nbPiecesfac;
	private JLabel date_etabli;
	private JLabel avancefac;

	private JLabel textnomfac;
	private JLabel texttelfac;
	private JLabel textsexefac;
	private JLabel textprixTotalfac;
	private JLabel texttypefac;
	private JLabel textstatutfac;
	private JLabel textnbPiecesfac;
	private JLabel textdate_etabli;
	private JLabel textavancefac;

	private JPanel pantextnomfac;
	private JPanel pantexttelfac;
	private JPanel pantextsexefac;
	private JPanel pantextprixTotalfac;
	private JPanel pantexttypefac;
	private JPanel pantextstatutfac;
	private JPanel pantextnbPiecesfac;
	private JPanel pantextdate_etabli;
	private JPanel pantextavancefac;

	private JPanel textSexe;
	private JRadioButton homme;
	private JRadioButton femme;

	private JTextField textTel;
	private JTextField textNom;
	private JTextField textMarque;

	private JSpinner textPrix;
	private JSpinner textAvance;
	private JSpinner textNbPieces;
	private JSpinner textPrixTotal;

	private JComboBox<String> textDesignation;
	private JComboBox<String> textMotifs;
	private JComboBox<String> textStatut;
	private JComboBox<String> textType;


	private JColorChooser textCouleur;

	private JTextArea textObservation;

	private JButton envoyer;
	private JButton avancer;
	private JButton ajouter;
	private JButton modifier;
	private JButton imprimer;
	private JButton supprimer;
	private JButton enregistrer;

	private String [] entete={"Designation","Marque","Couleur","Motifs","Observations","Prix"};

	private Facture facture;
	private int length;

	// ***** CONSTRUCTEUR ***** //
	public FenetreFacture() {

		facture=new Facture();

		this.nom=new JLabel("Nom:");
		this.sexe=new JLabel("Sexe:");
		this.tel=new JLabel("Telephone");
		this.designation=new JLabel("Designation:");
		this.motifs=new JLabel("Motifs:");
		this.prix=new JLabel("Prix:");
		this.marque=new JLabel("Marque:");
		this.couleur=new JLabel("Couleur:");
		this.observation=new JLabel("Observation:");
		this.avance=new JLabel("Avance:");
		this.prixTotal=new JLabel("Prix_Total:");
		this.nbPieces=new JLabel("Nb_Pieces:");
		this.type=new JLabel("Type:");
		this.statut=new JLabel("Statut:");

		this.textMarque=new JTextField();
		this.textNom=new JTextField();
		this.textTel=new JTextField();

		this.homme=new JRadioButton("homme", true);
		this.femme=new JRadioButton("femme");
		this.homme.setSelected(true);
		this.homme.addActionListener(new ControllerChoixSexe(this.homme,this.femme));
		this.femme.addActionListener(new ControllerChoixSexe(this.femme,this.homme));
		this.textSexe=new JPanel();
		this.textSexe.add(this.homme,true);
		this.textSexe.add(this.femme);

		this.avancer=new JButton();
		this.avancer.setText("Avancer");
		this.avancer.setBackground(new Color(209,196,233));
		this.avancer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				facture.regler((int) textAvance.getValue(), textAvance, textavancefac);
			}
		});
		
		this.envoyer=new JButton("Envoyer");
		this.envoyer.setBackground(Color.WHITE);
		this.envoyer.setIcon(new ImageIcon(getClass().getResource("/images/whatsapp.png")));

		this.ajouter=new JButton();
		this.ajouter.setText("Ajouter");
		this.ajouter.setBackground(new Color(8,107,253));
		this.ajouter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ajouterAuPanier(textDesignation.getSelectedItem().toString(), textMarque.getText().toString(), new String[] {"jaune"}, textMotifs.getSelectedItem().toString(), textObservation.getText().toString(), (int)textPrix.getValue(),facture.getNumero());
				panier.revalidate();
				ajoutInfoClient();
				System.out.println(facture.getNumero());
			}
		});

		this.modifier=new JButton();
		this.modifier.setText("Modifier");
		this.modifier.setBackground(new Color(42,172,28));
		this.modifier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				modifier(panier.getSelectedRow());
			}
		});

		this.imprimer=new JButton("Imprimer");
		this.imprimer.setBackground(Color.WHITE);
		this.imprimer.setIcon(new ImageIcon(getClass().getResource("/images/imprimer1.png")));
		this.imprimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			imprimer();
			}
		});

		this.supprimer=new JButton();
		this.supprimer.setText("Supprimer");
		this.supprimer.setBackground(new Color(248,65,0));
		this.supprimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				supprimer(panier.getSelectedRow());
			}
		});

		this.enregistrer=new JButton("Enregistrer");
		this.enregistrer.setBackground(Color.WHITE);
		this.enregistrer.setIcon(new ImageIcon(getClass().getResource("/images/save.png")));
		this.enregistrer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				facture.enregistrer(textNom.getText(), Integer.parseInt(textTel.getText()), choixSexe(), textType.getSelectedItem().toString(),textStatut.getSelectedItem().toString(), Date.valueOf(LocalDate.now()), (int)textNbPieces.getValue(), (int)textPrixTotal.getValue(), (int)textAvance.getValue(), 1);
			}
		});

		this.panSecondaire1a=new JPanel();
		this.panSecondaire1a.setLayout(new GridLayout(3, 2));
		this.panSecondaire1a.setBorder(BorderFactory.createTitledBorder("informations detaillées sur le client"));
		((TitledBorder) this.panSecondaire1a.getBorder()).setTitleColor(Color.BLUE);
		this.panSecondaire1a.add(nom);
		this.panSecondaire1a.add(textNom);
		this.panSecondaire1a.add(sexe);
		this.panSecondaire1a.add(textSexe);
		this.panSecondaire1a.add(tel);
		this.panSecondaire1a.add(textTel);

		this.textDesignation=new JComboBox<>();
		this.textDesignation.setModel(new DefaultComboBoxModel<String>(new String[] {"Blouse","Chemise","Pantalon","Robe","Veste"}));
		this.textObservation=new JTextArea();
		this.textCouleur=new JColorChooser();
		this.textCouleur.setBorder(BorderFactory.createEmptyBorder(0, 0, -90, 5));
		this.textCouleur.setPreferredSize(new Dimension(450, 130));
		this.textType=new JComboBox<>();
		this.textType.setModel(new DefaultComboBoxModel<String>(new String[] {"Normal","Express"}));
		this.textStatut=new JComboBox<>(new DefaultComboBoxModel<String>(new String[] {"En cours","Disponible","Livré"}));
		this.textMotifs=new JComboBox<>(new DefaultComboBoxModel<String>(new String[] {"Afritude","Carrelé","Dégradé","Rayure","Traçé"}));

		this.textPrix=new JSpinner();
		this.textAvance=new JSpinner();
		this.textNbPieces=new JSpinner();
		this.textPrixTotal=new JSpinner();

		this.panSecondaire1b1=new JPanel();
		this.panSecondaire1b1.setBackground(new Color(64,230,255));
		this.panSecondaire1b1.setLayout(new BoxLayout(panSecondaire1b1, BoxLayout.Y_AXIS));
		this.panSecondaire1b1.add(designation);
		this.panSecondaire1b1.add(textDesignation);
		this.panSecondaire1b1.add(motifs);
		this.panSecondaire1b1.add(textMotifs);
		this.panSecondaire1b1.add(prix);
		this.panSecondaire1b1.add(textPrix);
		this.panSecondaire1b1.add(marque);
		this.panSecondaire1b1.add(textMarque);
		this.panSecondaire1b1.add(observation);
		this.panSecondaire1b1.add(textObservation);
		this.panSecondaire1b1.add(couleur);

		this.actionButton=new JPanel();
		this.actionButton.setLayout(new GridLayout(3,1,10,10));
		this.actionButton.add(ajouter);
		this.actionButton.add(modifier);
		this.actionButton.add(supprimer);


		this.panSecondaire1b2=new JPanel();
		this.panSecondaire1b2.setLayout(new BorderLayout());
		this.panSecondaire1b2.setBackground(new Color(64,230,255));
		this.panSecondaire1b2.add(textCouleur,BorderLayout.WEST);
		this.panSecondaire1b2.add(actionButton);

		this.panSecondaire1b1.add(panSecondaire1b2);

		this.panSecondaire1b=new JPanel();
		this.panSecondaire1b.setLayout(new BorderLayout());
		this.panSecondaire1b.add(this.panSecondaire1b1);
		this.panSecondaire1b.setBorder(BorderFactory.createTitledBorder("informations detaillées sur les habits"));
		((TitledBorder) this.panSecondaire1b.getBorder()).setTitleColor(Color.BLUE);

		this.panSecondaire1c1=new JPanel();
		this.panSecondaire1c1.setLayout(new GridLayout(3, 4,10,5));
		this.panSecondaire1c1.add(nbPieces);
		this.panSecondaire1c1.add(textNbPieces);
		this.panSecondaire1c1.add(type);
		this.panSecondaire1c1.add(textType);
		this.panSecondaire1c1.add(avance);
		this.panSecondaire1c1.add(textAvance);
		this.panSecondaire1c1.add(prixTotal);
		this.panSecondaire1c1.add(textPrixTotal);
		this.panSecondaire1c1.add(statut);
		this.panSecondaire1c1.add(textStatut);
		this.panSecondaire1c1.add(avance);
		this.panSecondaire1c1.add(textAvance);
		this.panSecondaire1c1.add(avancer);

		this.panSecondaire1c2=new JPanel();
		this.panSecondaire1c2.setLayout(new GridLayout(1, 3));
		this.panSecondaire1c2.setBorder(BorderFactory.createEmptyBorder(10, 0, 0 , 0));
		this.panSecondaire1c2.add(enregistrer);
		this.panSecondaire1c2.add(imprimer);
		this.panSecondaire1c2.add(envoyer);

		this.panSecondaire1c=new JPanel();
		this.panSecondaire1c.setLayout(new BorderLayout());
		this.panSecondaire1c.add(panSecondaire1c1,BorderLayout.NORTH);
		this.panSecondaire1c.setBorder(BorderFactory.createTitledBorder("informations detaillées sur la facture"));
		((TitledBorder) this.panSecondaire1c.getBorder()).setTitleColor(Color.BLUE);
		this.panSecondaire1c.add(panSecondaire1c2);

		this.panPrincipal1=new JPanel();
		this.panPrincipal1.setLayout(new BorderLayout(10,10));
		this.panPrincipal1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5 , 5));
		this.panPrincipal1.add(panSecondaire1a,BorderLayout.NORTH);
		this.panPrincipal1.add(panSecondaire1b,BorderLayout.CENTER);
		this.panPrincipal1.add(panSecondaire1c,BorderLayout.SOUTH);
		this.panPrincipal1.setBackground(new Color(209,196,233));


		this.titre=new JPanel();
		this.titrefacture=new JLabel("FACTURE NUMERO :");
		this.titrefacture.setFont(new Font("inter", Font.BOLD, 30));
		
		length=titrefacture.getText().length();// longueur du titre de la facture
		this.titre.setBackground(new Color(64,230,255));
		this.titre.add(titrefacture);

		this.nomfac=new JLabel("Nom:");
		this.sexefac=new JLabel("Sexe:");
		this.typefac=new JLabel("Type:");
		this.statutfac=new JLabel("Statut:");
		this.avancefac=new JLabel("Avance:");
		this.nbPiecesfac=new JLabel("Nb_Pieces:");
		this.telfac=new JLabel("Telephone:");
		this.prixTotalfac=new JLabel("Prix_Total:");
		this.date_etabli=new JLabel("Date_etablis:");

		this.textnomfac=new JLabel("");
		//this.textnomfac.setBackground(Color.white);
		this.textnomfac.setFont(new Font(getName(), Font.PLAIN, 11));
		this.textsexefac=new JLabel("");
		this.textsexefac.setFont(new Font(getName(), Font.PLAIN, 11));
		this.texttypefac=new JLabel("");
		this.texttypefac.setFont(new Font(getName(), Font.PLAIN, 11));
		this.textstatutfac=new JLabel("");
		this.textstatutfac.setFont(new Font(getName(), Font.PLAIN, 11));
		this.textavancefac=new JLabel("");
		this.textavancefac.setFont(new Font(getName(), Font.PLAIN, 11));
		this.textnbPiecesfac=new JLabel("");
		this.textnbPiecesfac.setFont(new Font(getName(), Font.PLAIN, 11));
		this.texttelfac=new JLabel("");
		this.texttelfac.setFont(new Font(getName(), Font.PLAIN, 11));
		this.textprixTotalfac=new JLabel("");
		this.textprixTotalfac.setFont(new Font(getName(), Font.PLAIN, 11));
		this.textdate_etabli=new JLabel("");
		this.textdate_etabli.setFont(new Font(getName(), Font.PLAIN, 11));

		this.pantextnomfac=new JPanel();
		this.pantextnomfac.setBackground(new Color(209,196,233));
		this.pantextnomfac.add(textnomfac);

		this.pantextsexefac=new JPanel();
		this.pantextsexefac.setBackground(new Color(64,230,255));
		this.pantextsexefac.add(textsexefac);

		this.pantexttypefac=new JPanel();
		this.pantexttypefac.setBackground(new Color(209,196,233));
		this.pantexttypefac.add(texttypefac);

		this.pantextstatutfac=new JPanel();
		this.pantextstatutfac.setBackground(new Color(209,196,233));
		this.pantextstatutfac.add(textstatutfac);

		this.pantextavancefac=new JPanel();
		this.pantextavancefac.setBackground(new Color(209,196,233));
		this.pantextavancefac.add(textavancefac);

		this.pantextnbPiecesfac=new JPanel();
		this.pantextnbPiecesfac.setBackground(new Color(64,230,255));
		this.pantextnbPiecesfac.add(textnbPiecesfac);

		this.pantexttelfac=new JPanel();
		this.pantexttelfac.setBackground(new Color(64,230,255));
		this.pantexttelfac.add(texttelfac);

		this.pantextprixTotalfac=new JPanel();
		this.pantextprixTotalfac.setBackground(new Color(64,230,255));
		this.pantextprixTotalfac.add(textprixTotalfac);

		this.pantextdate_etabli=new JPanel();
		this.pantextdate_etabli.setBackground(new Color(209,196,233));
		this.pantextdate_etabli.add(textdate_etabli);

		this.panSecondaire2a=new JPanel() {

			@Override
			public void paintComponent(Graphics g) {
				ImageIcon icoBackground=new ImageIcon(getClass().getResource("/images/bulle.jpg"));
				Image imgBackground=icoBackground.getImage();
				super.paintComponents(g);
				Graphics2D g2=(Graphics2D)g;
				g2.drawImage(imgBackground, 0, 0, this);
			}

		};
		this.panSecondaire2a.setLayout(new GridLayout(5, 4, 10, 10));
		this.panSecondaire2a.setBorder(BorderFactory.createEmptyBorder(5, 10, 10 , 10));
		this.panSecondaire2a.add(nomfac);
		this.panSecondaire2a.add(pantextnomfac);
		this.panSecondaire2a.add(telfac);
		this.panSecondaire2a.add(pantexttelfac);
		this.panSecondaire2a.add(sexefac);
		this.panSecondaire2a.add(pantextsexefac);
		this.panSecondaire2a.add(typefac);
		this.panSecondaire2a.add(pantexttypefac);
		this.panSecondaire2a.add(statutfac);
		this.panSecondaire2a.add(pantextstatutfac);
		this.panSecondaire2a.add(nbPiecesfac);
		this.panSecondaire2a.add(pantextnbPiecesfac);
		this.panSecondaire2a.add(prixTotalfac);
		this.panSecondaire2a.add(pantextprixTotalfac);
		this.panSecondaire2a.add(avancefac);
		this.panSecondaire2a.add(pantextavancefac);
		this.panSecondaire2a.add(date_etabli);
		this.panSecondaire2a.add(pantextdate_etabli);

		this.panSecondaire2=new JPanel();
		this.panSecondaire2.setLayout(new BorderLayout());
		this.panSecondaire2.add(titre,BorderLayout.NORTH);
		this.panSecondaire2.add(panSecondaire2a);

		model=new DefaultTableModel(entete, 0);
		this.panier=new JTable(model);
		/*panier.setFillsViewportHeight(true);*/
		
		this.panier.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				recuperer(panier.getSelectedRow());
			}
		});
		this.scroll=new JScrollPane(panier);

		this.panPrincipal2=new JPanel();
		this.panPrincipal2.setLayout(new BorderLayout(5,15));
		this.panPrincipal2.add(panSecondaire2,BorderLayout.NORTH);
		this.panPrincipal2.add(scroll);
		this.panPrincipal2.setBackground(new Color(209,196,233));

		this.panGeneral=new JPanel();
		this.panGeneral.setLayout(new GridLayout(1,2,10,10));
		this.panGeneral.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		this.panGeneral.add(panPrincipal1);
		this.panGeneral.add(panPrincipal2);

		this.setContentPane(panGeneral);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(1280, 720);
		this.setLocation(50, 10);
		this.setResizable(false);
		this.setVisible(true);
	}

	// ***** METHODES ***** //

	@SuppressWarnings("exports")
	public JPanel getActionButton() {
		return actionButton;
	}

	@SuppressWarnings("exports")
	public JLabel getAvance() {
		return avance;
	}

	@SuppressWarnings("exports")
	public JSpinner getTextAvance() {
		return textAvance;
	}

	@SuppressWarnings("exports")
	public JButton getAvancer() {
		return avancer;
	}

	@SuppressWarnings("exports")
	public JPanel getPanSecondaire1b1() {
		return panSecondaire1b1;
	}

	@SuppressWarnings("exports")
	public JPanel getPanSecondaire1b2() {
		return panSecondaire1b2;
	}

	@SuppressWarnings("exports")
	public JPanel getPanSecondaire1c1() {
		return panSecondaire1c1;
	}

	@SuppressWarnings("exports")
	public JPanel getPanSecondaire1c2() {
		return panSecondaire1c2;
	}

	@SuppressWarnings("exports")
	public JPanel getPanSecondaire1a() {
		return panSecondaire1a;
	}

	@SuppressWarnings("exports")
	public JPanel getTextSexe() {
		return textSexe;
	}

	@SuppressWarnings("exports")
	public JButton getEnregistrer() {
		return enregistrer;
	}
	
	public String choixSexe() {
		String sexe=null;
		
		if(homme.isSelected())
			sexe="homme";
		else if(femme.isSelected())
			sexe="femme";
		return sexe;
	}

	public void ajoutInfoClient() {
		if(titrefacture.getText().length()==length)
		titrefacture.setText(titrefacture.getText().concat("21S3"));
		
		if(textnomfac.getText().isBlank())
		textnomfac.setText(textNom.getText());
		
		if(textsexefac.getText().isBlank())
		textsexefac.setText(choixSexe());
		
		if(texttelfac.getText().isBlank())
		texttelfac.setText(textTel.getText());
		
		if(textstatutfac.getText().isBlank())
		textstatutfac.setText(textStatut.getSelectedItem().toString());
		
		if(texttypefac.getText().isBlank())
		texttypefac.setText(textType.getSelectedItem().toString());
		
		if(textavancefac.getText().isBlank())
		textavancefac.setText(textAvance.getValue().toString());
		
		if(textnbPiecesfac.getText().isBlank())
		textnbPiecesfac.setText(textNbPieces.getValue().toString());
		
		if(textprixTotalfac.getText().isBlank())
		textprixTotalfac.setText(textPrixTotal.getValue().toString());
		
		if(textdate_etabli.getText().isBlank())
		textdate_etabli.setText(LocalDate.now().toString());
	}

	public void ajouterAuPanier(String Designation,String Marque,String[] couleurs,String Motifs,String Observation,int Prix,int Numero_facture) {
		model.addRow(new String[] {Designation,Marque,"jaune",Motifs,Observation,String.valueOf(Prix),String.valueOf(Numero_facture)});
		this.panier.setModel(model);
		Habit habit=new Habit( Designation, Marque, couleurs, Motifs, Observation, Prix, Numero_facture);
		facture.getPanierhabits().add(habit);
	}

	// permet de recuperer les elements d'une ligne selectionner de la table panier et de les ecrire sur les composants pour les modifier
	public void recuperer(int index) {
		textDesignation.setSelectedItem(model.getValueAt(index, 0));
		textMarque.setText(model.getValueAt(index, 1).toString());
		textCouleur.setColor(Color.green);
		textMotifs.setSelectedItem(model.getValueAt(index, 3));
		textObservation.setText(model.getValueAt(index, 4).toString());
		textPrix.setValue(Integer.valueOf(model.getValueAt(index, 5).toString()));
	}

	public void modifier(int index) {
		model.setValueAt(textDesignation.getSelectedItem(), index, 0);
		model.setValueAt(textMarque.getText(), index, 1);
		model.setValueAt(textCouleur.getColor(), index, 2);
		model.setValueAt(textMotifs.getSelectedItem(), index, 3);
		model.setValueAt(textPrix.getValue(), index, 4);
		model.setValueAt(textObservation.getText(), index, 5);
		panier.setModel(model);
	}

	public void supprimer(int index) {
		model.removeRow(index);
		panier.setModel(model);
	}

	public void imprimer() {
		//**** Methodes pour imprimer au format jpg ****//
		File file=new File("C:\\Users\\UltraBook 3.1\\desktop\\facture.jpg");
		BufferedImage bfi=new BufferedImage(panPrincipal2.getWidth(), panPrincipal2.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2=bfi.createGraphics();
		panPrincipal2.printAll(g2);
		g2.dispose();
		try {
			ImageIO.write(bfi, "jpg", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		   //**** Methodes pour imprimer au format pdf ****//
		Toolkit kit=Toolkit.getDefaultToolkit();
		PrintJob pj=kit.getPrintJob(this, "Impression",null);
		Graphics g=pj.getGraphics();
		panPrincipal2.printAll(g);
		pj.end();
	}

	public void envoyer() {
	}
	
	// pour faire les prix au designations
	/*public void correspondance(Habit habit) {
		for(int i=0;i<textDesignation.getComponentCount();i++) {
			if(habit.getDesignation()==textDesignation.getItemAt(i))
				textPrix.setValue(habit.getPrix());
		}
	}*/

	public static void main(String[] args) {
		new FenetreFacture();
}
}