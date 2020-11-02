package app;

import Utilidades.UtilidadesInOut;
import vista.Menu; 

public class MainAutores {

	public static void main(String[] args) 
	{
		UtilidadesInOut.imprimeInicioSesion();
		
		Menu menu = new Menu();
		menu.mostrarMenuIO();
		
		UtilidadesInOut.imprimeFinDeSesion();	
		
	}

}
