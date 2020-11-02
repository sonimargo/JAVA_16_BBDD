package dao;

import com.mongodb.client.MongoDatabase;

import model.Autor;
import model.Book;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;


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
