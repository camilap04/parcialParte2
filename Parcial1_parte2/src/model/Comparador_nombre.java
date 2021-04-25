package model;

import java.util.Comparator;

public class Comparador_nombre implements Comparator <Perro> {

	@Override
	public int compare(Perro o1, Perro o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}
