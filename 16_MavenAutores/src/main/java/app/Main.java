package app;

import com.mongodb.client.MongoDatabase;

import controller.Controller;
import dao.AutorDAO; 

public class Main {

	public static void main(String[] args) 
	{
		// Establecer CONEXION CON BBDD Libreria
		MongoDatabase database = Controller.conexioBDLibreria();
		
		//Crear objeto DAO para manejo de datos de la coleccion Autores
		AutorDAO autorDAO = Controller.setSource(database);	
		
		//añadir autorDAO a la colecccion de autores
		//Controller.add(autorDAO);

		//Impresion de todos lo documentos de la coleccion 
		Controller.imprimirTodosAutores(autorDAO);
	}

}
