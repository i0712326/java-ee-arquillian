package pro.itstikk.bean;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Named;

@Named
public class CustomBean {
	private static Logger logger = Logger.getLogger(CustomBean.class.getName());
	public void doSomething() {
		logger.log(Level.INFO,"Call Do Something");
	}
}
