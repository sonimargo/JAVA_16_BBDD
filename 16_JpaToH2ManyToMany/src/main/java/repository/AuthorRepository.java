package repository;

import javax.persistence.EntityManager;

import model.Author;

import java.util.List;
import java.util.Optional;

public class AuthorRepository 
{
	private EntityManager entityManager;

	public AuthorRepository(EntityManager entityManager) 
	{
		this.entityManager = entityManager;
	}

	public Optional<Author> save(Author author) 
	{
		System.out.println("save autor 1");
		Optional<Author> resultSave;
		if (existeAutor(author))
		{				
			System.out.println("save autor 2");
			try {
				System.out.println("save autor 3");
				entityManager.getTransaction().begin();
				entityManager.persist(author);
				System.out.println("save autor 4");
				entityManager.getTransaction().commit();
				System.out.println("save autor 5");
				return resultSave = Optional.of(author);
	
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("save autor 7");
				return resultSave = Optional.empty();
			}
		}
		else
		{
			System.out.println("save autor 8");
			return resultSave = Optional.empty();
		}
	}

	public Optional<Author> findById(Integer id) 
	{
		System.out.println("existe ID autor 1");
		if (id != null)
		try
		{
			Author author = entityManager.find(Author.class, id);
			Optional<Author> resultFind;
			if (author != null)
			{
				System.out.println("existe ID autor 3");
				resultFind = Optional.of(author);
			}
			else
			{
				System.out.println("existe ID autor 4");
				resultFind = Optional.empty();
			}
			System.out.println("existe ID autor 5");
			return resultFind;
		}
		catch(Exception e)
		{
				System.out.println("existe ID error: " + e);
				return Optional.empty();
		}
		else
			return Optional.empty();		
		
	}

	public List<Author> findAll() 
	{
		return entityManager.createQuery("from Author").getResultList();
	}

	public Optional<Author> findByName(String name) 
	{
		Author author = entityManager.createNamedQuery("Author.findByName", Author.class).setParameter("name", name)
				.getSingleResult();

		Optional<Author> resultFind;
		if (author != null)
			resultFind = Optional.of(author);
		else
			resultFind = Optional.empty();
		return resultFind;
	}

	public Optional<Author> deleteByName(String name) 
	{
		Author author = entityManager.createNamedQuery("Author.findByName", Author.class).setParameter("name", name)
				.getSingleResult();

		System.out.println(author);
		entityManager.getTransaction().begin();
		entityManager.remove(author);
		entityManager.getTransaction().commit();

		
		System.out.println("delete name ");		
		Optional<Author> resultDelete;
		if (author != null)
			resultDelete = Optional.of(author);
		else
			resultDelete = Optional.empty();
		return resultDelete;
	}

	public boolean existeAutor(Author author)
	{
		System.out.println("existe autor 1. id:" + author.getId() + ".... hay id....");
		
		if (author.getId() == null)
		{
			Optional<Author> existeAutor = this.findById(author.getId());
			System.out.println("existe autor 2");
			if (existeAutor != null)
			{
				System.out.println("existe autor 3");
				return true;
			}
			else
			{
				System.out.println("existe autor 4");		
				return false;
			}
		}
		else
			return false;
	}
	

	
	
	
}