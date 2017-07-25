package designPatternFinForm;

import java.util.Iterator;

public class Vecteur implements Iterable<Double> {
	private final double x;
	private final double y;
	private final double z;
	
	public double getX() {return x;}
	public double getY() {return y;}
	public double getZ() {return z;}
	
	public Vecteur(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public String toString() {
		return "Vecteur [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
	@Override
	public Iterator<Double> iterator() {
		return new VecteurIterator();
	}
	
	public class VecteurIterator implements Iterator<Double> {
		
		private int position;
		
		public VecteurIterator() {
			System.out.println("creation iterateur");
			this.position  = -1;
		}
		
		@Override
		public boolean hasNext() {
			System.out.println("has next: position = " + position);
			if (position >= 2)
				return false;
			else
				return true;
		}

		@Override
		public Double next() {
			System.out.println("next: position = " + position);
			position++;
			switch(position) {
				case 0: return x;
				case 1: return y;
				case 2: return z;
			}
			throw new ArrayIndexOutOfBoundsException(position);
		}
		
	}
	

}
