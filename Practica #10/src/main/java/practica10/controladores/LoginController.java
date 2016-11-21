package practica10.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import practica10.entidades.Alquiler;
import practica10.entidades.Equipo;
import practica10.entidades.Usuario;
import practica10.servicios.EquipoServices;
import practica10.servicios.UsuarioServices;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;


@Controller()
@RequestMapping("/login")
public class LoginController {

    @Autowired
    EquipoServices equipoServices;

    @Autowired
    UsuarioServices usuarioServices;

    @Autowired
    private MessageSource messageSource;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
        return new ModelAndView("login", "error", error);
    }


}
