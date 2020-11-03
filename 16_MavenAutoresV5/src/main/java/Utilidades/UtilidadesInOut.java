package Utilidades;

import java.util.Scanner;

import org.bson.Document;

import dao.AutorDAO;


public class UtilidadesInOut 
{

	public UtilidadesInOut() 
	{
		// TODO Auto-generated constructor stub
	}

	
	public static String askOpcion(Scanner scanner)
	{
		imprimirTexto("Elige opción: ");
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
	
	
	
	
	
	public static void imprimirResultadoUpdate(Document updateResultat, AutorDAO autorDAO, String autorNomBuscar) 
	{
		if (updateResultat != null) {
			imprimirTexto("Update correcto: " + updateResultat);
			
			imprimirTexto("Updated para: ");
			Document autorEncontrado = autorDAO.existeAutor(autorNomBuscar);

			if (autorEncontrado != null)
				imprimirTexto(autorEncontrado.toJson());
			else
				imprimirTexto("archivo no encontrado: autor encontrado, perdido");

		} else
			imprimirTexto("archivo no encontrado");
	}
}
