package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class CourbeVentes extends JPanel{

	private int [] vente= {100,120,150,180,200,220,250,280,300,320,350,380};
	private String [] mois= {"jan","fev","mar","avr","mai","juin","juil","aout","sep","oct","nov","dec"};

	public CourbeVentes() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(800, 600));
		this.setBorder(BorderFactory.createTitledBorder("courbes de croissances annuelles"));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;

		g2.setColor(Color.BLUE);

		int largeur=getWidth()-50;
		int hauteur=getHeight()-50;
		int echelleX=largeur/12;
		int echelleY=hauteur/400;

		g2.drawLine(25, 25, 25, hauteur+25);
		g2.drawLine(25, hauteur+25, largeur+25, hauteur+25);

		for(int i=0;i<12;i++) {
			g2.drawLine(25+i*echelleX, hauteur+25, 25+i*echelleX, hauteur+20);
			g2.drawString(mois[i], 25+i*echelleX-10, hauteur+40);
		}
		for(int i=0;i<5;i++) {
			g2.drawLine(25, hauteur+25-i*100*echelleY, 20, hauteur+25-i*100*echelleY);
			g2.drawString(String.valueOf(i*100), 10, hauteur+25-i*100*echelleY);
		}

		GeneralPath courbe=new GeneralPath();
		courbe.moveTo(25+0*echelleX, hauteur+25-vente[0]*echelleY);

		for(int i=1;i<12;i++) {
			courbe.lineTo(25+i*echelleX, hauteur+25-vente[i]*echelleY);
		}
		g2.draw(courbe);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
JFrame frame=new JFrame("Courbes des ventes mensuels");
frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
frame.setContentPane(new CourbeVentes());
frame.setVisible(true);
frame.pack();
	}

}
