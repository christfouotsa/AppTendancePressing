package vue.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PageBilan extends JPanel{

	// ***** VARIABLES ***** //
	private JPanel panPrincipal;
	private JScrollPane scroll;
	private JPanel action;
	private JPanel titre;

	private JPanel PanAnnuel;
	private JPanel InfoAnnuel;
	private JPanel PanMensuel;
	private JPanel Cammenbert;
	private JPanel InfoMensuel;
	private JPanel CourbeAnnuel;
	private JPanel PanCammenbert;
	private JPanel CourbeMensuel;
	private JPanel InfoCammenbert;

	// ***** CONSTRUCTEUR ***** //
	public PageBilan(JFrame frame) {

this.action=new JPanel();
this.titre=new PanneauTitreAdmin("BIENVENUE DANS LA PAGE DE BILAN ",this,frame);

this.CourbeAnnuel=new JPanel() {
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		int [] vente= {100,120,150,180,200,220,250,280,300,320,350,380};
		String [] mois= {"jan","fev","mar","avr","mai","juin","juil","aout","sep","oct","nov","dec"};
		g2.setColor(Color.BLUE);

		int largeur=getWidth()-50;
		int hauteur=getHeight()-50;
		int echelleX=largeur/12;
		int echelleY=hauteur/(400/2);//on ajoute /2 pour diviser proportionnellement la taille du graphe par 2 et l'adapter au jpanel

		g2.drawLine(25, 25, 25, hauteur+25);
		g2.drawLine(25, hauteur+25, largeur+25, hauteur+25);

		for(int i=0;i<12;i++) {
			g2.drawLine(25+i*echelleX, hauteur+25, 25+i*echelleX, hauteur+20);
			g2.drawString(mois[i], 25+i*echelleX-10, hauteur+40);
		}
		for(int i=0;i<5;i++) {
			g2.drawLine(25, hauteur+25-i*100/2*echelleY, 20, hauteur+25-i*100/2*echelleY);//on ajoute /2 pour diviser proportionnellement la taille du graphe par 2 et l'adapter au jpanel
			g2.drawString(String.valueOf(i*100/2), 10, hauteur+25-i*100/2*echelleY);//on ajoute /2 pour diviser proportionnellement la taille du graphe par 2 et l'adapter au jpanel
		}

		GeneralPath courbe=new GeneralPath();
		courbe.moveTo(25+0*echelleX, hauteur+25-vente[0]/2*echelleY);//on ajoute /2 pour diviser proportionnellement la taille du graphe par 2 et l'adapter au jpanel

		for(int i=1;i<12;i++) {
			courbe.lineTo(25+i*echelleX, hauteur+25-vente[i]/2*echelleY);//on ajoute /2 pour diviser proportionnellement la taille du graphe par 2 et l'adapter au jpanel
		}
		g2.draw(courbe);

	}
} ;
this.CourbeAnnuel.setBackground(Color.WHITE);

this.InfoAnnuel=new JPanel();
this.InfoAnnuel.setBackground(new Color(209,196,233));
this.InfoAnnuel.setPreferredSize(new Dimension(930, 100));

this.PanAnnuel=new JPanel();
this.PanAnnuel.setLayout(new BorderLayout());
this.PanAnnuel.setPreferredSize(new Dimension(930, 400));
this.PanAnnuel.add(CourbeAnnuel);
this.PanAnnuel.add(InfoAnnuel,BorderLayout.SOUTH);
this.PanAnnuel.setBorder(BorderFactory.createTitledBorder("Graphe d'evolution annuel des revenues"));
((TitledBorder) this.PanAnnuel.getBorder()).setTitleColor(Color.BLUE);

this.CourbeMensuel=new JPanel() {
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int[] ventes= {100,120,150,180,200,220,250,280,300,320,350,380};
		String[] jours= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
		"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

		Graphics2D g2=(Graphics2D)g;
		g2.setColor(Color.BLUE);

		// definir les dimensions du diagrammes
		int largeur=getWidth()-50;
		int hauteur=getHeight()	-50;
		//System.out.println(getHeight());

		// definir les echelles
		int echelleX=largeur/31;
		int echelleY=hauteur/(400/2);// pour diviser proportionnellement la taille du graphe par 2 et l'adapter au jpane

		// dessiner les axes
		g2.drawLine(25, 25, 25, hauteur+25);// axe Y
		g2.drawLine(25, hauteur+25, largeur+25, hauteur+25);// axe X

		// dessiner les graduations
		for(int i=0;i<31;i++) {
			g2.drawLine(25+i*echelleX, hauteur+25, 25+i*echelleX, hauteur+20);// graduation axe X
			g2.drawString(jours[i],25+i*echelleX-10,hauteur+40);
		}
		for(int i=0;i<5;i++) {
			g2.drawLine(25, hauteur+25-i*100/2*echelleY, 20, hauteur+25-i*100/2*echelleY);// graduation axe X //on ajoute /2 pour diviser proportionnellement la taille du graphe par 2 et l'adapter au jpanel
			g2.drawString(String.valueOf(i*100/2),10,hauteur+25-i*100/2*echelleY);//on ajoute /2 pour diviser proportionnellement la taille du graphe par 2 et l'adapter au jpanel
		}

		// dessiner les battons
		for(int i=0;i<12;i++) {
			int x=25+i*echelleX;
			int y=hauteur+25-ventes[i]/2*echelleY;//on ajoute /2 pour diviser proportionnellement la taille du graphe par 2 et l'adapter au jpanel
			int largeurBatton=echelleX-5;
			int hauteurBatton=ventes[i]/2*echelleY;//on ajoute /2 pour diviser proportionnellement la taille du graphe par 2 et l'adapter au jpanel
			g2.fillRect(x, y, largeurBatton, hauteurBatton);
		}
	}
};
this.CourbeMensuel.setBackground(Color.WHITE);

