package Utilidades;

import java.util.Scanner;

public class UtilidadesInOut 
{

	public UtilidadesInOut() 
	{
		// TODO Auto-generated constructor stub
	}

	
	public static String askOpcion(Scanner scanner)
	{
		imprimirTexto("Nombre de ave: ");
		return scanner.nextLine();
	}
	
	public static String askNombreAutor(Scanner scanner)
	{
		imprimirTexto("Nombre del autor: ");
		return scanner.nextLine();
	}
	
	public static String askApellidoAutor(Scanner scanner)
	{
		imprimirTexto("Apellido del autor: ");
		return scanner.nextLine();
	}
	
	public static int askEdadAutor(Scanner scanner)
	{
		imprimirTexto("Edad del autor: ");
		return scanner.nextInt();
	}	
	
	public static String askAddLibro(Scanner scanner)
	{
		imprimirTexto("Añadir libro al autor: QUIT para salir");
		return scanner.nextLine();
	}	

	
	public static String askTituloLibro(Scanner scanner)
	{
		imprimirTexto("Titulo del libro ");
		return scanner.nextLine();
	}	
	
	public static int askAnyLibro(Scanner scanner)
	{
		imprimirTexto("Escrito el año : ");
		return scanner.nextInt();
	}	
	
	public static int askPaginasLibro(Scanner scanner)
	{
		imprimirTexto("Paginas del libro: ");
		return scanner.nextInt();
	}	
	
	public static void opcionIndefinida(Scanner scanner)
	{
		imprimirTexto("Esta opción no es correcta ");
	}
	/////////////////////////////////////////////////////////
	public static void imprimirTexto (String texto)
	{
		System.out.println(texto);
		
	}
	
	public static void imprimeInicioSesion()
	{
		imprimirTexto("Inicio sesion ");
	}
	public static void imprimeFinDeSesion()
	{
		imprimirTexto("Fin de sesion.... ");
	}
}
