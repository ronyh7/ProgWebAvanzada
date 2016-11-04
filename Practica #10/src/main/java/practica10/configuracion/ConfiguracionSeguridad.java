package practica10.configuracion;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.hibernate.criterion.Restrictions.and;

/**
 * Created by vacax on 27/09/16.
 */
@Configurable
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Cargando los usuarios en memoria.
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username,password, enabled from usuario where username=?").authoritiesByUsernameQuery(
                "select usuario_username, nombre from rol where usuario_username=?");
    }

    /*
     * Permite configurar las reglas de seguridad.
     * @param http
     * @throws Exception
    */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Marcando las reglas para permitir unicamente los usuarios
        http.authorizeRequests()
                .antMatchers("/**").permitAll()
                .and()
                .formLogin()
                    .loginPage("/login") //indicando la ruta que estaremos utilizando.
                    .failureUrl("/login?error")
                    .permitAll()
                .and()
                .logout()
                    .permitAll();
    }
}
