package csvMagician;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import csvMagician.annotations.BooleanConverter;
import csvMagician.annotations.IgnoreGetter;
import csvMagician.annotations.IgnoreSetter;

public class CsvMagician {
	
	public static String beanToCsv(Object bean) {
		Class beanClass = bean.getClass();
		try {
			// récupération des getters
			List<Method> getters = Arrays.stream(beanClass.getMethods())
									 .filter(m -> isGetter(m))
									 .sorted((m1, m2) 
											 -> extractPropName(m1.getName()).compareTo(extractPropName(m2.getName())))
									 .collect(Collectors.toList());
			
			StringBuilder sb = new StringBuilder(beanClass.getSimpleName());
			for(Method getter : getters) {
				sb.append(';');
				// traitement special si boolean
				if (getter.getReturnType().equals(boolean.class)) {
					String trueValue = "true";
					String falseValue = "false";
					// a savoir personnalisation de la valeur ecrite si annotation BooleanConverter
					// présente
					if (getter.isAnnotationPresent(BooleanConverter.class)) {
						BooleanConverter bc = getter.getAnnotation(BooleanConverter.class);
						trueValue = bc.trueValue();
						falseValue = bc.falseValue();
					}
					sb.append(((boolean)getter.invoke(bean))? trueValue : falseValue);
				}
				else
					sb.append(getter.invoke(bean));
			}
			return sb.toString();
		} catch (IllegalAccessException e) {e.printStackTrace();}
		catch (IllegalArgumentException e) {e.printStackTrace();}
		catch (InvocationTargetException e) {e.printStackTrace();}
		
		return null;
	}
	private static String extractPropName(String getterName) {
		if (getterName.startsWith("is"))
			return getterName.substring(2);
		else if (getterName.startsWith("get") || getterName.startsWith("set"))
			return getterName.substring(3);
		return getterName;
	}
	
	private static boolean isGetter(Method m) {
		if(m.isAnnotationPresent(IgnoreGetter.class))
			return false;
		// verification du nom
		if (!m.getName().startsWith("get") && !m.getName().startsWith("is"))
			return false;
		// verification de la visibilité
		if (!Modifier.isPublic(m.getModifiers()) || Modifier.isStatic(m.getModifiers()))
			return false;
		// pas d'argument, sinon c'est pas un getter
		if (m.getParameterTypes().length != 0)
			return false;
		// ne prendre que les getter qui renvoie les types qui m'interesse 
		Class returnType = m.getReturnType();
		if (returnType.equals(String.class) 
				|| returnType.equals(double.class)
				|| returnType.equals(int.class)
				|| returnType.equals(boolean.class)
				|| returnType.equals(char.class))
			return true;
		return false;
	}
	
	private static boolean isSetter(Method m) {
		if(m.isAnnotationPresent(IgnoreSetter.class))
			return false;
		// verification du nom
		if (!m.getName().startsWith("set"))
			return false;
		// verification de la visibilité
		if (!Modifier.isPublic(m.getModifiers()) || Modifier.isStatic(m.getModifiers()))
			return false;
		// si pas un argument, ce n'est pas un setter
		if (m.getParameterTypes().length != 1)
			return false;
		// un setter ne renvoie rien
		if (!m.getReturnType().equals(void.class)) {
			return false;
		}
		// ne prendre que les setter qui prenner un argument du types qui m'interesse 
		Class paramType = m.getParameterTypes()[0];
		if (paramType.equals(String.class) 
				|| paramType.equals(double.class)
				|| paramType.equals(int.class)
				|| paramType.equals(boolean.class)
				|| paramType.equals(char.class))
			return true;
		return false;
	}
	
	public static Object CsvToBean(String line, Class beanClass) throws IllegalArgumentException {
		
		// j'instancie un bean du type voulu vide
		Object bean;
		try {
			bean = beanClass.newInstance();
			// récupération des setters
			List<Method> setters = Arrays.stream(beanClass.getMethods())
									 .filter(m -> isSetter(m))
									 .sorted((m1, m2) 
											 -> extractPropName(m1.getName()).compareTo(extractPropName(m2.getName())))
									 .collect(Collectors.toList());
			String[] champs = line.split(";");
			// je vérifie que la classe de mon bean et la classe indiquée dans le csv correponde
			if (!champs[0].equals(beanClass.getSimpleName()))
				throw new IllegalArgumentException("pas la bonne classe de bean");
			int i = 1;
			for (Method setter : setters) {
				String currentChamp = champs[i++];
				if (setter.getParameterTypes()[0].equals(String.class))
					setter.invoke(bean, currentChamp);
				else if (setter.getParameterTypes()[0].equals(double.class))
					setter.invoke(bean, Double.parseDouble(currentChamp));
				else if (setter.getParameterTypes()[0].equals(int.class))
					setter.invoke(bean, Integer.parseInt(currentChamp));
				else if (setter.getParameterTypes()[0].equals(char.class))
					setter.invoke(bean, currentChamp.charAt(0));
				else if (setter.getParameterTypes()[0].equals(boolean.class)) {
					String trueValue = "true";
					String falseValue = "false";
					// a savoir personnalisation de la valeur ecrite si annotation BooleanConverter
					// présente
					if (setter.isAnnotationPresent(BooleanConverter.class)) {
						BooleanConverter bc = setter.getAnnotation(BooleanConverter.class);
						trueValue = bc.trueValue();
						falseValue = bc.falseValue();
					}
					setter.invoke(bean, trueValue.equals(currentChamp));
				}
				else {
					throw new IllegalArgumentException("type non géré par csvMagician");
				}
			}
			return bean;
		} catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (InvocationTargetException e) {e.printStackTrace();}
		return null;
	}
}
