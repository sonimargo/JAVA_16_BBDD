package vista;

public enum MenuOpciones 
{
	ANADIR(1,"1 - Añadir un autor, escribe ANADIR"),
	VER(2,"2 - Ver todos los autores, escribe VER"),
	MODIFICAR(3,"3 - Modificar un autor, escribe MODIFICAR"),
	ELIMINAR(4,"4 - Eliminar un autor, escribe ELIMINAR"),
	BUSCAR(5,"5 - Buscar un autor, escribe BUSCAR"),
	AÑADIRLIBRO(6,"6 - Añadir un libro a un autor, escribe ADD"),
	SALIR(7,"7 - Salir del sistema, escribe SALIR"),
	INDEFINIDO(8, "comando indefinido" );
	
	private int opcionNumero;
	private String opcionTexto;
	
	MenuOpciones() 
	{
	}
	
	MenuOpciones(int opcionNum, String opcionTxt) 
	{
		this.opcionNumero = opcionNum;
		this.opcionTexto = opcionTxt;
	}

	
	public static MenuOpciones opcionsEsValida (String opcion)
	{
		MenuOpciones menuOpcionEnum;
		
		// Para cada opcion del menu, comprobar si se ha introducido bien el texto
		for (MenuOpciones menuOpValor : MenuOpciones.values())
		{
			//Enum en mayusculas, con toUpperCase comprobar la opcion en mayuscula
			if (menuOpValor.name().equals(opcion.toUpperCase()))
			{
				menuOpcionEnum = MenuOpciones.valueOf(opcion.toUpperCase());
				return menuOpcionEnum; 
			}
		}
		//Si la opcion introducida no esta dentro del enum, será opcion indefinida
		return MenuOpciones.INDEFINIDO;
	}
	
	/// getters & setters
	public int getOpcionNumero() {
		return opcionNumero;
	}

	public String getOpcionTexto() {
		return opcionTexto;
	}

	
	
}
