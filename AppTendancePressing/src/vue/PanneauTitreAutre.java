
package vue;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanneauTitreAutre extends JPanel {

	// ***** VARIABLES ***** //
	private ImageIcon icofond;
	private Image imgfond;
	String text;

	// ***** CONSTRUCTEUR ***** //
	public PanneauTitreAutre(String text) {
	this.setBorder(BorderFactory.createEmptyBorder(60, 0, 0, 0));
		this.text=text;
		this.icofond=new ImageIcon(getClass().getResource("/images/barredetitreautre.jpg"));
		this.imgfond=this.icofond.getImage();
	}

	// ***** METHODES ***** //
@Override
@SuppressWarnings("exports")
public void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2=(Graphics2D)g;
	g2.drawImage(imgfond, 0, 0, this);
	g2.setFont(new Font("inter", Font.BOLD,30));
	g2.drawString(this.text,15+CENTER_ALIGNMENT, 50);
}

}
