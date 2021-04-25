import controller.Control;
import processing.core.PApplet;

public class main extends PApplet {
private Control control; 
public static void main(String[] args) {
	// TODO Auto-generated method stub
	PApplet.main(main.class.getName());
	
}
public void settings () {
size(1000,500);

}

public void setup () {
control = new Control(this);

}
public void draw() {
	
	
	
	background(0);
	
	text("Presione i para ordenar ID", 10, 250);
	text("Presione n para ordenar Nombre", 10, 270);
	text("Presione f para ordenar Fecha", 10, 290);
	text("Presione e para ordenar Edad", 10, 310);
	text("Presione R para ordenar Raza", 10, 330);
	
	
	
	for (int i = 0; i < control.getListPerros().size(); i++) {
		control.getListPerros().get(i).pintar(10+(190*i));
		
		
	}
	
}
public void keyPressed(){
control.sortList (key);
}

}
