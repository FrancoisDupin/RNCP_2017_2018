package generiquesCollectionsJavaform.metier;

// couple représentant un ensemble de 2 valeurs
// ici, T1 et T2 sont des "placeholder", ils seront remplacé
// par les veritables types choisi lors de la décalration concrete d'un Tuple

// je rajoute une contrainte sur T2, il doit implementer Comparable
public class Tuple <T1, T2 extends Comparable<T2>> implements Comparable<Tuple<T1, T2>>{
	private T1 value1;
	private T2 value2;
	
	public T1 getValue1() {return value1;}
	public void setValue1(T1 value1) {this.value1 = value1;}
	public T2 getValue2() {return value2;}
	public void setValue2(T2 value2) {this.value2 = value2;}
	
	public Tuple(T1 value1, T2 value2) {
		setValue1(value1);
		setValue2(value2);
	}
	
	@Override
	public String toString() {
		return "Tuple [value1=" + value1 + ", value2=" + value2 + "]";
	}
	@Override
	public int compareTo(Tuple<T1, T2> o) {
		return getValue2().compareTo(o.getValue2());
	}
	
}
