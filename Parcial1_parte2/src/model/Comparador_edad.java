package model;

import java.util.Comparator;

public class Comparador_edad implements Comparator <Perro>{

	@Override
	public int compare(Perro o1, Perro o2) {
		// TODO Auto-generated method stub

		if ( o1.getYears() == o2.getYears()) {
			return o1.getMeses() - o2.getMeses();
		} else {

			return o1.getYears()- o2.getYears();
		}	
	}

}
