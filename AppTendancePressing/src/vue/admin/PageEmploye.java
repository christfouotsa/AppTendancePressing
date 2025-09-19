package vue.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import vue.FenetreNouvelEmploye;

@SuppressWarnings("serial")
public class PageEmploye extends JPanel {

	// ***** VAARIABLES ***** //
	private int nbCompte;
	private int poxX;
	private int poxY;
	private JPanel pantitre;
	private JTable panprincipal;
	private JScrollPane scrollprincipal;
	ArrayList<PanneauSecondaireEmploye> employes;
	public PanneauSecondaireEmploye[] tabpanneaux={null};// la table aura un tableau de colonne null donc aucune colone
	DefaultTableModel model;


	// ***** CONSTRUCTEUR ***** //
	public PageEmploye() {
		super();
		this.setLayout(new BorderLayout());
		nbCompte=0;
		poxX=0;
		poxY=0;
		employes=new ArrayList<>();
		panprincipal=new JTable();
		panprincipal.setRowHeight(400);// specifie la hauteur d'une ligne qui ici correspond a celle d'un panneausecondaire

		scrollprincipal=new JScrollPane(panprincipal);
		panprincipal.setTableHeader(null);// la tale n'aura pas d'entete
		panprincipal.setLayout(new BoxLayout(panprincipal,BoxLayout.PAGE_AXIS));
		panprincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panprincipal.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				poxX=e.getX();
				poxY=e.getY();
			}
		});
		model=new DefaultTableModel(tabpanneaux,getNbCompte());

				// construction du panneau de titre
		this.pantitre=new JPanel() {
	    	@Override
			public void paintComponent(Graphics g) {
	    		super.paintComponent(g);
	    		JPanel contenant;
		    	JButton nouvel;
		    	JToolBar barreOutils;
		    	JButton supprimer;
		    	JButton modifier;
		    	JButton valider;
		    	JTextField recherche;

				recherche=new JTextField("Rechercher",40);
				nouvel=new JButton();
				nouvel.setBackground(Color.WHITE);
				nouvel.setIcon(new ImageIcon(getClass().getResource("/images/ajouter.png")));
				nouvel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new  FenetreNouvelEmploye(PageEmploye.this);
					}
				});

				supprimer=new JButton();
				supprimer.setBackground(Color.WHITE);
				supprimer.setIcon(new ImageIcon(getClass().getResource("/images/fermer.png")));
				supprimer.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						getModel().removeRow(0);
						getPanprincipal().remove(getPanprincipal().getComponentAt(getPoxX(),getPoxY()));
						getPanprincipal().setModel(model );
						setNbCompte(getNbCompte()-1);
						getEmployes().remove(getNbCompte());
					}
				});

			    modifier=new JButton();
				modifier.setBackground(Color.WHITE);
				modifier.setIcon(new ImageIcon(getClass().getResource("/images/edit.jpg")));
				modifier.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						new  FenetreNouvelEmploye(PageEmploye.this);
					}
				});
				
				valider=new JButton();
				valider.setBackground(Color.WHITE);
				valider.setIcon(new ImageIcon(getClass().getResource("/images/ok.png")));

				barreOutils=new JToolBar(SwingConstants.HORIZONTAL);
				barreOutils.add(valider);
				barreOutils.add(modifier);
				barreOutils.add(supprimer);
				barreOutils.add(recherche);
				barreOutils.add(nouvel);

				contenant=new JPanel() {
					@Override
					public void paintComponent(Graphics g) {
						super.paintComponent(g);
						Graphics2D g2=(Graphics2D)g;
						g2.setFont(new Font("inter", Font.BOLD,30));
						g2.drawString("BIENVENUE DANS L'ESPACE DES EMPLOYES", ABORT , 50);
						setBackground(new Color(51,144,219));
					}
				};
				contenant.setBorder(BorderFactory.createEmptyBorder(0, 0, 60, 0));
				this.setLayout(new BorderLayout());
				this.add(contenant,BorderLayout.NORTH);
				this.add(barreOutils);
	    	}
	    	};
	    	
	    	
		this.add(pantitre,BorderLayout.NORTH);
		this.add(scrollprincipal);
	}

	// ***** METHODES ***** //
	public void miseAJour(JTextField textNom,JTextField textDate_Naiss){
		getEmployes().get(employes.size()-1).getMatricule().setText(employes.get(employes.size()-1).getMatricule().getText().concat("      31S4"));
		getEmployes().get(employes.size()-1).getNom().setText(employes.get(employes.size()-1).getNom().getText().concat("      "+textNom.getText()));
		getEmployes().get(employes.size()-1).getSexe().setText(employes.get(employes.size()-1).getSexe().getText().concat("      homme"));
		getEmployes().get(employes.size()-1).getDate_naiss().setText(employes.get(employes.size()-1).getDate_naiss().getText().concat("      "+textDate_Naiss.getText()));
		//pse.getPoste().getText().concat(textPoste.getSelectedItem().toString());
		//pse.getSalaire().getText().concat(textsalaire.getValue().toString());
	}

	public void ajoutPanneauEmploye() {
		PanneauSecondaireEmploye pansecondaire=new PanneauSecondaireEmploye(this);
		model.addRow(new PanneauSecondaireEmploye[] {pansecondaire});
		getPanprincipal().add(pansecondaire);
		getPanprincipal().setModel(model);
		getEmployes().add(pansecondaire);
	}

	public JTable getPanprincipal() {
		return panprincipal;
	}

	public void setPanprincipal(JTable panprincipal) {
		this.panprincipal = panprincipal;
	}

	public int getNbCompte() {
		return nbCompte;
	}

	public void setNbCompte(int nbCompte) {
		this.nbCompte = nbCompte;
	}

	public ArrayList<PanneauSecondaireEmploye> getEmployes() {
		return employes;
	}

	public void setEmployes(ArrayList<PanneauSecondaireEmploye> employes) {
		this.employes = employes;
	}

	public int getPoxX() {
		return poxX;
	}

	public void setPoxX(int poxX) {
		this.poxX = poxX;
	}

	public int getPoxY() {
		return poxY;
	}

	public void setPoxY(int poxY) {
		this.poxY = poxY;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
}
