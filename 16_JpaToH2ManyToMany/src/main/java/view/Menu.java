package view;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import utilidades.Utilidades;


public class Menu 
{
	public Menu() 
	{
	}

	
	public void mostrarMenuIO()
	{
		Scanner scannerPantalla = new Scanner(System.in);
		try 
		{
			TimeUnit.SECONDS.sleep(2);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		ImpresionMenu imprimirMenu = new ImpresionMenu(); 
		while (true)
		{
			imprimirMenu.mostrarMenuAutores();
			String opcionPantalla = Utilidades.askOpcion(scannerPantalla);
			
			MenuOpciones menuOpcionEnum = MenuOpciones.opcionsEsValida(opcionPantalla);
			
			if (menuOpcionEnum.equals(MenuOpciones.SALIR))
			{
				//Controller.close(database);
				break;
			}
			if (menuOpcionEnum.equals(MenuOpciones.INDEFINIDO))
			{
				Utilidades.opcionIndefinida(scannerPantalla);
			}
			
			if (menuOpcionEnum.equals(MenuOpciones.ANADIR))
			{
				//Controller.addAutor(scannerPantalla);
			}
			
			if (menuOpcionEnum.equals(MenuOpciones.VER))
			{
				//Controller.imprimirTodosAutores();
			}
			
			if (menuOpcionEnum.equals(MenuOpciones.MODIFICAR))
			{
				//Controller.modificarUnAutor(scannerPantalla);
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
