package repository;

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
}
