package junit.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liujl.service.PersonService;

public class TestSpringAOP {

	@Test
	public void test() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
		PersonService service=(PersonService)applicationContext.getBean("personServiceBean");
		service.save();
	}

}
