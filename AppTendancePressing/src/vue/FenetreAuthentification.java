package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import vue.acceuil.FenetreAcceuil;
import vue.admin.FenetreAdmin;

@SuppressWarnings("serial")
public class FenetreAuthentification extends JFrame {

	// ***** VARIABLES ***** //
	private JPanel panPrincipal;
	private JPanel panGeneral;
	private JPanel contenue;
	private JPanel panTitre;
	private JPanel panBas;

	private JLabel icone;
	private JButton connexion;
	private JPasswordField identifiant;
	private JButton vueIdentifiant;

	private boolean ok;
	private boolean afficheId;
	private static FenetreAcceuil fenetre;

	// ***** CONSTRUCTEUR ***** //
	@SuppressWarnings("exports")
	public FenetreAuthentification(FenetreAcceuil fenetre) {
		this.panGeneral=new JPanel();
		this.panGeneral.setLayout(new BorderLayout());

		this.panPrincipal=new JPanel();
		this.panPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		this.panPrincipal.setLayout(new BorderLayout(0,20));

		this.panTitre=new PanneauTitreAutre("PAGE D'AUTHENTIFICATION");
		this.panBas=new PanneauBas();

		this.icone=new JLabel();
		this.icone.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		this.icone.setIcon(new ImageIcon(getClass().getResource("/images/compteA.png")));

		this.ok=false;
		this.afficheId=false;

		this.connexion=new JButton();
		this.connexion.setText("Connexion");
		this.connexion.setAlignmentY(TOP_ALIGNMENT);
		this.connexion.setForeground(new Color(248,133,9));
		this.connexion.setBackground(Color.BLACK);
		this.connexion.setFont(new Font(getName(), Font.BOLD,20));
		this.connexion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				acces();
			}
		});
		this.connexion.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

		this.identifiant=new JPasswordField();
		this.identifiant.setEchoChar('*');
		this.identifiant.setForeground(Color.BLACK);
		this.identifiant.setFont(new Font(getName(), Font.BOLD,20));

		this.vueIdentifiant=new JButton();
		this.vueIdentifiant.setContentAreaFilled(false);
		this.vueIdentifiant.setPreferredSize(new Dimension(25, 25));
		getCursor();
		this.vueIdentifiant.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.vueIdentifiant.setIcon(new ImageIcon(getClass().getResource("/images/eye.png")));
		this.vueIdentifiant.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				afficheIdentifiant();
			}
		});


		this.contenue=new JPanel();
		this.contenue.setBackground(new Color(51,144,219));
		this.contenue.setLayout(new BorderLayout(0,30));
		this.contenue.setBorder(BorderFactory.createTitledBorder(new EmptyBorder(50, 10, 10, 10),
				"veuillez saisir votre identifiant",0,0,new Font(getName(), Font.BOLD,16),new Color(248,133,9).brighter()));
		this.contenue.add(identifiant);
		this.contenue.add(this.vueIdentifiant , BorderLayout.LINE_END);
		this.contenue.add(connexion,BorderLayout.AFTER_LAST_LINE);


		this.panPrincipal.add(icone,BorderLayout.NORTH);
		this.panPrincipal.add(contenue);

		this.panGeneral.add(panTitre,BorderLayout.NORTH);
		this.panGeneral.add(panPrincipal,BorderLayout.CENTER);
		this.panGeneral.add(panBas,BorderLayout.SOUTH);

		FenetreAuthentification.fenetre=fenetre;

		this.setContentPane(panGeneral);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(450, 560);
		this.setLocation(450, 100);
		this.setResizable(false);
		this.setVisible(true);
	}
	// ***** METHODES ***** //

	public boolean isAfficheId() {
		return afficheId;
	}
	public void setAfficheId(boolean afficheId) {
		this.afficheId = afficheId;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public void acces() {
		char[] password=identifiant.getPassword();
		String passwordStr=new String(password);

		if(passwordStr.equals("admin")) {
		new FenetreAdmin();
		fenetre.dispose();
		this.dispose();
		}
			else if(passwordStr.equals("employe")) {
			new FenetreCompteEmploye();
			this.dispose();
			}
				else {
					JOptionPane.showMessageDialog(null, "identifiant incorrect !");
				}
	}

	public void afficheIdentifiant() {
		if(!this.isAfficheId()) {
			this.setAfficheId(true);
			this.identifiant.setEchoChar((char)0);
			this.vueIdentifiant.setBorderPainted(true);
		}
			else if(this.isAfficheId()) {
				this.setAfficheId(false);
				this.identifiant.setEchoChar('*');
				this.vueIdentifiant.setBorderPainted(false);
			}
	}
	public static void main(String[] args) {
		new FenetreAuthentification(fenetre);
	}

}