package controller;

import java.util.Optional;
import java.util.Scanner;

import model.Author;
import model.Book;
import repository.AuthorRepository;
import repository.BookRepository;
import utilidades.Utilidades;

public class ControllerMenu 
{

	public ControllerMenu() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public static void addAutor(AuthorRepository autorRepository, BookRepository bookRepository)
	{
		System.out.println("paso 10");
		Scanner scanner = new Scanner(System.in);
		String nombreAutor = Utilidades.askNomAutor(scanner);
		Optional<Author> autor = autorRepository.findByName(nombreAutor);
		// El autor existe, no se puede dar de alta otra vez
		if (!autor.isPresent())
		{
			System.out.println("El autor ya existe, no se puede dar de alta");
		}
		else
		{ 
			String pais = Utilidades.askPais(scanner);
			autor = autorRepository.save(new Author(nombreAutor, pais));
			addLibro(scanner, bookRepository);
		}
		
	}

	public static void addLibro(Scanner scanner,BookRepository bookRepository)
	{
		String titulo = Utilidades.askTituloLibro(scanner);
		if (existeLibro(titulo, bookRepository))
		{
			System.out.println("El libro ya existe, no se puede dar de alta");
		}
		else
			bookRepository.save(new Book(titulo));		
	}	
	
	public static boolean existeLibro(String libroTitulo, BookRepository bookRepository)
	{
		Optional<Book> libroABuscar = bookRepository.findByTitle(libroTitulo);
		
		if (libroABuscar.isPresent())
			return true;
		else
			return false;
	}
	
}
