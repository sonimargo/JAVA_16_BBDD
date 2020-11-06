package controller;

import java.util.Optional;
import java.util.Scanner;

import model.Author;
import repository.AuthorRepository;
import utilidades.Utilidades;

public class ControllerMenu 
{

	public ControllerMenu() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public static void addAutor(AuthorRepository autorRepository)
	{
		Scanner scanner = new Scanner(System.in);
		String nombreAutor = Utilidades.askNomAutor(scanner);
		Optional<Author> autor = autorRepository.findByName(nombreAutor);
		
	}

	public static void addLibro(Scanner scanner)
	{
		String titulo = Utilidades.askTituloLibro(scanner);
	}	
}
