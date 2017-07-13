package csvMagician;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import csvMagician.annotations.IgnoreGetter;

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
	
	
	public static Object CsvToBean(String line, Class beanClass) {
		return null;
	}

}
