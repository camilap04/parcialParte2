package model;

import java.util.Comparator;

public class Comparador_edad implements Comparator <Perro>{

	@Override
	public int compare(Perro o1, Perro o2) {
		// TODO Auto-generated method stub

		if ( o1.getAños() == o2.getAños()) {
			return o1.getMeses() - o2.getMeses();
		} else {

			return o1.getAños()- o2.getAños();
		}	
	}

}
