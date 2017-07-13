package javaReflectionform.gui;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

	private boolean isSetter(Method m) {
		// si la méthode ne commence pas par "set", ce n'est pas un setter
		if (!m.getName().startsWith("set"))
			return false;
		// si ce n'est pas public, pas intéréssé
		if (!Modifier.isPublic(m.getModifiers()))
			return false;
		// si ca ne renvoie pas void, pas un setter
		if (!m.getReturnType().equals(void.class))
			return false;
		// s'il ya plus ou moins de 1 parametre, ce n'est pas un setter
		if (m.getParameterTypes().length != 1)
			return false;
		return true;
	}
	
	private void fillBean(Object bean, List<Method> setters) {
		try {
			for (Method setter : setters) {
				// le nom de la propriété
				String propName = setter.getName().substring(3);
				// le type de la propriété a setter
				Class typeArgument = setter.getParameterTypes()[0];
				if (typeArgument.equals(String.class)) {
					String saisie = JOptionPane.showInputDialog(
							"saisissez " + propName + " (Chaine de caractere)");
						// on appele le setter sur le bean avec la saisie en parametre
						setter.invoke(bean, saisie);
				}
				else if (typeArgument.equals(int.class)) {
					int saisie = Integer.parseInt(JOptionPane.showInputDialog(
							"saisissez " + propName + " (Entier)"));
						// on appele le setter sur le bean avec la saisie en parametre
						setter.invoke(bean, saisie);
				}
				else if (typeArgument.equals(double.class)) {
					double saisie = Double.parseDouble(JOptionPane.showInputDialog(
							"saisissez " + propName + " (Double)"));
						// on appele le setter sur le bean avec la saisie en parametre
						setter.invoke(bean, saisie);
				}
				else if (typeArgument.equals(boolean.class)) {
					boolean saisie = Boolean.parseBoolean(JOptionPane.showInputDialog(
							"saisissez " + propName + " (Boolean)"));
						// on appele le setter sur le bean avec la saisie en parametre
						setter.invoke(bean, saisie);
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}
	
	
	private void instancier() {
		String nom = nomClasse.getText();
		try {
			// je recupere une instance d'objet decrivant
			// la classe demandée via le champ de saisie
			Class classDescriptor = Class.forName(nom);
			// avec cet objet 'descripteur' d'une classe choisie
			// je demande une instance de celle-ci
			
			Object instance = classDescriptor.newInstance(); 
			//Method m = clazz.getDeclaredMethod("setTitre", String.class);
			//m.invoke(instance, "un nouveau titre");
			
			//Predicate<Method> p = m -> isSetter(m);
			
			Method[] methodes = classDescriptor.getMethods();
			
			List<Method> setters = Arrays.stream(methodes)
									 .filter(m -> isSetter(m))
									 .collect(Collectors.toList());
			
			fillBean(instance, setters);
			
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
