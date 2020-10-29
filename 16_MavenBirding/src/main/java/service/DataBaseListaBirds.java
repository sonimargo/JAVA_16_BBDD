package service;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import org.bson.Document;
import org.bson.types.ObjectId;

import model.Bird;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DataBaseListaBirds 
{
	public ArrayList<Bird> listaBirds;
	private MongoDatabase database;
	
	public DataBaseListaBirds() 
	{
		listaBirds = new ArrayList<Bird>();
	}

	///////////////////  base de datos
	public void setDataSourceAves(MongoDatabase database)
	{
		this.database = database;
	}
	
	public void saveListaBirdBD(DataBaseListaBirds listaBirds)
	{
		//recuperar coleccion con THIS
		//transformar en Mongo Collection
		MongoCollection<Document> avesCollection = this.getListaBirdsBDMongo();
		
		
///////////////////////////////////////////////////////////////////////////		
		//Crear Lista de JAVA con objeto Document de Mongo
		List<Document> ListaAvesMongo = new ArrayList<Document>();
		//Recorer la lista y para cada objeto de la lista
		for (Bird ave : listaBirds.getListaBirds())
		{
			//crear JAVA object para que sea documento mongo
			Document aveMongo = new Document("_id", new ObjectId());
			aveMongo.append("nombre", "Prueva");
			ListaAvesMongo.add(aveMongo);
		}
/////////////////////////////////////////////////////////////////////////
		
		//crear JAVA object para que sea documento mongo
		Document aveMongo = new Document("_id", new ObjectId());
		//rellenar documento con metodos de objetos JAVA get....
		aveMongo.append("nombre", "Prova");		
		
		avesCollection.insertOne(aveMongo);
	}
	
	//////////////////////////////////////////
	
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
	public MongoCollection<Document> getListaBirdsBDMongo() 
	{
		//getter collection from database
		MongoCollection<Document> avesCollection = database.getCollection("Birding");
		
		return avesCollection;
	}
	
	
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
