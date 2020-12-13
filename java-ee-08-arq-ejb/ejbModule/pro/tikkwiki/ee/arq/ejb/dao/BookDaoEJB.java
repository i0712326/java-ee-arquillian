package pro.tikkwiki.ee.arq.ejb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pro.tikkwiki.ee.arq.jpa.entity.Book;

/**
 * Session Bean implementation class BookDaoEJB
 */
@Stateless
@LocalBean
public class BookDaoEJB {
	@PersistenceContext
	//private EntityManagerFactory emf;
	//@Inject
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public BookDaoEJB() {
        super();
    }
    
	public List<Book> getAllBooks() {
		//TypedQuery<Book> query = em.createNamedQuery("Book.findAll", Book.class);
		//return query.getResultList();
		
		System.out.println("em  = " + em);
		return new ArrayList<Book>();
	}
}
