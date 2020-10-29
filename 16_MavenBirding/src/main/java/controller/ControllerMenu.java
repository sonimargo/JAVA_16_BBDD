package controller;

import java.util.ArrayList;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import model.Bird;
import service.DataBaseListaBirds;
import utilidades.Utilidades;

public class ControllerMenu 
{
	//Scanner scannerControlador;
	//ListaBirdsDataBase listaBirdsDB;
	
	public ControllerMenu() 
	{
		// TODO Auto-generated constructor stub
	}

	// Metodos static del Front
	public static String elegirOpcionDePantalla (Scanner scanner, String opcion)
	{
		System.out.println(opcion);
		opcion = scanner.nextLine();
		return opcion;
	}
	
	public static void addAveAlista (Scanner scanner, DataBaseListaBirds listaBirdDB, MongoDatabase database)
	{
		MongoCollection<Document> coleccionBird = database.getCollection("Bird");
		String nombre = Utilidades.askNombre(scanner);		
		String nombreLatin = Utilidades.askNombreLatin(scanner);
		
		if (!existeAveEnLista(listaBirdDB,nombre))
			listaBirdDB.addAveAlista(new Bird(nombre, nombreLatin, 1));
		else
			Utilidades.imprimirTexto("El ave introducida ya existe en BD.....\n");
	}
		
	public static void addObservacion(Scanner scanner, DataBaseListaBirds listaBirdDB)
	{
		String nombreAve = Utilidades.askNombre(scanner);
		
		if (listaBirdDB.listaBirds.isEmpty())
			Utilidades.imprimirTexto("No existen aves en BD ..... \n");
		else
		{
			if (existeAveEnLista(listaBirdDB, nombreAve))
			{
				int numObservacioens = Utilidades.askObservacion(scanner, listaBirdDB);
				
				Bird ave = buscarAveEnLista(listaBirdDB, nombreAve);
				listaBirdDB.addObservacion(ave, numObservacioens);
				Utilidades.imprimirTexto("Ave encontrada ..... \n");
			}
			else
				Utilidades.imprimirTexto("No existe ave " + nombreAve + "    en BD ..... \n");
		} 
	}
	
	//Visualizar un ave
	public static void visualizarAve(Scanner scanner, DataBaseListaBirds listaBirdDB)
	{		   
		  String nombreAve = Utilidades.askNombre(scanner);
		  
		  Bird ave = buscarAveEnLista(listaBirdDB, nombreAve);
		  listaBirdDB.visualizarAve(ave);		  
	}
	
	//Visualizar todas las aves
	public static void estadisticas( DataBaseListaBirds listaBirdDB)
	{
		listaBirdDB.estadisticas();
	}
	
	public static void tamañoListaAves( DataBaseListaBirds listaBirdDB)
	{
		Utilidades.imprimirTexto("Tamaño de la Lista " + listaBirdDB.tamañoListaBirds());
	}
	
	public static void eliminarAveDeLista (Scanner scanner, DataBaseListaBirds listaBirdDB)
	{
		//nombre buscar en lista eliminar
		String nombre = Utilidades.askNombre(scanner);
		Bird ave = buscarAveEnLista(listaBirdDB, nombre);
		listaBirdDB.removeAve(ave);
		//System.out.println(listaBirdDB);
	}
	
	public static void existeAveEnLista (Scanner scanner, DataBaseListaBirds listaBirdDB)
	{
		String nombre = Utilidades.askNombre(scanner);
		Boolean existe = existeAveEnLista(listaBirdDB, nombre);
		if (existe)
			Utilidades.imprimirTexto("Existe ave ");
		else
			Utilidades.imprimirTexto("NO Existe ave ");
	}
	

////////////////////////////////////////////////
/// base datos
	//Introducir datos de la ave 

	
//////////////////////////////////////////////	
	
	
	// Metodos static del controller
	
	public static Bird buscarAveEnLista(DataBaseListaBirds listaBirdDB, String nombreAve)
	{
		if (listaBirdDB.listaBirds.isEmpty())
			return null;
		
		for (Bird pajaro : listaBirdDB.listaBirds )
		{
			if (Utilidades.pasarAmayusculas(pajaro.getNombre()).equals(Utilidades.pasarAmayusculas(nombreAve)))
			{
				return pajaro;
			}			
		}	
		return null;
	}

	public static Boolean existeAveEnLista(DataBaseListaBirds listaBirdDB, String nombreAve)
	{
		if (listaBirdDB.listaBirds.isEmpty())
			return false;
		
		for (Bird pajaro : listaBirdDB.listaBirds )
		{
			if (Utilidades.pasarAmayusculas(pajaro.getNombre()).equals(Utilidades.pasarAmayusculas(nombreAve)))
			{
				return true;
			}			
		}	
		return false;
	}
	
	
}
