package model;

public class Bird 
{
	public String nombre;
	public String nombreLatino;
	public int observacion;
	
	public Bird() 
	{
		this.nombre = nombre;
		this.nombreLatino = nombreLatino;
		this.observacion = observacion;
	}
	
	public Bird(String nombre, String nombreLatino) 
	{
		this.nombre = nombre;
		this.nombreLatino = nombreLatino;
		this.observacion = 0;
	}

	public Bird(String nombre, String nombreLatino, int observacion) 
	{
		this.nombre = nombre;
		this.nombreLatino = nombreLatino;
		this.observacion = observacion;
	}

	
	public void printAve (Bird ave)
	{
		System.out.print(ave.toString());
	}
	
	/////// getters and setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreLatino() {
		return nombreLatino;
	}

	public void setNombreLatino(String nombreLatino) {
		this.nombreLatino = nombreLatino;
	}
	
	
	public int getObservacion() {
		return observacion;
	}

	public void setObservacion(int observacion) {
		this.observacion = observacion;
	}

	@Override
	public String toString() {
		return "   Ave: nombre=" + nombre + ", nombreLatino=" + nombreLatino + ", observacion=" + observacion + "\n";
	}

	

}
