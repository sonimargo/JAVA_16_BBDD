package service;

import java.util.ArrayList;
import java.util.Scanner;

import org.bson.Document;
import org.bson.types.ObjectId;

import model.Bird;
import com.mongodb.client.MongoCollection;

public class DataBaseListaBirds 
{
	public ArrayList<Bird> listaBirds;
	
	
	public DataBaseListaBirds() 
	{
		listaBirds = new ArrayList<Bird>();
	}


	
	public void addAveAlista(Bird ave)
	{
		this.listaBirds.add(ave);
		Document newBird = new Document("_id", new ObjectId());
		newBird.append("nombre", ave.getNombre()).append("nombreLatino", ave.getNombreLatino()).append("obsertacion", ave.getObservacion());
		
	}
	
	public void removeAve(Bird ave)
	{
		//this.listaBirds.remove(this.listaBirds.indexOf(ave));
		this.listaBirds.remove(ave);
	}
	
	
	public void addObservacion(Bird ave)
	{
		ave.setObservacion(ave.getObservacion() + 1);
	}

	public void addObservacion(Bird ave, int observacion)
	{
		ave.setObservacion(ave.getObservacion() + observacion);
	}
	
	// Imprimir solo un BirdDatabase
	public void visualizarAve (Bird ave)
	{
		System.out.print(ave.toString());
	}

	// Imprimir todos los BirdDatabase incluidos
	public void estadisticas ()
	{
		System.out.print(this);
	}
	
	
	public int tamañoListaBirds()
	{
		return this.listaBirds.size();
	}
	
	/////// getters and setters
	public ArrayList<Bird> getListaBirds() 
	{
		return listaBirds;
	}


	public void setListaBirds(ArrayList<Bird> listaBirds) 
	{
		this.listaBirds = listaBirds;
	}


	@Override
	public String toString() 
	{
		return "Lista Birds= \n" + listaBirds  ;
	}

	
}
