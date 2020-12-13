package pro.tikkwiki.ee.arq.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the booktbl database table.
 * 
 */
@Entity
@Table(name="booktbl")
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String sid;

	private String author;

	private String title;

	public Book() {
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}