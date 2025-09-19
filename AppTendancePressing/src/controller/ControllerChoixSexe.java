package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

public class ControllerChoixSexe implements ActionListener {

	JRadioButton chk1;
	JRadioButton chk2;

	public ControllerChoixSexe(JRadioButton chk1,JRadioButton chk2) {
    this.chk1=chk1;
    this.chk2=chk2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		chk1.setSelected(true);
		chk2.setSelected(false);
	}

}
