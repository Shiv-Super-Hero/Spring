package src.shivaji.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.shivaji.beans.Employee;

public class Test {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("/com/shivaji/resources/applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		System.out.println(resource.getFilename());
		Employee emp = (Employee) factory.getBean("empBean");
	}

}
