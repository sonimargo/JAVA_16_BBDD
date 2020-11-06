package utilidades;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import model.Author;
import model.Book;

import repository.AuthorRepository;
import repository.BookRepository;

public class Utilidades 
{
	public Utilidades() 
	{
		// TODO Auto-generated constructor stub
	}

	public static void iniciarDatosAutorLibro(AuthorRepository autorRepository, BookRepository libroRepository)
	{
		////////////////////////////Crear autores y asignar libros		
		// Crear objetos Autor
		//  Autor autor1 = new Autor("Virginia Wolf", "UK"); 
		//  Autor autor2 = new Autor("Leon Tolstoi", "Russia"); 
		//  Autor autor3 = new Autor("Victor Hugo", "French"); 
		//  Autor autor4 = new Autor("Dante Alighieri", "Italy");
		Author autor5 = new Author("Dante", "Italy");
		
		//crea 3 libros y se los asigna al primer autor 
		//autor1.addLibro(new Libro("To the lighthouse")); 
		//autor1.addLibro(new Libro("Orlando"));
		//autor1.addLibro(new Libro("A room of my own"));
		
		// Optional, from JAVA 8. Es un contenedor que puede tener valor o no
		//Optional<Autor> autor1salvado = authorRepository.guardar(autor1);
		//Optional<Autor> autor2salvado = authorRepository.guardar(autor2);
		//Optional<Autor> autor3salvado = authorRepository.guardar(autor3);
		//Optional<Autor> autor4salvado = authorRepository.guardar(autor4);
		Optional<Author> autor5salvado = autorRepository.save(autor5);
		
		//System.out.println("Autores guardados: " + autor1salvado.get());
		////////////////////////////FIN Crear autores y asignar libros
		
		
		////////////////////////////Impresion de todos los autores
		// Buscar todos los autores
		List<Author> authors = autorRepository.findAll();
		System.out.println("Authors:");
		
		/*
		* for (Autor authorToPrint : authors) { System.out.println(authorToPrint); }
		*/
		// Otra forma de hacer un for each
		// authors.forEach(author -> System.out.println(author));
		//    usando el operador de lambda "::" para evitar la crecacion de objetos de un for clasico
		//authors.forEach(System.out::println);
		
		////////////////////////////FIN impresion de todos los autores
		
		
		////////////////////////////Buscar autor por nombre
		// Busca autor por nombre usando Optional de JAVA 8   
		//   Optional no bloquea la ejecución del programa
		// Ha de retornar un unico Autor, sino el Optional es Empty()
		Optional<Author> autorPorNombre = autorRepository.findByName("Virginia");
		System.out.println("********************************************* ");
		System.out.println("************ Buscar por nombre de autor ************");
		autorPorNombre.ifPresent(System.out::println);
		
		//////////////////////////FIN Buscar autor por nombre
		
		//////////////////////////Eliminar autor por nombre		
		// Find author by name and delete it, that is Leon Tolstoi authorByName =
		autorRepository.deleteByName("Dante");
		System.out.println("********************************************* ");
		System.out.println("************ Elminado autor por nombre ************");
		autorPorNombre.ifPresent(System.out::println);
		//////////////////////////FIN eliminar autor por nombre
		
		//////////////////////////Buscar libro por ID
		// Buscar libro por ID, el ibro Orlando es el 2
		System.out.println("********************************************* ");
		System.out.println("************ Busar libro por ID existe ******");		
		Optional<Book> libroEncontrado = libroRepository.findById(2);
		libroEncontrado.ifPresent(System.out::println);
		
		// Buscar libro por un ID que no existe
		System.out.println("********************************************* ");
		System.out.println("************ Busar libro por ID no existe ***");				
		Optional<Book> libroNoEncontrado = libroRepository.findById(30); 
		libroNoEncontrado.ifPresent(System.out::println);
		
		// Lista todos los libros
		System.out.println("********************************************* ");
		System.out.println("************ Busar todos los libros *********");						
		List<Book> libros = libroRepository.findAll();
		
		System.out.println("Libros en BBDD:"); 
		libros.forEach(System.out::println);
		
		// Buscar libro por nombre, con query Select		
		System.out.println("********************************************* ");
		System.out.println("************ Busar libro Query Select  ******");								 
		Optional<Book> libroEncontradoQuery = libroRepository.findByTitle("Orlando");
		System.out.println("Query for book 2 - Select:");
		libroEncontradoQuery.ifPresent(System.out::println);
		
		// Buscar libro por nombre, con query Select		
		System.out.println("********************************************* ");
		System.out.println("************ Busar libro NamedQuery ********");								 
		Optional<Book> libroEncontradoNamedQuery = libroRepository.findByTitleNamedQuery("A room of my own");
		System.out.println("Query for book 3 - NamedQuery:");
		libroEncontradoNamedQuery.ifPresent(System.out::println);
		
		
		// Añadir libro al autor Add Virginia Wolf
		// El #4 libro es "Mrs Daloway" 
		// Para el autor Virginia Wolf tiene id #1 JAVA 8 ayuda con ifPresent y lambda		
		System.out.println("********************************************* ");
		System.out.println("************ Añadir libro a Autor ***********");								 
		Optional<Author> autorAddLibro = autorRepository.findById(2);
		autorAddLibro.ifPresent(libroToAdd -> 
		{
		libroToAdd.addBook(new Book("Mrs Daloway 2"));
		System.out.println("Saved author: " + autorRepository.save(libroToAdd));
		});		
	}
	
	public static String askNomAutor(Scanner scanner)
	{
		System.out.println("Nombre de autor ");
		String nombreAutor = scanner.nextLine();
		return nombreAutor;
	}
	
	public static String askTituloLibro(Scanner scanner)
	{
		System.out.println("Titulo del libro ");
		String tituloLibro = scanner.nextLine();
		return tituloLibro;
	}	
}
