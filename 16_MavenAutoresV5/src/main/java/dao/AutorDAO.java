package dao;

import com.mongodb.client.MongoDatabase;

import Utilidades.UtilidadesInOut;
import model.Autor;
import model.Book;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;

public class AutorDAO 
{
	private MongoDatabase database;
	private String coleccionAutoresBD = "Autores";
	
	public AutorDAO() 
	{
		// TODO Auto-generated constructor stub
	}

	
	public void setDataSource(MongoDatabase database) 
	{
		this.database = database;
	}
	
	
	public void guardarAutor(Autor autor)
	{

		//Obtener coleccion con THIS, ja que es una coleciion Mongo
		MongoCollection<Document> autoresCollection = this.getAutoresCollection();

		// JAVA list within mongo DOCUMENT
		List<Document> listaBooksMongo = new ArrayList<Document>();

		//Recorer todos los libros del autor
		for (Book book : autor.getBooks()) 
		{
			//Crear un objeto Java que será Document de Mongo
			Document bookMongo = new Document("_id", new ObjectId());
			//Rellenar el MONGO DOCUMENT con metodos de JAVA gracias a los getters de la clase Book
			bookMongo.append("title", book.getTitle()).append("year", book.getYear()).append("pages", book.getPages());
			listaBooksMongo.add(bookMongo);
		}

		//Crear un objeto Java que será Document de Mongo
		Document autorMongo = new Document("_id", new ObjectId());
		//Rellenar el MONGO DOCUMENT con metodos de JAVA gracias a los getters de la clase Autor
		autorMongo.append("name", autor.getName()).append("surname", autor.getSurname())
				.append("age", autor.getAge()).append("books", listaBooksMongo);
						
		//Se llama a insertOne y se sube/inserta autorMongo, que es un MONGO DOCUMENT
		autoresCollection.insertOne(autorMongo);		
	}
	
	///////////////// metodos para modificacion de autor
	public void modificarAutor(String nombreAutorAmodificar, String newNombre, String apellido, int edad)
	{
		MongoCollection<Document> autorsCollection = this.getAutoresCollection();
		
		//$set - instruccion mongoDB para hacer update
		Document updateResult = autorsCollection.findOneAndUpdate(eq("name", nombreAutorAmodificar), new Document("$set",
				new Document("name", newNombre).append("surname", apellido).append("age", edad)));
		
		UtilidadesInOut.imprimirResultadoUpdate(updateResult, this, nombreAutorAmodificar); 
		
	}
	
	public void modificarAutor(String nombreAutorAmodificar, String newNombre, String apellido)
	{
		MongoCollection<Document> autorsCollection = this.getAutoresCollection();
		
		//$set - instruccion mongoDB para hacer update
		Document updateResult = autorsCollection.findOneAndUpdate(eq("name", nombreAutorAmodificar), new Document("$set",
				new Document("name", newNombre).append("surname", apellido)));
		
		UtilidadesInOut.imprimirResultadoUpdate(updateResult, this, nombreAutorAmodificar); 
		
	}
	
	public void modificarAutor(String nombreAutorAmodificar, String newNombre, int edad)
	{
		MongoCollection<Document> autorsCollection = this.getAutoresCollection();
		
		//$set - instruccion mongoDB para hacer update
		Document updateResult = autorsCollection.findOneAndUpdate(eq("name", nombreAutorAmodificar), new Document("$set",
				new Document("name", newNombre).append("age", edad)));
		
		UtilidadesInOut.imprimirResultadoUpdate(updateResult, this, nombreAutorAmodificar); 
		
	}
	/*
	 * public void modificarAutor(String nombreAutorAmodificar, String apellido, int
	 * edad) { MongoCollection<Document> autorsCollection =
	 * this.getAutoresCollection();
	 * 
	 * //$set - instruccion mongoDB para hacer update Document updateResult =
	 * autorsCollection.findOneAndUpdate(eq("name", nombreAutorAmodificar), new
	 * Document("$set", new Document("surname", apellido).append("age", edad)));
	 * 
	 * UtilidadesInOut.imprimirResultadoUpdate(updateResult, this,
	 * nombreAutorAmodificar);
	 * 
	 * }
	 */
	
	public void modificarAutorNombre(String nombreAutorAmodificar, String newNombre)
	{
		MongoCollection<Document> autorsCollection = this.getAutoresCollection();
		
		//$set - instruccion mongoDB para hacer update
		Document updateResult = autorsCollection.findOneAndUpdate(eq("name", nombreAutorAmodificar), new Document("$set",
				new Document("name", newNombre)));
		
		UtilidadesInOut.imprimirResultadoUpdate(updateResult, this, nombreAutorAmodificar); 
		
	}
	
	public void modificarAutorApellido(String nombreAutorAmodificar, String apellido)
	{
		MongoCollection<Document> autorsCollection = this.getAutoresCollection();
		
		//$set - instruccion mongoDB para hacer update
		Document updateResult = autorsCollection.findOneAndUpdate(eq("name", nombreAutorAmodificar), new Document("$set",
				new Document("surname", apellido)));
		
		UtilidadesInOut.imprimirResultadoUpdate(updateResult, this, nombreAutorAmodificar); 
		
	}
	
	public void modificarAutorEdad(String nombreAutorAmodificar, int edad)
	{
		MongoCollection<Document> autorsCollection = this.getAutoresCollection();
		
		//$set - instruccion mongoDB para hacer update
		Document updateResult = autorsCollection.findOneAndUpdate(eq("name", nombreAutorAmodificar), new Document("$set",
				new Document("age", edad)));
		
		UtilidadesInOut.imprimirResultadoUpdate(updateResult, this, nombreAutorAmodificar); 
		
	}
	
	
	
	
	public Document existeAutor(String nombreAutorAbuscar)
	{
		//Obtener coleccion con THIS, ja que es una coleccion Mongo
		MongoCollection<Document> autoresCollection = this.getAutoresCollection();
		
		Document autorEncontrado = autoresCollection.find(eq("name", nombreAutorAbuscar)).first();

		return autorEncontrado;
					
	}
	
	public int posicionAutor(String nombreAutorAbuscar)
	{
		//Obtener coleccion con THIS, ja que es una coleccion Mongo
		MongoCollection<Document> autoresCollection = this.getAutoresCollection();
		
		Document autorEncontrado = autoresCollection.find(eq("name", nombreAutorAbuscar)).first();


		//MongoCollection<Document> authorsCollection = authorDAO.showAll();

		for (Document autorIterator : autoresCollection.find()) 
		{
			//autorIterator.get
		}
		
		
		return -1;
					
	}	
	
	//obtener la coleccion de autores de la Base de Datos 
	public MongoCollection<Document> getAutoresCollection() {

		MongoCollection<Document> authorsCollection = database.getCollection(coleccionAutoresBD);

		return authorsCollection;

	}
	
	
	//Impresion de todos los autores de la colleccion Mongo
	public void impresionTodoslosAutores() 
	{
		MongoCollection<Document> autoresCollection = database.getCollection(coleccionAutoresBD);
		
		for (Document autorDocument : autoresCollection.find())
		{
			System.out.println(autorDocument.toString());
		}
	}
	
	
}
