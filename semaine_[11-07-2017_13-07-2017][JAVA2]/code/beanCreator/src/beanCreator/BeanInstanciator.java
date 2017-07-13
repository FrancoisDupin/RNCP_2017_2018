package beanCreator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class BeanInstanciator {
	
	public static Object  createBean(Class beanClass) {
		
		Object instance = null;
		try {
			// instancier l'objet vide
			instance = beanClass.newInstance();
			// recupérer ses methodes
			Method[] methodes = beanClass.getMethods();
			
			// filtrer pour ne garde que les setter
			List<Method> setters = Arrays.stream(methodes)
									 .filter(m -> isSetter(m))
									 .collect(Collectors.toList());
			// remplir le bean en appelant les setters
			fillBean(instance, setters);
		} catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		return instance;
	}
	
	private static boolean isSetter(Method m) {
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
	
	private static void fillBean(Object bean, List<Method> setters) {
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
}