this.InfoMensuel=new  JPanel();
this.InfoMensuel.setBackground(new Color(209,196,233));
this.InfoMensuel.setPreferredSize(new Dimension(930, 100));

this.PanMensuel=new JPanel();
this.PanMensuel.setLayout(new BorderLayout());
this.PanMensuel.add(CourbeMensuel);
this.PanMensuel.add(InfoMensuel,BorderLayout.SOUTH);
this.PanMensuel.setPreferredSize(new Dimension(930, 400));
this.PanMensuel.setBorder(BorderFactory.createTitledBorder("Recapitulatif des revenues journaliers du mois"));
((TitledBorder) this.PanMensuel.getBorder()).setTitleColor(Color.BLUE);

this.Cammenbert=new JPanel() {
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		int [] valeurs= {30,25,20,15,10};// valeur pour chaque secteur
		// String[] libelles= {"chemises","pantalons","tee-shirts","boubou","autres"};// libelles des articles les plus laver
		 Color[] couleurs= {Color.RED,Color.ORANGE,Color.YELLOW,Color.GREEN,Color.BLUE};// couleurs des secteurs du camembert

		 // dessin du camembert
		 int x=getWidth()/2;
		 int y=getHeight()/2;
		 int rayon=Math.min(x, y)-20;
		 g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

		 double angleDebut=0;
		 for(int i=0;i<valeurs.length;i++) {
			 double angleFin=angleDebut+(valeurs[i]/100.0)*360;
			 g2.setColor(couleurs[i]);
			 g2.fillArc(x-rayon, y-rayon, 2*rayon, 2*rayon, (int) angleDebut, (int)(angleFin-angleDebut));
			 angleDebut=angleFin;
		 }

		 for (int valeur : valeurs) {
			 double angleFin=angleDebut+(valeur/100.0)*360;
			 // dessin des libelles
			 Font font=new Font("arial", Font.BOLD, 18);
			 g2.setFont(font);
			 g2.setColor(Color.BLACK);

			 double angle=(int)(angleDebut+angleFin)/2;
			 int libelleX=x+(int) (rayon*1.1*Math.cos(-Math.toRadians(angle)));
			 int libelleY=y+(int) (rayon*1.1*Math.sin(-Math.toRadians(angle)));
			 g2.drawString(String.valueOf(valeur).concat("%"), libelleX, libelleY);
			 angleDebut=angleFin;
		 }
	}
};
this.Cammenbert.setPreferredSize(new Dimension(730, 300));
this.Cammenbert.setBackground(Color.WHITE);

this.InfoCammenbert=new JPanel();
this.InfoCammenbert.setBackground(new Color(209,196,233));
this.InfoCammenbert.setPreferredSize(new Dimension(300, 300));

this.PanCammenbert=new JPanel();
this.PanCammenbert.setLayout(new BorderLayout(0,100));
this.PanCammenbert.add(Cammenbert,BorderLayout.WEST);
this.PanCammenbert.add(InfoCammenbert,BorderLayout.EAST);
this.PanCammenbert.setPreferredSize(new Dimension(930, 300));
this.PanCammenbert.setBorder(BorderFactory.createTitledBorder("habits les plus laver de ce mois"));
((TitledBorder) this.PanCammenbert.getBorder()).setTitleColor(Color.BLUE);

this.panPrincipal=new JPanel();
this.panPrincipal.setLayout(new BorderLayout(0,20));
this.panPrincipal.add(PanAnnuel,BorderLayout.SOUTH);
this.panPrincipal.add(PanMensuel,BorderLayout.NORTH);
this.panPrincipal.add(PanCammenbert,BorderLayout.CENTER);

this.scroll=new JScrollPane(panPrincipal);
this.setLayout(new BorderLayout(0,0));
this.add(titre,BorderLayout.NORTH);
this.add(scroll,BorderLayout.CENTER);
this.add(action,BorderLayout.SOUTH);
	}

	// ***** METHODES ***** //

}
