package app;

import java.util.Scanner;
import vista.Menu;
import service.DataBaseListaBirds;
import utilidades.UtilsInicializar;

import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Main 
{
	public static void main(String[] args) 
	{
		//////// CONEXION CON BBDD
		//Crear el strin de conexion para acceso al cloud Mongo con usuario y password
		// Generado en el Cluster Security / DataBase Access
		// Con la IP añadida en NextWork Access
		MongoClientURI conexionString = new MongoClientURI (
				"mongodb+srv://user_master:master1234@cluster0.x7qc0.mongodb.net/test"); 
		
		//Crear objeto mongoCliente para iteractuar con la BBDD
		MongoClient mongoCliente = new MongoClient(conexionString);  
		
		MongoDatabase database = mongoCliente.getDatabase("Birding");
		MongoCollection<Document> coleccionBird = database.getCollection("Bird");
		
		
		System.out.println("Aves  num..... " + coleccionBird.countDocuments() );
		
		Document newBird = new Document("_id", new ObjectId());
		newBird.append("nombre", "Aguila").append("nombreLatino", "Aguil").append("obsertacion", 1);

		coleccionBird.insertOne(newBird);
		
		newBird.append("nombre", "Cuervo").append("nombreLatino", "Corv").append("obsertacion", 1);
		
		Document aveFind = coleccionBird.find().first();				
		
		System.out.println("Aves  num..... " + coleccionBird.countDocuments() );
		System.out.println("Aves  ..... " + aveFind.toJson());
		System.out.println("Aves  ..... " + aveFind.toString());
		
		Document aveFind1 = coleccionBird.find( { nombre: "Cuervo" });
		
		
		//Objetos que necesito en todo el programa
		/*
		 * Scanner scanner = new Scanner(System.in); DataBaseListaBirds listaBirdDB =
		 * new DataBaseListaBirds();
		 * 
		 * //Inicializar la lista para hacer pruebas
		 * listaBirdDB.setListaBirds(UtilsInicializar.listaBirdsInicial);
		 * 
		 * // Creamos menu Menu menu = new Menu(scanner, listaBirdDB, database);
		 * 
		 * menu.solicitarOpcion();
		 * 
		 * System.out.println("Finish ..... ");
		 */
	}
	
}