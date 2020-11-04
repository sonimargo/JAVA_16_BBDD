package repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import model.Author;

public class AuthorRepository 
{

	private EntityManager entityManager;

	public AuthorRepository(EntityManager entityManager) 
	{
		this.entityManager = entityManager;
	}
	
	
	public Optional<Author> save(Author author) 
	{
		return Optional.of(author);
	}
	
	
	public void buscarAll()
	//public List<Author> buscarAll()
	{
		
	}
	
	public void buscarPorId(Integer id)
	//public Optional<Author> findById(Integer id)
	{
		
	}
	
	public void buscarPorNombre(String nombre)
	//public Optional<Author> findByName(String name)
	{
		
	}
	
}
