package vista;

import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import controller.ControllerMenu;
import service.DataBaseListaBirds;
import utilidades.Utilidades;

public class Menu 
{
	Scanner scannerPantallaMenu;
	DataBaseListaBirds listaBirdsDB; 
	MongoDatabase database;
	
	public Menu(Scanner scannerPantalla, DataBaseListaBirds listaBirdDB) 
	{
		this.scannerPantallaMenu = scannerPantalla;  
		this.listaBirdsDB = listaBirdDB;
	}

	public Menu(Scanner scannerPantalla, DataBaseListaBirds listaBirdDB, MongoDatabase database) 
	{
		this.scannerPantallaMenu = scannerPantalla;  
		this.listaBirdsDB = listaBirdDB;
		this.database = database;
	}

	
	public void solicitarOpcion ()
	{
		String datoEntrada;
		MenuOptions menuOpciones = new MenuOptions();
		
		while (true)
		{					
			menuOpciones.mostrarMenu();
			
			datoEntrada = ControllerMenu.elegirOpcionDePantalla(scannerPantallaMenu, "*****  Selecciona opción: ");			
						
			if (Utilidades.pasarAmayusculas(datoEntrada).equals("EXIT"))
			{
				break;
			} 
			else if (datoEntrada.equals("1"))  // Añadir ave
			{
				ControllerMenu.addAveAlista(scannerPantallaMenu, listaBirdsDB, database);
			} 
			else if   (datoEntrada.equals("2"))  // Añadir observacion
			{
				ControllerMenu.addObservacion(scannerPantallaMenu, listaBirdsDB);
			}
			else if   (datoEntrada.equals("3")) // visualizar un ave
			{				
				ControllerMenu.visualizarAve(scannerPantallaMenu, listaBirdsDB);
			}
			else if   (datoEntrada.equals("4")) // Estadisticas
			{
				ControllerMenu.estadisticas( listaBirdsDB);
			}
			else if   (datoEntrada.equals("5")) // Tamaño
			{
				ControllerMenu.tamañoListaAves( listaBirdsDB);
			}
			else if   (datoEntrada.equals("6")) // eliminar
			{
				ControllerMenu.eliminarAveDeLista(scannerPantallaMenu, listaBirdsDB);
			}			
			else if   (datoEntrada.equals("7")) // existe Ave
			{
				ControllerMenu.existeAveEnLista(scannerPantallaMenu, listaBirdsDB);
			}
			else
				Utilidades.imprimirTexto("No exite la opción seleccionada...... \n");
			
		}		
	}
}
