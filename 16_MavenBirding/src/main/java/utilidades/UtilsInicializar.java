package utilidades;

import java.util.ArrayList;
import model.Bird;

public class UtilsInicializar 
{
	public static ArrayList<Bird> listaBirdsInicial = new ArrayList<Bird>();
	
	static  
	{
		listaBirdsInicial.add(new Bird("Cuervo","Corvus", 5));
		listaBirdsInicial.add(new Bird("Buho","Bujo", 8));
		listaBirdsInicial.add(new Bird("Aguila","Aguil", 1));
		listaBirdsInicial.add(new Bird("Buitre","Bui", 9));		
	}

}
