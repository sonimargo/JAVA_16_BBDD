package vista;

public class ImpresionMenus 
{

	public ImpresionMenus() 
	{
		// TODO Auto-generated constructor stub
	}

	public void mostrarMenuAutores()
	{
		//IMPRIMIR UN VALOR DE ENUM
		//   System.out.println("\t" + MenuOptions.ADD.getOptionText());
		//ACCEDIER A UN ENUM EN CONCRETO
		//   Months es un enum
		//       Months.values()[index]
			
		// Recorrer todas las constantes de la enumeración
		for(MenuOpciones menuOp: MenuOpciones.values())
		{
			System.out.println(menuOp.toString());
		}			
			
	}
}
