package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// Entity es anotacion de que esta clase esta asociada a una talba AUTOR 
@Entity
@Table(name = "AUTOR")
// this is JPQL very similar to SQL
// it operates on entities, their fields, and their relationships
// NOT on database column names
//SELECT returnedEntity FROM entityName object WHERE whereClause
//FROM entityName object (object from class entityNAME)
// @namedQueries -> name + query
@NamedQueries
	({ 
		@NamedQuery(name = "Autor.buscarPorNombre", query = "SELECT a FROM Autor a WHERE a.nombre = :nombre") 
	})

public class Autor 
{
	//Toda entidad debe tener id, usado para identificar el campo de clave primaria. 
	//En este decidimos generacion automatica
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String pais;
	
	// la persistencia se propagara en cascada para totas las operacioens de EntityManager
	// PERSIST, REMOVE, REFRESH, MERGE, DETACH a las entidades relacionadas
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
	private List<Libro> listaDeLibros = new ArrayList<>();
	

	public Autor() 
	{
	}

	public Autor(String nombre, String pais) 
	{
		this.nombre = nombre;
		this.pais = pais;
	}

	public Autor(Integer id, String nombre) 
	{
		this.id = id;
		this.nombre = nombre;
	}

	
	/// getters and setters
	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	//GETTER from field books
	public List<Libro> getListaDeLibros() {
		return listaDeLibros;
	}

	// SETTER from field books
	// OJO. Setter personalizadao
	//    - en la lista se añade el libro que llega por parametro
	//    - al libro que añadimos, se establece el autor (this)
	public void addLibro(Libro libro) 
	{
		listaDeLibros.add(libro);
		libro.setAutor(this);
	}

	@Override
	public String toString() 
	{
		return "Author{" + "id=" + id + ", nombre='" + nombre + '\'' + ", pais='" + pais + '\'' + ", libros=" + listaDeLibros
				+ '}';
	}
}