package practica10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import practica10.servicios.UsuarioServices;

@SpringBootApplication
public class PracticaApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(PracticaApplication.class, args);
		UsuarioServices usuarioServices = (UsuarioServices) applicationContext.getBean("usuarioServices");
		usuarioServices.admin();



	}
}
