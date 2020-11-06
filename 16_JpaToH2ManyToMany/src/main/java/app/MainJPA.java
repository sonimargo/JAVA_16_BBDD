package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import controller.ControllerMenu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Author;
import model.Book;
import repository.AuthorRepository;
import repository.BookRepository;
import utilidades.Utilidades;

import java.util.List;
import java.util.Optional;

public class MainJPA 
{
	public static void main(String[] args) {
		
		// Create our entity manager from Persistence
		// and createEntityManagerFactory
		// within unit-persistence "library" 
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("libreria");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Create our repositories
		AuthorRepository authorRepository = new AuthorRepository(entityManager);
		BookRepository bookRepository = new BookRepository(entityManager);
		
		//inicioAutoresBook(authorRepository, bookRepository);
		buscarAutor(authorRepository, bookRepository);
		eliminarAutor(authorRepository, bookRepository);
		
		
		// Close the entity manager and associated factory
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public static void inicioAutoresBook(AuthorRepository authorRepository, BookRepository bookRepository)
	{
		System.out.println("********************************************************");
		System.out.println("************  crear autores / libros *******************");
		// Create four authors
		Author virginia = new Author("Virginia Wolf", "UK");
		Author leon = new Author("Leon Tolstoi", "Russia");
		Author victor = new Author("Victor Hugo", "French");
		Author dante = new Author("Dante Alighieri", "Italy");

		// and after authors, add books to author
		//create three books for the first author, Virginia
		virginia.addBook(new Book("To the lighthouse"));
		virginia.addBook(new Book("Orlando"));
		virginia.addBook(new Book("A room of my own"));
		
		// using optional is a very good idea, from JAVA JDK 8
		Optional<Author> savedAuthor1 = authorRepository.save(virginia);
		Optional<Author> savedAuthor2 = authorRepository.save(leon);
		Optional<Author> savedAuthor3 = authorRepository.save(victor);
		Optional<Author> savedAuthor4 = authorRepository.save(dante);

		System.out.println("Saved author: " + savedAuthor1.get());
		
		// Find all authors
		List<Author> authors = authorRepository.findAll();
		System.out.println("Authors:");
		for (Author authorToPrint : authors) {
			System.out.println(authorToPrint);
		}
		// another way to write for in java
		// authors.forEach(author -> System.out.println(author));
		//besides we use the "::" operator to avoid
		// the creation and use of a tag object as a index at FOR
		authors.forEach(System.out::println);
	}
	
	public static void buscarAutor(AuthorRepository authorRepository, BookRepository bookRepository)
	{
		System.out.println("********************************************************");
		System.out.println("************  buscar autores / libros ******************");
		System.out.println("********************************************************");		
		// Find author by name, that is Leon Tolstoi
		// using Optional JAVA 8 is nice cause be may us ifPresent
		String nombre = "Leon Tolstoi";
		Optional<Author> authorByName = authorRepository.findByName(nombre);
		System.out.println("******************* Buscar por nombre de autor: " + nombre);
		authorByName.ifPresent(System.out::println);

		// Search for a book by ID 1, that is "To the lighthouse"
		Optional<Book> foundBook = bookRepository.findById(1);
		System.out.println("******************* Buscar por id existente de autor: 1");
		foundBook.ifPresent(System.out::println);

		// Search for a book with an invalid ID
		Optional<Book> notFoundBook = bookRepository.findById(20);
		System.out.println("******************* Buscar por id no existente de autor: 20");
		notFoundBook.ifPresent(System.out::println);

		// List all books
		List<Book> books = bookRepository.findAll();
		System.out.println("******************* Libros en BBDD:");
		books.forEach(System.out::println);

		// Find a book by name, so "Orlando"
		String titulo = "Orlando";
		Optional<Book> queryBook2 = bookRepository.findByTitle(titulo);
		System.out.println("******************* Buscar por titulo con (createQuery): " + titulo);
		queryBook2.ifPresent(System.out::println);

		// Find a book by name using a named query, that is "A room of my own"
		titulo = "A room of my own";
		Optional<Book> queryBook3 = bookRepository.findByTitleNamedQuery(titulo);
		System.out.println("******************* Buscar por titulo con (NamedQuery): " + titulo);
		queryBook3.ifPresent(System.out::println);


		

	}
		
	public static void addLibroAlAutor(AuthorRepository authorRepository, BookRepository bookRepository)
	{
		System.out.println("********************************************************");
		System.out.println("************  añadir libro a autor *********************");
		System.out.println("********************************************************");
		// Add a book to author Virginia Wolf, the #4 so "Mrs Daloway"
		// Virginia Wolf is id #1
		// and JAVA 8 is ready to help us with ifPresent and lambda
		List<Book> books = bookRepository.findAll();
		Optional<Author> bookToAuthor = authorRepository.findById(4);
		bookToAuthor.ifPresent(bookToAdd -> {
			bookToAdd.addBook(new Book("Paula"));
			System.out.println("******************* Saved author: " + authorRepository.save(bookToAdd));
		});
		
		// To show how manyToMany works we assign book #2, that is "Orlando"
		// to author #3 Victor Hugo, so one single boos has got 2 authors
		bookToAuthor = authorRepository.findById(3);
		bookToAuthor.ifPresent(bookToAdd -> {
			bookToAdd.addBook(books.get(1));
			System.out.println("******************* Saved author: " + authorRepository.save(bookToAdd));
		});
	}
	
	public static void eliminarAutor(AuthorRepository authorRepository, BookRepository bookRepository)
	{
		System.out.println("********************************************************");
		System.out.println("************  eliminar libro a autor *********************");
		System.out.println("********************************************************");
		Author autor1 = new Author("Isabel Allende", "España");
		autor1.addBook(new Book("La casa de los espiritus"));
		autor1.addBook(new Book("Hija de la fortuna"));		
		Optional<Author> savedAuthor1 = authorRepository.save(autor1);
		System.out.println(autor1);
		
		Optional<Author> authorByName = authorRepository.findByName("Isabel Allende");
		// Find author by name and delete it, that is Isabel Allende
		authorByName = authorRepository.deleteByName("Isabel Allende");
		
		System.out.println("1");
		
		authorByName.ifPresent(System.out::println);
		
		System.out.println("3");
	}
	
}
