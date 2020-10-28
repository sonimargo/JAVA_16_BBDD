package vista;

import java.util.ArrayList;
import java.util.Collections;

import utilidades.Utilidades;

public class MenuOptions 
{
	ArrayList<String> listaOpcionesPantalla;
	
	public MenuOptions() 
	{
		listaOpcionesPantalla = new ArrayList<String>() ;
		Collections.addAll(listaOpcionesPantalla, " 1 - Incluir ave en lista"
												, " 2 - Observar ave"
												, " 3 - Visualizar un ave"
												, " 4 - Estadisticas"
												, " 5 - Tamaño lista de aves"
												, " 6 - Eliminar ave de la lista"
												, " 7 - Existe ave de la lista"
												, " Exit (para salir)"
												);
	}

	public String getOption (String opcion)
	{
		return listaOpcionesPantalla.get(listaOpcionesPantalla.indexOf(opcion));
	}

	public void mostrarMenu()
	{
		Utilidades.imprimirTexto("******** Menu ********");
		Utilidades.imprimirTexto("**********************");
		Utilidades.imprimirTexto(listaOpcionesPantalla.get(0));
		Utilidades.imprimirTexto(listaOpcionesPantalla.get(1));
		Utilidades.imprimirTexto(listaOpcionesPantalla.get(2));
		Utilidades.imprimirTexto(listaOpcionesPantalla.get(3));
		Utilidades.imprimirTexto(listaOpcionesPantalla.get(4));
		Utilidades.imprimirTexto(listaOpcionesPantalla.get(5));
		Utilidades.imprimirTexto(listaOpcionesPantalla.get(6));
		Utilidades.imprimirTexto(listaOpcionesPantalla.get(7));
		
	}
}
