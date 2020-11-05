package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Autor;
import model.Libro;
import repository.AuthorRepository;
import repository.BookRepository;
import java.util.List;
import java.util.Optional;

public class Main 
{
	public static void main(String[] args) 
	{	
		// Crear entidaes entidades manager
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("libreria");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		

		// Crear repositorios.
		AuthorRepository autorRepository = new AuthorRepository(entityManager);
		BookRepository libroRepository = new BookRepository(entityManager);
		
//////////////////////////// Crear autores y asignar libros		
		// Crear objetos Autor
		//  Autor autor1 = new Autor("Virginia Wolf", "UK"); 
		//  Autor autor2 = new Autor("Leon Tolstoi", "Russia"); 
		//  Autor autor3 = new Autor("Victor Hugo", "French"); 
		//  Autor autor4 = new Autor("Dante Alighieri", "Italy");
		  Autor autor5 = new Autor("Dante", "Italy");
		  
		  //crea 3 libros y se los asigna al primer autor 
		  //autor1.addLibro(new Libro("To the lighthouse")); 
		  //autor1.addLibro(new Libro("Orlando"));
		  //autor1.addLibro(new Libro("A room of my own"));
		  
		  // Optional, from JAVA 8. Es un contenedor que puede tener valor o no
		  //Optional<Autor> autor1salvado = authorRepository.guardar(autor1);
		  //Optional<Autor> autor2salvado = authorRepository.guardar(autor2);
		  //Optional<Autor> autor3salvado = authorRepository.guardar(autor3);
		  //Optional<Autor> autor4salvado = authorRepository.guardar(autor4);
		  Optional<Autor> autor5salvado = autorRepository.guardar(autor5);
		  
		  //System.out.println("Autores guardados: " + autor1salvado.get());
//////////////////////////// FIN Crear autores y asignar libros
		  
		  
//////////////////////////// Impresion de todos los autores
		// Buscar todos los autores
		List<Autor> authors = autorRepository.buscarTodos();
		System.out.println("Authors:");
		
		/*
		 * for (Autor authorToPrint : authors) { System.out.println(authorToPrint); }
		 */
		// Otra forma de hacer un for each
		// authors.forEach(author -> System.out.println(author));
		//    usando el operador de lambda "::" para evitar la crecacion de objetos de un for clasico
		//authors.forEach(System.out::println);

//////////////////////////// FIN impresion de todos los autores
		

//////////////////////////// Buscar autor por nombre
		// Busca autor por nombre usando Optional de JAVA 8   
		//   Optional no bloquea la ejecución del programa
		// Ha de retornar un unico Autor, sino el Optional es Empty()
		Optional<Autor> autorPorNombre = autorRepository.buscarPorNombre("Virginia");
		System.out.println("********************************************* ");
		System.out.println("************ Buscar por nombre de autor ************");
		autorPorNombre.ifPresent(System.out::println);
		
////////////////////////// FIN Buscar autor por nombre
		
////////////////////////// Eliminar autor por nombre		
		// Find author by name and delete it, that is Leon Tolstoi authorByName =
		autorRepository.elimianrPorNombre("Dante");
		System.out.println("********************************************* ");
		System.out.println("************ Elminado autor por nombre ************");
		autorPorNombre.ifPresent(System.out::println);
////////////////////////// FIN eliminar autor por nombre

////////////////////////// Buscar libro por ID
		// Buscar libro por ID, el ibro Orlando es el 2
		System.out.println("********************************************* ");
		System.out.println("************ Busar libro por ID existe ******");		
		Optional<Libro> libroEncontrado = libroRepository.buscarPorId(2);
		libroEncontrado.ifPresent(System.out::println);
		  
		// Buscar libro por un ID que no existe
		System.out.println("********************************************* ");
		System.out.println("************ Busar libro por ID no existe ***");				
		Optional<Libro> libroNoEncontrado = libroRepository.buscarPorId(30); 
		libroNoEncontrado.ifPresent(System.out::println);
		  
		// Lista todos los libros
		System.out.println("********************************************* ");
		System.out.println("************ Busar todos los libros *********");						
		List<Libro> libros = libroRepository.buscarTodos();
		
		System.out.println("Libros en BBDD:"); 
		libros.forEach(System.out::println);

		// Buscar libro por nombre, con query Select		
		System.out.println("********************************************* ");
		System.out.println("************ Busar libro Query Select  ******");								 
		Optional<Libro> libroEncontradoQuery = libroRepository.buscarPorTitulo("Orlando");
		System.out.println("Query for book 2 - Select:");
		libroEncontradoQuery.ifPresent(System.out::println);
		  
		// Buscar libro por nombre, con query Select		
		System.out.println("********************************************* ");
		System.out.println("************ Busar libro NamedQuery ********");								 
		Optional<Libro> libroEncontradoNamedQuery = libroRepository.buscarPorTituloQuery("A room of my own");
		System.out.println("Query for book 3 - NamedQuery:");
		libroEncontradoNamedQuery.ifPresent(System.out::println);
		  

		// Añadir libro al autor Add Virginia Wolf
		// El #4 libro es "Mrs Daloway" 
		// Para el autor Virginia Wolf tiene id #1 JAVA 8 ayuda con ifPresent y lambda		
		System.out.println("********************************************* ");
		System.out.println("************ Añadir libro a Autor ***********");								 
		Optional<Autor> autorAddLibro = autorRepository.buscarPorId(2);
		autorAddLibro.ifPresent(libroToAdd -> 
			{
				libroToAdd.addLibro(new Libro("Mrs Daloway 2"));
				System.out.println("Saved author: " + autorRepository.guardar(libroToAdd));
			});
				
		// Cerrar los objeos Entity manager y Factory
		entityManager.close();
		entityManagerFactory.close();
	}
}
