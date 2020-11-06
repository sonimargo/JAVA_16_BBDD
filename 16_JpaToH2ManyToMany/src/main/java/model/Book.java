package model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRO")
@NamedQueries({ 
		@NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
		@NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b") 
		})

public class Book {

	@Id
	//@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	//@Column(name = "NAME")
	private String title;
	
	
    @JoinTable(
            name = "Author_Libro",
            joinColumns = {@JoinColumn(name = "fk_idLibro")},
            inverseJoinColumns = {@JoinColumn(name = "fk_idAutor")}
    )
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Author> authors = new HashSet<>();
	

	public Book() {
	}

	public Book(Integer id, String name) {
		this.id = id;
		this.title = name;
	}

	public Book(String name) {
		this.title = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}


	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title +  "]";
	}

	
}