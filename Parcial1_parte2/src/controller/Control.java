package controller;

import java.util.LinkedList;

import model.Logic;
import model.Perro;
import processing.core.PApplet;

public class Control {
private Logic logic; 

private PApplet app;

public Control(PApplet app) {

	this.app = app;
	
	logic= new Logic(app);
}

public LinkedList <Perro> getListPerros() {
	return logic.getPerroList();
	
}

public void sortList(char key) {
	logic.sortList (key);
	
}



}
