package com.mastertheboss.test;

import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.mastertheboss.ejb.ServiceBean;
import com.mastertheboss.model.SimpleProperty;
import com.mastertheboss.producer.Producer;
import com.mastertheboss.repository.RepositoryManager;

@RunWith(Arquillian.class)
public class ServiceTest {
	private static Logger logger = Logger.getLogger(ServiceTest.class.getName());
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
        		  .addPackage(ServiceBean.class.getPackage())
        		  .addPackage(Producer.class.getPackage())
            .addPackage(SimpleProperty.class.getPackage())
            .addPackage(RepositoryManager.class.getPackage())
            .addAsResource("META-INF/persistence.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
           
             
    }

    @Inject
    ServiceBean ejb;

    @Inject
    RepositoryManager repo;

 

    @Test
    public void testRegister() throws Exception {
    	String key = UUID.randomUUID().toString();
    	String value = UUID.randomUUID().toString();
        SimpleProperty p = new SimpleProperty();
        p.setKey(key);
        p.setValue(value);
        ejb.put(p);
        
        List<SimpleProperty> list = repo.queryCache();
        logger.log(Level.INFO,"list size is "+list.size());
        Assert.assertTrue(list.size() > 0);
        
        Assert.assertTrue(list.get(0).getKey().equals(key));
    	

    }

}