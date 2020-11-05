package repository;

import javax.persistence.EntityManager;

import model.Libro;

import java.util.List;
import java.util.Optional;

public class BookRepository 
{
	private EntityManager entityManager;

	public BookRepository(EntityManager entityManager) 
	{
		this.entityManager = entityManager;
	}

	public Optional<Libro> buscarPorId(Integer id) 
	{
		Libro libro = entityManager.find(Libro.class, id);
		return libro != null ? Optional.of(libro) : Optional.empty();
	}

	public List<Libro> buscarTodos() 
	{
		return entityManager.createQuery("from Libro").getResultList();
	}

	public Optional<Libro> buscarPorTitulo(String titulo) 
	{
		Libro libro = entityManager.createQuery("SELECT b FROM Libro b WHERE b.titulo = :titulo", Libro.class)
				.setParameter("titulo", titulo).getSingleResult();
		return libro != null ? Optional.of(libro) : Optional.empty();
	}

	public Optional<Libro> buscarPorTituloQuery(String titulo) 
	{
		Libro book = entityManager.createNamedQuery("Libro.buscarPorTitulo", Libro.class).setParameter("titulo", titulo)
				.getSingleResult();
		return book != null ? Optional.of(book) : Optional.empty();
	}

	public Optional<Libro> guardar(Libro libro) 
	{
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(libro);
			entityManager.getTransaction().commit();
			return Optional.of(libro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
}