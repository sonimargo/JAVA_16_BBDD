package utilidades;

import java.util.Scanner;

import service.DataBaseListaBirds;

public class Utilidades 
{

	public Utilidades() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public static String pasarAmayusculas (String texto)
	{
		return texto.toUpperCase();
	}
	
	public static String pasarAminusculas (String texto)
	{
		return texto.toLowerCase();
	}
	
	public static void imprimirTexto (String texto)
	{
		System.out.println(texto);
		
	}
	
	
	public static String askNombre(Scanner scanner)
	{
		imprimirTexto("Nombre de ave: ");
		return scanner.nextLine();
	}

	public static String askNombreLatin(Scanner scanner)
	{
		imprimirTexto("Nombre de ave en latin: ");
		return scanner.nextLine();		
	}
	
	public static int askObservacion(Scanner scanner, DataBaseListaBirds listaBirdDB)
	{
		imprimirTexto("Numero de observaciones a introducir: ");
		while (true)
		{
			try 
			{ 
				  return Integer.parseInt(scanner.nextLine()); 
			} 
			catch (NumberFormatException e) 
			{
				Utilidades.imprimirTexto("Introduzca un numero....\n ");
			}
		}
		
	}
	
	
	/*
	 * public static boolean esNumerico(Scanner dato) { String textoOrDigito =
	 * dato.nextLine(); Boolean esNumerico = true;
	 * 
	 * for (int i = 0; i < textoOrDigito.length(); i++) { if
	 * (!Character.isDigit(textoOrDigito.charAt(i))) { // no es numerico return
	 * false; } } if (esNumerico) { return true; } }
	 */
	
	
}
