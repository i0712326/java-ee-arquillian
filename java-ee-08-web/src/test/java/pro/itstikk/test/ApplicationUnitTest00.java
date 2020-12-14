package pro.itstikk.test;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import pro.itstikk.bean.CustomBean;
import pro.tikkwiki.ee.arq.ejb.dao.BookDaoEJB;
import pro.tikkwiki.ee.arq.ejb.dao.BookDaoImp;
import pro.tikkwiki.ee.arq.ejb.dao.BookDaoLocal;
import pro.tikkwiki.ee.arq.jpa.entity.Book;

@RunWith(Arquillian.class)
public class ApplicationUnitTest00 {
	//private static Logger logger = Logger.getLogger(ApplicationUnitTest.class.getName());

	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(JavaArchive.class, "ApplicationUntitTest00.jar")
				.addPackage(BookDaoEJB.class.getPackage())
				.addPackage(BookDaoLocal.class.getPackage())
				.addPackage(BookDaoImp.class.getPackage())
				.addPackage(Book.class.getPackage())
				.addClass(CustomBean.class)
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
				//.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	@EJB
	private BookDaoEJB bookDao;
	@EJB
	private BookDaoLocal bookDaoLocal;
	@Inject
	private CustomBean bean;
	@Test
	public void test01() {
		bean.doSomething();
		Assert.assertTrue(true);
	}
	@Test
	public void test02() {
		Assert.assertNotNull(bookDao.getAllBooks());
	}
	
	@Test
	public void test03() {
		Assert.assertNotNull(bookDaoLocal.getAllBooks());
	}
}
