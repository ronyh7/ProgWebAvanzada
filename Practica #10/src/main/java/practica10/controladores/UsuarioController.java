package practica10.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import practica10.entidades.Rol;
import practica10.entidades.Usuario;
import practica10.servicios.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by rony- on 10/25/2016.
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    AlquilerServices alquilerServices;

    @Autowired
    EquipoServices equipoServices;

    @Autowired
    FacturaServices facturaServices;

    @Autowired
    FamiliaServices familiaServices;

    @Autowired
    SubFamiliaServices subFamiliaServices;

    @Autowired
    UsuarioServices usuarioServices;

    @Autowired
    RolServices rolServices;


    @RequestMapping("")
    public String listarUsuarios(Model model, HttpServletRequest request){
        List<Usuario> usuarios = usuarioServices.usuarios();
        for (int i=0;i< usuarios.size();i++){

        }
        model.addAttribute("usuarios",usuarioServices.usuarios());

        return "/usuarios";
    }

    @RequestMapping("/crearUsuario")
    public String usuario(Model model, HttpServletRequest request) {
        model.addAttribute("usuario", new Usuario());
        return "/crearUsuario";
    }

    @PostMapping("/crearUsuario")
    @Transactional
    public String nuevoUsuario(@ModelAttribute Usuario usuario) {
        String roles[] = usuario.getRolesTemp().split(",");
        usuarioServices.creacionUsuario(usuario);
        System.out.println("LOL");
        for (int i=0; i< roles.length;i++){
            Rol rol = new Rol();
            if(roles[i].equals("1")){
                rol.setUsuario(usuario);
                rol.setNombre("ADMIN");
                rolServices.creacionRol(rol);
            }
            else if(roles[i].equals("2")){
                rol.setUsuario(usuario);
                rol.setNombre("MANAGER");
                rolServices.creacionRol(rol);
            }
            else{
                rol.setUsuario(usuario);
                rol.setNombre("CLIENTE");
            }
            rolServices.creacionRol(rol);
        }
        return "redirect:/";
    }





}
