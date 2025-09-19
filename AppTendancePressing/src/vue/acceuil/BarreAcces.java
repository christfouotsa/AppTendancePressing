package vue.acceuil;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ReglerController;
import controller.LienController;
import vue.FenetreAuthentification;

@SuppressWarnings("serial")
public class BarreAcces extends JPanel {

	// ***** VARIABLES ***** //
	private JButton facture;// boutton de nouvelle facture
	private JButton manuel;// boutton d'ouverture du manuel
	private JButton compte;// boutton d'accès à un compte
	private JButton quitter;// boutton d'ouverture du manuel
	private JLabel logopress;
	ImageIcon icologo;
	ImageIcon icoBackground;
	Image imgBackground;

	// ***** CONSTRUCTEUR ***** //
	public BarreAcces(FenetreAcceuil fenetre) {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		// this.icoBackground=new ImageIcon(getClass().getResource("/images/barac.jpg"));
		// this. imgBackground=icoBackground.getImage();
		 this.icologo=new ImageIcon(getClass().getResource("/images/logopress.jpg"));

		 this.facture=new JButton();
		 this.facture.setBackground(Color.WHITE);
		 this.facture.setPreferredSize(new Dimension(200, 80));
		 this.facture.addActionListener(new ReglerController(this.facture));
		 this.facture.setIcon(new ImageIcon(getClass().getResource("/images/petitboutonfacture.jpg")));

		 this.compte=new JButton();
		 this.compte.setBackground(Color.WHITE);
		 this.compte.setPreferredSize(new Dimension(200, 80));
		 this.compte.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FenetreAuthentification authentification =new FenetreAuthentification(fenetre);
				authentification.setVisible(true);
			}
		});
		 this.compte.setIcon(new ImageIcon(getClass().getResource("/images/petitboutoncompte.jpg")));

		 this.manuel=new JButton();
		 this.manuel.setBackground(Color.WHITE);
		 this.manuel.setPreferredSize(new Dimension(200, 80));
		 this.manuel.setIcon(new ImageIcon(getClass().getResource("/images/petitboutonmanuel.jpg")));

		 this.quitter=new JButton();
		 this.quitter.setBackground(Color.WHITE);
		 this.quitter.setPreferredSize(new Dimension(200, 80));
		 this.quitter.setIcon(new ImageIcon(getClass().getResource("/images/petitboutonquitter.jpg")));
	     this.logopress=new JLabel(icologo);

	  	JLabel site=new JLabel("Site web du developpeur");
	  	site.setForeground(Color.BLUE);
	  	site.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	  	site.addMouseListener(new LienController("www.google.com"));
	  	site.setIcon(new ImageIcon(getClass().getResource("/images/web.png")));
	  	site.setBorder(BorderFactory.createEmptyBorder(5, 30, 0, 0));

  		JLabel telephone=new JLabel("+237 682453818");
  		telephone.setForeground(Color.BLUE);
  		telephone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
  		telephone.setIcon(new ImageIcon(getClass().getResource("/images/whatsapp20.png")));
  		telephone.setBorder(BorderFactory.createEmptyBorder(5, 30, 0, 0));

  		JLabel adresse=new JLabel("christfouotsa@gmail.com");
  		adresse.setForeground(Color.BLUE);
  		adresse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
  		adresse.setIcon(new ImageIcon(getClass().getResource("/images/Gmail.jpg")));
  		adresse.setBorder(BorderFactory.createEmptyBorder(5, 30, 0, 0));


		 this.add(this.logopress);
         this.add(facture);
         this.add(compte);
         this.add(manuel);
         this.add(quitter);
         this.add(adresse);
         this.add(site);
         this.add(telephone);
		}

	// ***** METHODES ***** //

}
