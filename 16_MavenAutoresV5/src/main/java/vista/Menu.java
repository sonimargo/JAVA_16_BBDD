package vista;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.mongodb.client.MongoDatabase;

import Utilidades.UtilidadesInOut;
import controller.Controller;

public class Menu 
{
	public Menu() 
	{
	}

	
	public void mostrarMenuIO()
	{
		Scanner scannerPantalla = new Scanner(System.in);
		// Establecer CONEXION CON BBDD Libreria
		MongoDatabase database = Controller.conexioBDLibreria();
		
		
		try 
		{
			TimeUnit.SECONDS.sleep(2);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		ImpresionMenus imprimirMenu = new ImpresionMenus(); 
		while (true)
		{
			imprimirMenu.mostrarMenuAutores();
			String opcionPantalla = UtilidadesInOut.askOpcion(scannerPantalla);
			
			if (opcionPantalla.equals(MenuOpciones.SALIR))
			{
				//Controller.close(database);
				break;
			}
			if (opcionPantalla.equals(MenuOpciones.INDEFINIDO))
			{
				UtilidadesInOut.opcionIndefinida(scannerPantalla);
			}
			
			if (opcionPantalla.equals(MenuOpciones.ANADIR))
			{
				Controller.addAutor(scannerPantalla);
			}
			
			/*
			 * ANADIR(1,"1 - Añadir un autor, escribe ANADIR"),
			 * VER(2,"2 - Ver todos los autores, escribe VER"),
			 * MODIFICAR(3,"3 - Modificar un autor, escribe MODIFICAR"),
			 * ELIMINAR(4,"4 - Eliminar un autor, escribe ELIMINAR"),
			 * BUSCAR(5,"5 - Buscar un autor, escribe BUSCAR"),
			 * AÑADIRLIBRO(6,"6 - Añadir un libro a un autor, escribe ADD"),
			 */
			
			
			
		}
		
		
	}
}
