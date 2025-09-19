package vue.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanneauSecondaireEmploye extends JPanel {
	// ***** VARIABLES ***** //
	private JPanel info;
	private JPanel outils;
	private JLabel icone;

	private JToolBar barreOutils;
	private JButton supprimer;
	private JButton modifier;
	private JButton valider;

	private JLabel nom;
	private JLabel sexe;
	private JLabel poste;
	private JLabel salaire;
	private JLabel matricule;
	private JLabel date_naiss;
	private JLabel heure_arriver;
	private JLabel statut_payement;

	// ***** CONSTRUCTEUR ***** //
	public PanneauSecondaireEmploye(PageEmploye employe) {
		this.setBackground(new Color(51,144,219));
		BorderLayout bl=new BorderLayout();
		this.setLayout(bl);
		bl.setHgap(15);
		this.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

this.info=new JPanel();
this.icone=new JLabel();

this.supprimer=new JButton();
this.supprimer.setIcon(new ImageIcon(getClass().getResource("/images/fermer.png")));
this.supprimer.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		employe.getModel().removeRow(0);
		employe.getPanprincipal().remove(employe.getPanprincipal().getComponentAt(getMousePosition().x,getMousePosition().y));
		employe.getPanprincipal().setModel(employe.model );
		employe.setNbCompte(employe.getNbCompte()-1);
		employe.getEmployes().remove(employe.getNbCompte());
	}
});

this.modifier=new JButton();
this.modifier.setIcon(new ImageIcon(getClass().getResource("/images/edit.jpg")));
this.valider=new JButton();
this.valider.setIcon(new ImageIcon(getClass().getResource("/images/ok.png")));


this.barreOutils=new JToolBar(SwingConstants.HORIZONTAL);
this.barreOutils.add(valider);
this.barreOutils.add(modifier);
this.barreOutils.add(supprimer);

this.nom=new JLabel("Nom:");
this.sexe=new JLabel("Sexe:");
this.poste=new JLabel("Poste:");
this.salaire=new JLabel("Salaire:");
this.matricule=new JLabel("Matricule:");
this.matricule.setFont(new Font(getName(), Font.BOLD, 16));
this.date_naiss=new  JLabel("Date de naissance:");
this.heure_arriver=new JLabel("Heure d'arriver du jour:");
this.statut_payement=new  JLabel("Statut du payement mensuel:");


this.outils=new JPanel();
this.outils.setLayout(new BorderLayout());
this.outils.add(icone,BorderLayout.NORTH);
this.outils.add(barreOutils);

this.icone.setIcon(new ImageIcon(getClass().getResource("/images/compte.jpg")));
this.info.setBackground(new Color(209,196,233));
this.info.setLayout(new GridLayout(8, 1));
this.info.add(matricule);
this.info.add(nom);
this.info.add(sexe);
this.info.add(poste);
this.info.add(salaire);
this.info.add(date_naiss);
this.info.add(heure_arriver);
this.info.add(statut_payement);
this.info.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

this.add(outils,BorderLayout.WEST);
this.add(info);
	}

	public JLabel getNom() {
		return nom;
	}

	public void setNom(JLabel nom) {
		this.nom = nom;
	}

	public JLabel getSexe() {
		return sexe;
	}

	public void setSexe(JLabel sexe) {
		this.sexe = sexe;
	}

	public JLabel getPoste() {
		return poste;
	}

	public void setPoste(JLabel poste) {
		this.poste = poste;
	}

	public JLabel getSalaire() {
		return salaire;
	}

	public void setSalaire(JLabel salaire) {
		this.salaire = salaire;
	}

	public JLabel getMatricule() {
		return matricule;
	}

	public void setMatricule(JLabel matricule) {
		this.matricule = matricule;
	}

	public JLabel getDate_naiss() {
		return date_naiss;
	}

	public void setDate_naiss(JLabel date_naiss) {
		this.date_naiss = date_naiss;
	}

	public JLabel getHeure_arriver() {
		return heure_arriver;
	}

	public void setHeure_arriver(JLabel heure_arriver) {
		this.heure_arriver = heure_arriver;
	}

	public JLabel getStatut_payement() {
		return statut_payement;
	}

	public void setStatut_payement(JLabel statut_payement) {
		this.statut_payement = statut_payement;
	}


 }