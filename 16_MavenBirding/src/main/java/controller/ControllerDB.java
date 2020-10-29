package controller;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import service.DataBaseListaBirds;

public class ControllerDB 
{

	// Establecer CONEXION CON BBDD	
	public static MongoDatabase conexioBD() 
	{
		//Crear el string de conexion para acceso al cloud Mongo con usuario y password
		// Generado en el Cluster Security / DataBase Access
		// Con la IP añadida en NextWork Access
		MongoClientURI conexionString = new MongoClientURI (
				"mongodb+srv://user_master:master1234@cluster0.x7qc0.mongodb.net/test");
		
		//Crear objeto mongoCliente para iteractuar con la BBDD
		MongoClient mongoCliente = new MongoClient(conexionString);  
		
		//En MongoDatabase se guarda la BBDD indicada 
		MongoDatabase database = mongoCliente.getDatabase("Birding");

		return database;
	}
	
	// Establecer la conexion a BaseDeDatos MongoDatabase, con la clase JAVA de BBDD
	public static DataBaseListaBirds setSource(MongoDatabase database)
	{
		DataBaseListaBirds listaBirdsBD = new DataBaseListaBirds();
		listaBirdsBD.setDataSourceAves(database);
		return listaBirdsBD;
	}

	
}
