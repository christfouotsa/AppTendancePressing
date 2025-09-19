package vue.admin;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


@SuppressWarnings("serial")
public class FenetreAdmin extends JFrame implements Runnable {

	// ***** VARIABLES ***** //
	public static FenetreAdmin admin;
	private JPanel PanGeneral;
	public static JTabbedPane panPrincipal;
	private JPanel bilan;
	public JPanel employe;
	private JPanel historique;
	private static final int PAUSE=3;

	// ***** CONSTRUCTEUR ***** //
	public FenetreAdmin() {
		// CONSTRUCTION DU PANNEAU GENERAL SUR LEQUEL TOUT EST PLACER
		this.PanGeneral=new JPanel();
		this.PanGeneral.setLayout(new BorderLayout());

		this.bilan=new PageBilan(this);
		this.employe=new PageEmploye();
		this.historique=new PageHistorique(this);

		// ajout de tout les composants du panneau general
		panPrincipal=new JTabbedPane(SwingConstants.LEFT);
		panPrincipal.addTab("",new ImageIcon(getClass().getResource("/images/logopress.jpg")), null );
		panPrincipal.addTab("",new ImageIcon(getClass().getResource("/images/petitboutonemploye.jpg")), employe);
		panPrincipal.addTab("",new ImageIcon(getClass().getResource("/images/petitboutonhistorique.jpg")), historique);
		panPrincipal.addTab("",new ImageIcon(getClass().getResource("/images/petitboutonbilan.jpg")), bilan);
		panPrincipal.addTab("",null);
		panPrincipal.addTab("",new ImageIcon(getClass().getResource("/images/contactdev.png")),null);
		panPrincipal.setSelectedIndex(1);
		this.PanGeneral.add(panPrincipal);

		this.requestFocusInWindow();
		this.setFocusable(true);
		Thread chrono=new Thread(this);
		chrono.start();

		this.setVisible(true);
		this.setTitle("ADMIN");
		this.setSize(1280,720);
		this.setLocation(50, 10);
		this.setContentPane(PanGeneral);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	// ***** METHODES MAIN ***** //
	@Override
	public void run() {
		while(true) {
			this.repaint();
			try {Thread.sleep(PAUSE);}
			catch (InterruptedException e) {e.printStackTrace();}
		}
	}

	public static void main(String[] args) {
		admin=new FenetreAdmin();
		admin.setVisible(true);
	}
}