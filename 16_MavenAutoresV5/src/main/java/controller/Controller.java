package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import Utilidades.UtilidadesInOut;
import dao.AutorDAO;
import model.Autor;
import model.Book;
import vista.MenuOpciones;


public class Controller 
{
	public static AutorDAO autorDAO;
	
	public Controller() 
	{
		
	}
	
	// Establecer CONEXION CON BBDD	
	public static MongoDatabase conexioBDLibreria() 
	{
		//Crear el string de conexion para acceso al cloud Mongo con usuario y password
		// Generado en el Cluster Security / DataBase Access
		// Con la IP añadida en NextWork Access
		MongoClientURI conexionString = new MongoClientURI (
				"mongodb+srv://user_master:master1234@cluster0.x7qc0.mongodb.net/test");
		
		//Crear objeto mongoCliente para iteractuar con la BBDD
		MongoClient mongoCliente = new MongoClient(conexionString);  
		
		//En MongoDatabase se guarda la BBDD indicada 
		MongoDatabase database = mongoCliente.getDatabase("Libreria");
		
		autorDAO = Controller.setSource(database);

		return database;
	}

	// crear un objeto java autorDAO y establecer como fuente de datos MongoDabase
	//authorDAO, que trabaja con la base de datos MONGO LIBRERIA
	public static AutorDAO setSource(MongoDatabase database) {

		AutorDAO authorDAO = new AutorDAO();
		// Fuente de datos (DataSource) será la coleccion(tabla) Autores
		authorDAO.setDataSource(database); 
		
		return authorDAO;

	}


	public static void addAutor(Scanner scanner)
	{
		//Solicitar datos al usuario para añadir el autor
		String nombreAutor = UtilidadesInOut.askNombreAutor(scanner);
		String apellidoAutor = UtilidadesInOut.askApellidoAutor(scanner);
		int edadAutor = UtilidadesInOut.askEdadAutor(scanner);
		
		//Crear lista de libros, por que puede que se introduzca mas de un libro 
		List<Book> nuevaListaLibros = new ArrayList<Book>();
		
		Autor nuevoAutor = new Autor(nombreAutor, apellidoAutor, edadAutor, addLibros(scanner,nuevaListaLibros));

		autorDAO.guardarAutor(nuevoAutor);
	}

	
	public static List<Book> addLibros(Scanner scanner, List<Book> nuevaListaLibros)
	{
		//Solicitar datos de libro/s del autor
		while (true)
		{
			String opcionAddLibro = UtilidadesInOut.askAddLibro(scanner);
			MenuOpciones opcionMenuEnum = MenuOpciones.opcionsEsValida(opcionAddLibro);
			
			if (opcionMenuEnum.equals(MenuOpciones.SALIR))
			{
				break;
			}
			
			String tituloLibro = UtilidadesInOut.askTituloLibro(scanner);
			int anyLibro = UtilidadesInOut.askAnyLibro(scanner);
			int paginasLibro = UtilidadesInOut.askPaginasLibro(scanner);
			
			nuevaListaLibros.add(new Book (tituloLibro, anyLibro, paginasLibro));
		}
		
		return nuevaListaLibros;
	}
	
	
	
	//Impresion de todos lo documentos de la coleccion 
	public static void imprimirTodosAutores(AutorDAO autorDAO)
	{
		autorDAO.impresionTodoslosAutores();
	}
	
	//añadir autorDAO a la colecccion de autores
	public static void add(AutorDAO autorDAO)
	{
		List<Book> listaBooks = new ArrayList<Book>();
		listaBooks.add(new Book("To the lighthouse", 1927, 356));
		listaBooks.add(new Book("Orlando", 1928, 423));
		listaBooks.add(new Book("A room of my own", 1929, 122));

		Autor autor1 = new Autor("Virgina", "Wolf", 59 , listaBooks);
		autorDAO.guardarAutor(autor1);
		
		
		List<Book> listaBooks2 = new ArrayList<Book>();
		listaBooks2.add(new Book("Los enamoramientos", 2020, 350));
		Autor autor2 = new Autor("Javier", "Marias", 50 , listaBooks2);
		autorDAO.guardarAutor(autor2);
		
		List<Book> listaBooks3 = new ArrayList<Book>();
		listaBooks3.add(new Book("La Sombra del viento", 2019, 300));
		Autor autor3 = new Autor("Carlos", "Ruiz", 50 , listaBooks3);
		autorDAO.guardarAutor(autor3);				
	}	
}
