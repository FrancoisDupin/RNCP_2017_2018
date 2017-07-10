package introductionSwingform.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class MonListener1 implements ActionListener {

	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public MonListener1(String name) {
		setName(name);
	}
	
	// cette methode h�rit�e d'ActionListener est celle qui sera appel�
	// par le composant acout� (bouton, checkbox, etc...)
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JOptionPane.showMessageDialog(null, "action declench�e chez " + getName());
	}

}
