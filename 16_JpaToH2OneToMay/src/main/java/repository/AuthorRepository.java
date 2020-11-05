package repository;

import javax.persistence.EntityManager;

import model.Autor;

import java.util.List;
import java.util.Optional;

public class AuthorRepository 
{
	private EntityManager entityManager;

	
	public AuthorRepository(EntityManager entityManager) 
	{
		this.entityManager = entityManager;
	}

	//Optional, de JAVA 8. Es un contenedor que puede tener valor o no
	public Optional<Autor> guardar(Autor autor) 
	{
		Optional<Autor> resultadoDeSave;
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(autor);
			entityManager.getTransaction().commit();
			return resultadoDeSave = Optional.of(autor);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
		return resultadoDeSave = Optional.empty();
	}

	public Optional<Autor> buscarPorId(Integer id) 
	{
		Autor autor = entityManager.find(Autor.class, id);

		Optional<Autor> resultadoDeBuscar;
		if (autor != null)
			resultadoDeBuscar = Optional.of(autor);
		else
			resultadoDeBuscar = Optional.empty();
		return resultadoDeBuscar;
	}

	public List<Autor> buscarTodos() 
	{
		return entityManager.createQuery("from Autor").getResultList();
	}

	public Optional<Autor> buscarPorNombre(String nombre) 
	{
		Autor autor = entityManager.createNamedQuery("Autor.buscarPorNombre", Autor.class).setParameter("nombre", nombre)
				.getSingleResult();
		
		Optional<Autor> resultadoDeBuscarPorNombre;
		
		if (autor != null)
			resultadoDeBuscarPorNombre = Optional.of(autor);
		else
			resultadoDeBuscarPorNombre = Optional.empty();
		return resultadoDeBuscarPorNombre;
	}
	
	public Optional<Autor> elimianrPorNombre(String nombre) 
	{
		Autor autor = entityManager.createNamedQuery("Autor.buscarPorNombre", Autor.class).setParameter("nombre", nombre)
				.getSingleResult();
		
		System.out.println(autor);
		entityManager.getTransaction().begin();
		entityManager.remove(autor);
		entityManager.getTransaction().commit();
				
		Optional<Autor> resultadoEliminarPorNombre;
		if (autor != null)
			resultadoEliminarPorNombre = Optional.of(autor);
		else
			resultadoEliminarPorNombre = Optional.empty();
		return resultadoEliminarPorNombre;
	}
	
	

}
