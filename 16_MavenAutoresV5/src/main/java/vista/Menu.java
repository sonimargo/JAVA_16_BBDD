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
			
			MenuOpciones menuOpcionEnum = MenuOpciones.opcionsEsValida(opcionPantalla);
			
			if (menuOpcionEnum.equals(MenuOpciones.SALIR))
			{
				//Controller.close(database);
				break;
			}
			if (menuOpcionEnum.equals(MenuOpciones.INDEFINIDO))
			{
				UtilidadesInOut.opcionIndefinida(scannerPantalla);
			}
			
			if (menuOpcionEnum.equals(MenuOpciones.ANADIR))
			{
				Controller.addAutor(scannerPantalla);
			}
			
			if (menuOpcionEnum.equals(MenuOpciones.VER))
			{
				Controller.imprimirTodosAutores();
			}
			
			if (menuOpcionEnum.equals(MenuOpciones.MODIFICAR))
			{
				Controller.modificarUnAutor(scannerPantalla);
			}
			if (menuOpcionEnum.equals(MenuOpciones.ELIMINAR))
			{
				
			}
			if (menuOpcionEnum.equals(MenuOpciones.BUSCAR))
			{
				
			}
			if (menuOpcionEnum.equals(MenuOpciones.AÑADIRLIBRO))
			{
				
			}
		}
	}
}
