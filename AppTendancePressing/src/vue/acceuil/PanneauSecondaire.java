package vue.acceuil;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ReglerController;
import vue.FenetreAuthentification;

@SuppressWarnings("serial")
public class PanneauSecondaire extends JPanel {
	// ***** VARIABLES ***** //
	private JButton facture;// boutton de nouvelle facture. situé sur le panneau secondaire
	private JButton manuel;// boutton d'ouverture du manuel. situe sur le panneau secondaire
	private JButton compte;// boutton d'accès à un compte. situe sur le panneau secondaire

	// ***** CONSTRUCTEUR ***** //
	public PanneauSecondaire(FenetreAcceuil fenetre) {
		setLayout(new FlowLayout(FlowLayout.CENTER, 45, 45));

		this.facture=new JButton();
		this.facture.setBackground(Color.WHITE);
		this.facture.addActionListener( new ReglerController(this.facture));
		this.facture.setIcon(new ImageIcon(getClass().getResource("/images/fac.png")));

		this.manuel=new JButton();
		this.manuel.setBackground(Color.WHITE);
		this.manuel.setIcon(new ImageIcon(getClass().getResource("/images/manuel.png")));

		this.compte=new JButton();
		this.compte.setBackground(Color.WHITE);
		this.compte.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FenetreAuthentification authentification =new FenetreAuthentification(fenetre);
				authentification.setVisible(true);
			}
		});
		this.compte.setIcon(new ImageIcon(getClass().getResource("/images/compteN.png")));

		this.add(facture);
		this.add(manuel);
		this.add(compte);
	}

	// ***** METHODES ***** //
 	@Override
	public void paintComponent(Graphics g) {
	super.paintComponents(g);
String s1="NOUVELLE FACTURE";
String s2="CONSULTER MON COMPTE";
String s3="MANUEL DE L'UTILISATEUR";
 		Graphics2D g2=(Graphics2D)g;
 		g2.setFont(new Font("inter", Font.BOLD, 20));
		g2.setColor(Color.WHITE);
		g2.drawString(s1, this.facture.getX(), this.facture.getY()+this.facture.getHeight()+40);
		g2.drawString(s2, this.compte.getX(), this.compte.getY()+this.compte.getHeight()+40);
		g2.drawString(s3, this.manuel.getX(), this.manuel.getY()+this.manuel.getHeight()+40);
 	}
}
