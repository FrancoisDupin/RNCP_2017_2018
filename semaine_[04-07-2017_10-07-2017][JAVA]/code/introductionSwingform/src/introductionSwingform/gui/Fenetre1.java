package introductionSwingform.gui;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Fenetre1 extends JFrame implements ActionListener {

	private JButton bouton1;
	private JTextField champtexte1;
	private JCheckBox caseCoche1;
	private JLabel label1;
	private JTextArea champMultiligne;
	private MonListener1 listener1;
	
	public Fenetre1() throws HeadlessException {
		super("fenetre 1");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		// un bouton
		bouton1 = new JButton("cliquez moi!!");
		add(bouton1);
		
		
		// un champ texte
		champtexte1 = new JTextField(30);
		add(champtexte1);
		
		caseCoche1 = new JCheckBox("cochez moi!");
		add(caseCoche1);
		
		label1 = new JLabel("je suis un label tres intéréssant");
		add(label1);
		
		champMultiligne = new JTextArea(5, 25);
		add(champMultiligne);
		
		// demander au bouton de prévenir mon objet fenetre (qui est ActionListener)
		// quand il est cliqué
		bouton1.addActionListener(this);
		// la case a cocher préviendra cette instance de listener (implementant ActionListener)
		// externe
		listener1 = new MonListener1("premier listener externe");
		caseCoche1.addActionListener(listener1);
		caseCoche1.addActionListener(new MonListener2("deuxieme listener interne"));
		/*
		// classe anonyme interne
		bouton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label1.setText("yolo classe anonyme");
			}
		});
		*/
		// en utilisant un lambda, je fait l'equivalent
		// de ma classe anonyme interne juste au dessus
		// ATTENTION, les lambda ne marche qu'avec des interfaces "fonctionnelles"
		// c'est a dire ne contenu qu'une seule méthode
		bouton1.addActionListener(e -> label1.setText("yolo le lambda"));
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "vous avez cliqué");
	}
	
	// debut classe interne
	public class MonListener2 implements ActionListener {
		private String name;
		public String getName() {return name;	}
		public void setName(String name) {this.name = name;}
		
		public MonListener2(String name) {
			setName(name);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "action de " + getName());
			// une classe interne a acces a tout ce qui est dans la classe englobante
			// même ce qui est privé
			label1.setText(getName() + " was here on " + new Date());
		}
	}
	// fin classe interne
	

}
