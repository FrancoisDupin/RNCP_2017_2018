package javaReflectionform.gui;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Fenetre extends JFrame implements ActionListener {
	public static final String EXAMINE_COMMAND = "examine";
	public static final String INSTANCIER_COMMAND = "instancie";
	
	private JTextField nomClasse;
	private JButton examineBt;
	private JButton instancierbt;
	private JTextArea informations;
	
	
	
	public Fenetre() throws HeadlessException {
		super("reflector!");
		setSize(500, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// partie haute avec les controles
		JPanel panelHaut = new JPanel();
		BoxLayout bl = new BoxLayout(panelHaut, BoxLayout.X_AXIS);
		panelHaut.setLayout(bl);
		
		nomClasse = new JTextField(50);
		panelHaut.add(nomClasse);
		examineBt = new JButton("examiner");
		panelHaut.add(examineBt);
		instancierbt = new JButton("instancier");
		panelHaut.add(instancierbt);
		
		
		add(panelHaut, BorderLayout.NORTH);
		
		examineBt.addActionListener(this);
		examineBt.setActionCommand(EXAMINE_COMMAND);
		instancierbt.addActionListener(this);
		instancierbt.setActionCommand(INSTANCIER_COMMAND);
		
		// zone centrale pour les informations
		informations = new JTextArea();
		
		add(new JScrollPane(informations), BorderLayout.CENTER);

	}

	private void examiner() {
		String nom = nomClasse.getText();
		try {
			// charger dynamiquement la classe denotée
			Class clazz = Class.forName(nom);
			//informations.setText("nom classe = " + clazz.getName());
			StringBuilder sb = new StringBuilder();
			sb.append("nom classe = " + clazz.getName() + "\n");
			sb.append("nom simple classe = " + clazz.getSimpleName() + "\n");
			// je recupere la liste des methodes de cette classe
			Method[] methodes =  clazz.getDeclaredMethods();
			sb.append("---liste des methodes---\n");
			for (Method m : methodes) {
				sb.append(m.getReturnType().getSimpleName() + " " + m.getName() + "()\n");
				sb.append("  -- liste arguments -- \n");
				Class[] params = m.getParameterTypes();
				for (Class p : params) {
					sb.append(p.getSimpleName() + " ");
				}
				sb.append("\n");
			}
			informations.setText(sb.toString());
			
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this,
										"classe inconnue",
										"erreur",
										JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case EXAMINE_COMMAND: examiner(); break;
			case INSTANCIER_COMMAND: instancier(); break;
		}
	}

	private void instancier() {
		String nom = nomClasse.getText();
		try {
			// je recupere une instance d'objet decrivant
			// la classe demandée via le champ de saisie
			Class clazz = Class.forName(nom);
			// avec cet objet 'descripteur' d'une classe choisie
			// je demande une instance de celle-ci
			Object instance = clazz.newInstance();
			//Method m = clazz.getDeclaredMethod("setTitre", String.class);
			//m.invoke(instance, "un nouveau titre");
			
			informations.setText(instance.toString());
			
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this,
					"classe inconnue",
					"erreur",
					JOptionPane.ERROR_MESSAGE);
		} catch (InstantiationException e) {
			JOptionPane.showMessageDialog(this,
					"impossible d'instancier " + e.getMessage(),
					"erreur",
					JOptionPane.ERROR_MESSAGE);
		} catch (IllegalAccessException e) {
			JOptionPane.showMessageDialog(this,
					"erreur de droit a l'instanciation" + e.getMessage(),
					"erreur",
					JOptionPane.ERROR_MESSAGE);
		} /*catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	

}
