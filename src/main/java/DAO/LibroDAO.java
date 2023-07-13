package DAO;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import modelo.Libro;

@Stateless
public class LibroDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Libro libro) {
		em.persist(libro);
	}
	
	public void update(Libro libro) {
		em.merge(libro);
	}
	
	public Libro read(long id ) {
		Libro l = em.find(Libro.class, id);
		return l;
	}
	
	public List<Libro> getall() {
		String jpql = "SELECT l FROM Libro l";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
}
