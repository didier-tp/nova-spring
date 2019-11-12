package tp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//NB: @SpringBootApplication est un équivalent
//de @Configuration + @EnableAutoConfiguration + @ComponentScan/current package
@SpringBootApplication
//NB: via le @EnableAutoConfiguration, application.properties sera analysé
//NB: cette classe doit être dans tp pour que le @ComponentScan automatique
// scrute tous les sous packages tp.dao, tp.service , ...
public class MySpringBootApplication extends SpringBootServletInitializer {
public static void main(String[] args) {
	SpringApplication.run(MySpringBootApplication.class, args);
	System.out.println("http://localhost:8080/myMvcSpringBootApp");
}
}
