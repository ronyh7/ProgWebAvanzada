package practica10.configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by rony- on 10/20/2016.
 */
@Configuration
public class StaticResourceConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
          String directory ="file:///C:/practica/clientes/";
         registry.addResourceHandler("/archivos/**").addResourceLocations(directory);
         String workingDir = System.getProperty("user.dir");
    }
}