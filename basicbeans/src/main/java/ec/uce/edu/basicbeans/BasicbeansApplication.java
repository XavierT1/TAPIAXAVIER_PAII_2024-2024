package ec.uce.edu.basicbeans;

import ec.uce.edu.clases.Persona;
import ec.uce.edu.models.Drawable;
import ec.uce.edu.models.Hero;
import ec.uce.edu.models.Role;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@ComponentScan(basePackages = {"ec.uce.edu.models", "ec.uce.edu.basicbeans"})
public class BasicbeansApplication {

	public static void main(String[] args) {
//		System.setProperty("server.servlet.context-path", "/api/v1");
//		SpringApplication.run(BasicbeansApplication.class, args);


		ApplicationContext context = new AnnotationConfigApplicationContext(BasicbeansApplication.class);
		Hero heroBean = context.getBean(Hero.class);
		heroBean.draw();

		Hero hero = new Hero("user",100,0);
		hero.draw();

//		BeanFactory factory = new ClassPathXmlApplicationContext("file:src/main/resources/personabeans.xml");
//		System.out.println(factory.getBean("persona1"));
//		System.out.println(factory.getBean("persona2"));
//		System.out.println(factory.getBean("calificacion1"));
//		System.out.println(factory.getBean("curso1"));
//		System.out.println(factory.getBean("estudiante1"));
//		System.out.println(factory.getBean("materia1"));
//		System.out.println(factory.getBean("profesor1"));
	}

}
