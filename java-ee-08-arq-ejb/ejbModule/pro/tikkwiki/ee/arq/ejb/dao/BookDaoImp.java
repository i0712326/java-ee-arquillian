package pro.tikkwiki.ee.arq.ejb.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pro.tikkwiki.ee.arq.jpa.entity.Book;

/**
 * Session Bean implementation class BookDaoImp
 */
@Stateless(mappedName = "bookDao")
@LocalBean
public class BookDaoImp implements BookDaoLocal {
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public BookDaoImp() {
        super();
    }

	@Override
	public List<Book> getAllBooks() {
		TypedQuery<Book> query = em.createNamedQuery("Book.findAll", Book.class);
		return query.getResultList();
	}

}
