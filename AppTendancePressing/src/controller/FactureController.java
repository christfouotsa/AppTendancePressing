package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreFacture;

public class FactureController implements ActionListener {
	
	private JButton button;
	
	public FactureController(JButton button){
		this.button=button;	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		FenetreFacture facture=new FenetreFacture();
		facture.setVisible(true);
		
		if(this.button.getName()=="regler") {
			for(int i=0;i<facture.getActionButton().getComponentCount();i++)
		 facture.getActionButton().getComponent(i).setEnabled(false);
			for(int i=0;i<facture.getPanSecondaire1a().getComponentCount();i++)
		 facture.getPanSecondaire1a().getComponent(i).setEnabled(false);
			for(int i=0;i<facture.getTextSexe().getComponentCount();i++)
		 facture.getTextSexe().getComponent(i).setEnabled(false);
			for(int i=0;i<facture.getPanSecondaire1b1().getComponentCount();i++)
		 facture.getPanSecondaire1b1().getComponent(i).setEnabled(false);
			for(int i=0;i<facture.getPanSecondaire1b2().getComponentCount();i++)
		 facture.getPanSecondaire1b2().getComponent(i).setEnabled(false);
			for(int i=0;i<facture.getPanSecondaire1c1().getComponentCount();i++)
		 facture.getPanSecondaire1c1().getComponent(i).setEnabled(false);
			for(int i=0;i<facture.getPanSecondaire1c2().getComponentCount();i++)
		 facture.getPanSecondaire1c2().getComponent(i).setEnabled(false);
		 
		facture.getAvance().setEnabled(true);
		facture.getAvancer().setEnabled(true);
		facture.getTextAvance().setEnabled(true);
		facture.getTextAvance().setEnabled(true);
		facture.getEnregistrer().setEnabled(true);
	}
	}
}
