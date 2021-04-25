package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

import processing.core.PApplet;

public class Logic {
	private String [] perrosNombre;
	private String [] perrosDatos;
	private String id, name;

	private String [] ordenId, ordenNombre, ordenRaza, ordenFecha, ordenEdad;

	private LinkedList<Perro> perroList;

	private Comparador_edad compararEdad;
	private Comparador_fecha compararFecha;
	private Comparador_nombre compararNombre;
	private Comparador_raza compararRaza;


	private PApplet app;
	public Logic (PApplet app)  {
		this.app = app;

		perrosNombre= app.loadStrings("../data/import/perroNombre.txt");
		perrosDatos= app.loadStrings("../data/import/perroDatos.txt");

		perroList = new LinkedList<Perro>();

		leerTexto();

		compararEdad = new Comparador_edad();
		compararFecha = new Comparador_fecha();
		compararNombre = new Comparador_nombre();
		compararRaza = new Comparador_raza();

		ordenId = new String [5];
		ordenEdad = new String [5];
		ordenNombre = new String [5];
		ordenRaza = new String [5];
		ordenFecha= new String [5];


	}
	public void leerTexto () {
		for (int i = 0; i < perrosNombre.length; i++) {
			String [] lineString = perrosNombre[i].split(" ");

			id = lineString[0];

			name = lineString[1]; 

			for (int j = 0; j < perrosDatos.length; j++) {

				String [] lineString2 = perrosDatos [j].split(" ");

				String id2 = lineString2[0];



				if (id.equals(id2) && id.equals("id")== false) {

					String raza = lineString2 [1];
					SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

					Date fecha = null;
					LocalDate ahora = LocalDate.now();
					try {
						fecha = format.parse(lineString2 [2]);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate fechaNac = LocalDate.parse(lineString2 [2].replace("-", "/"), fmt);

					Period periodo = Period.between(fechaNac, ahora);
					System.out.println(periodo.getYears());

					int iD = Integer.parseInt(id);



					perroList.add(new Perro(name, raza, fecha, periodo.getYears(), periodo.getMonths(), iD, app));
				}

			} 
		}



	}
	public LinkedList<Perro> getPerroList() {
		return perroList;
	}
	public void setPerroList(LinkedList<Perro> perroList) {
		this.perroList = perroList;
	}
	public void sortList(char key) {



		switch (key) {
		case 'i': // Para ordenar ID
			Collections.sort(perroList);
			guardarListas(ordenId);
			app.saveStrings("ordenId.txt", ordenId);
			break;
		case 'n': // Para ordenar por nombre
			Collections.sort(perroList, compararNombre);
			guardarListas(ordenNombre);
			app.saveStrings("ordenNombre.txt", ordenNombre);
			break;
		case 'f': // Para ordenar por fecha
			Collections.sort(perroList, compararFecha);
			guardarListas(ordenFecha);
			app.saveStrings("ordenFecha.txt", ordenFecha);
			break;
		case 'e': // Para ordenar por edad
			Collections.sort(perroList, compararEdad);
			guardarListas(ordenEdad);
			app.saveStrings("ordenEdad.txt", ordenEdad);
			break;
		case 'r': // Para ordenar por raza
			Collections.sort(perroList, compararRaza);
			guardarListas(ordenRaza);
			app.saveStrings("ordenRaza.txt", ordenRaza);
			break;
		default:
			break;
		}

	}

	public void guardarListas (String[] orden) {

		for (int i = 0; i < perroList.size(); i++) {

			String id = Integer.toString(perroList.get(i).getID());
			String años = Integer.toString(perroList.get(i).getYears());
			String meses = Integer.toString(perroList.get(i).getMeses());
			String nombre = perroList.get(i).getName();
			String raza = perroList.get(i).getRace();

			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			String fecha = format.format(perroList.get(i).getDate());
			String perro = id + ", " + nombre + ", " + raza + ", " + fecha + ", " + años + " años y " + meses + " meses" ;
			orden[i] = perro;
		}


	}


}