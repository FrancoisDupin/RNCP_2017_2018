package beanCreator.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

// on peut parametrer une annotation
// attention cependant, uniquement avec des types basiques et tableau basiques

@Retention(RUNTIME)
@Target(METHOD)
public @interface MessageSaisie {
	String message();

}
