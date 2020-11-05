package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRO")
@NamedQueries
	({ 
		@NamedQuery(name = "Libro.buscarPorTitulo", query = "SELECT b FROM Libro b WHERE b.titulo = :titulo"),
		@NamedQuery(name = "Libro.buscarTodos", query = "SELECT b FROM Libro b") 
	})
public class Libro 
{
	// Toda entidad debe tener id, este decidimos generacion automatica
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	
	@ManyToOne
	@JoinColumn(name = "AUTOR_ID")
	private Autor autor;

	public Libro() 
	{
	}

	public Libro(Integer id, String titulo) 
	{
		this.id = id;
		this.titulo = titulo;
	}

	public Libro(String titulo) 
	{
		this.titulo = titulo;
	}

	
	////  getters and setters
	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public String getTitulo() 
	{
		return titulo;
	}

	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}

	public Autor getAutor() 
	{
		return autor;
	}

	public void setAutor(Autor autor) 
	{
		this.autor = autor;
	}

	@Override
	public String toString() 
	{
		return "Book{" + "id=" + id + ", name='" + titulo + '\'' + ", author=" + autor.getNombre() + '}';
	}
}