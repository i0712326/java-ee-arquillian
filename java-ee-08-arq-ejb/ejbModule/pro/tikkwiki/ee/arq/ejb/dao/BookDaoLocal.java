package pro.tikkwiki.ee.arq.ejb.dao;

import java.util.List;

import javax.ejb.Local;

import pro.tikkwiki.ee.arq.jpa.entity.Book;

@Local
public interface BookDaoLocal {
	public List<Book> getAllBooks();
}
