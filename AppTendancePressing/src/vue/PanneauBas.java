package vue;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanneauBas extends JPanel{

	// ***** VARIABLES ***** //
	private ImageIcon icofond;
	private Image imgfond;

	// ***** CONSTRUCTEUR ***** //
	public PanneauBas() {
		this.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		this.icofond=new ImageIcon(getClass().getResource("/images/panBas.jpg"));
		this.imgfond=this.icofond.getImage();
	}

	// ***** METHODES ***** //
@Override
@SuppressWarnings("exports")
public void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2=(Graphics2D)g;
	g2.drawImage(this.imgfond, 0, 0,this);
}

}
