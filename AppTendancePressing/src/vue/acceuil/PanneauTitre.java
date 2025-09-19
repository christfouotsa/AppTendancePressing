package vue.acceuil;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ReglerController;

@SuppressWarnings("serial")
public class PanneauTitre extends JPanel {
	// ***** VARIABLES **** //
	String bienvenue;

	JTextField recherche;
	JButton regler;
	JPanel panmiseajour;
	JPanel pantitre;
	private JButton miseajour;

	// ***** CONSTRUCTEUR **** //
	public PanneauTitre() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		this.bienvenue="BIENVENUE CHEZ TENDANCE PRESSING";
        this.recherche=new JTextField("rechercher une facture",40);
        this.regler=new JButton();
        this.regler.setName("regler");
        this.regler.setContentAreaFilled(false);
        this.regler.setBackground(new Color(248,133,9));
        this.regler.addActionListener(new ReglerController(this.regler));
        this.regler.setIcon(new ImageIcon(getClass().getResource("/images/regler.png")));

		this.miseajour=new JButton();
		this.miseajour.setIcon(new ImageIcon( getClass().getResource("/images/miseajour.png")));
		this.miseajour.setBorderPainted(false);
		this.miseajour.setContentAreaFilled(false);

		this.panmiseajour=new JPanel();
		this.panmiseajour.setBackground(new Color(209,196,233));

        this.pantitre=new JPanel() {
        	@Override
			public void paintComponent(Graphics g) {
   		super.paintComponents(g);
        		ImageIcon icoBackground;
        		Image imgBackground;
        	    icoBackground=new ImageIcon(getClass().getResource("/images/barredetitre.jpg"));
        		imgBackground=icoBackground.getImage();

        		Graphics2D g2=(Graphics2D)g;
        		g2.drawImage(imgBackground, 0, 0, this);
        		g2.setFont(new Font("inter", Font.PLAIN, 36));
        		g2.setColor(Color.WHITE);
        		g2.drawString(bienvenue, 130, 50);
        	}
        };
        this.pantitre.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 70));
        this.pantitre.add(recherche);
        this.pantitre.add(regler);
		this.panmiseajour.add(this.miseajour);

		this.add(panmiseajour,BorderLayout.PAGE_START);
		this.add(pantitre);
	}

	// ***** METHODES ***** //


}
