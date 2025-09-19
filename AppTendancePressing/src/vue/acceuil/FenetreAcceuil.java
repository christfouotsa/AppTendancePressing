package vue.acceuil;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class FenetreAcceuil extends JFrame {

	// ***** VARIABLES ***** //
	private JPanel PanGeneral;
	private BarreAcces barre_acces;// barre d'accès rapide de l'acceuil
	private JPanel PanPrincipal;
	private JPanel PanTitre;
	private JPanel PanSecondaire;


	// ***** CONSTRUCTEUR ***** //
	public FenetreAcceuil() {
		this.setTitle("ACCEUIL");
		// CONSTRUCTION DU PANNEAU GENERAL SUR LEQUEL TOUT EST PLACER
		this.PanGeneral=new JPanel();
		this.PanGeneral.setLayout(new BorderLayout());

		// construction de la barre d'accès
		this.barre_acces=new BarreAcces(this);

		// CONSTRUCTION DU PANNEAU PRINCIPAL
		this.PanPrincipal=new JPanel();
		this.PanPrincipal.setLayout(new BorderLayout());
		this.PanPrincipal.setBackground(new Color(209,196,233));

		// construction du bouton de mise à jour du logiciel


		// construction de la barre de titre
	    this.PanTitre=new PanneauTitre();

	    // construction du panneau secondaire
	    this.PanSecondaire=new PanneauSecondaire(this);

	    // ajout de tout les composants du panneau principal

		this.PanPrincipal.add(PanTitre,BorderLayout.PAGE_START);
		this.PanPrincipal.add(PanSecondaire);

		// ajout de tout les composants du panneau general
		this.PanGeneral.add(barre_acces,BorderLayout.WEST);
		this.PanGeneral.add(PanPrincipal);

		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(1280,720);
		this.setResizable(false);
		this.setLocation(50, 10);
		this.setContentPane(PanGeneral);
		//this.pack();
		//this.setAlwaysOnTop(true);
	}

	// ***** METHODES MAIN ***** //
	public static void main(String[] args) {
		FenetreAcceuil acceuil=new FenetreAcceuil();
		acceuil.setVisible(true);
	}
}

