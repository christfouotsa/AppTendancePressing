package vue.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanneauTitreAdmin extends JPanel {
	// ***** VARIABLES **** //
	private JPanel contenant;
	private JButton imprimer;
	private JToolBar barreOutils;
	private JButton supprimer;
	//private JButton modifier;
	//private JButton valider;
	JTextField recherche;
	private ImageIcon icon;
	private Image img;
	@SuppressWarnings("unused")
	private String text;

	// ***** CONSTRUCTEUR **** //
	public PanneauTitreAdmin(String text,JPanel panprincipal,JFrame frame) {
		this.setLayout(new BorderLayout());

		this.text=text;
		this.icon=new ImageIcon(getClass().getResource("/images/barredetitreadmin.png"));
		this.img=this.icon.getImage();

		this.imprimer=new JButton();
		this.imprimer.setBackground(Color.WHITE);
		this.recherche=new JTextField("Rechercher",40);
		this.imprimer.setIcon(new ImageIcon(getClass().getResource("/images/imprimer.jpg")));
		this.imprimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				imprimer(panprincipal,frame);
			}
		});

		this.supprimer=new JButton();
		this.supprimer.setBackground(Color.WHITE);
		this.supprimer.setIcon(new ImageIcon(getClass().getResource("/images/fermer.png")));

		/*this.modifier=new JButton();
		this.modifier.setBackground(Color.WHITE);
		this.modifier.setIcon(new ImageIcon(getClass().getResource("/images/edit.jpg")));
		this.valider=new JButton();
		this.valider.setBackground(Color.WHITE);
		this.valider.setIcon(new ImageIcon(getClass().getResource("/images/ok.png")));*/


		this.barreOutils=new JToolBar(SwingConstants.HORIZONTAL);
		//this.barreOutils.add(valider);
		//this.barreOutils.add(modifier);
		this.barreOutils.add(imprimer);
		this.barreOutils.add(recherche);
		this.barreOutils.add(supprimer);

		this.contenant=new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2=(Graphics2D)g;
				g2.drawImage(img, 0, 0, this);
				g2.setFont(new Font("inter", Font.BOLD,30));
				g2.drawString(text, ABORT , 50);
			}
		};
		this.contenant.setBackground(new Color(51,144,219));
		this.contenant.setBorder(BorderFactory.createEmptyBorder(0, 0, 60, 0));
		this.add(contenant,BorderLayout.PAGE_START);
		this.add(barreOutils);
	}

	// ***** METHODES ***** //
	public void imprimer(JPanel panprincipal,JFrame frame) {
		//**** Methodes pour imprimer au format jpg ****//
		File file=new File("C:\\Users\\UltraBook 3.1\\desktop\\facture.jpg");
		BufferedImage bfi=new BufferedImage(panprincipal.getWidth(), panprincipal.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2=bfi.createGraphics();
		panprincipal.printAll(g2);
		g2.dispose();
		try {
			ImageIO.write(bfi, "jpg", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		   //**** Methodes pour imprimer au format pdf ****//
		Toolkit kit=Toolkit.getDefaultToolkit();
		PrintJob pj=kit.getPrintJob(frame, "Impression",null);
		Graphics g=pj.getGraphics();
		panprincipal.printAll(g);
		pj.end();
	}
	}
