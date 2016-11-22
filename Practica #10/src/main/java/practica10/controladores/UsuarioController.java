package practica10.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import practica10.entidades.Rol;
import practica10.entidades.Usuario;
import practica10.servicios.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Paths;
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


    @RequestMapping("/")
    public String listarUsuarios(Model model, HttpServletRequest request){
        List<Usuario> usuarios = usuarioServices.usuarios();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario u = new Usuario();
        u.setUsername(user);
        if(user.equals("anonymousUser"))
            u.setUsername(" ");
        model.addAttribute("usuario",u);
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
    public String nuevoUsuario(@ModelAttribute Usuario usuario, @RequestParam("roles") String[] roles, @RequestParam("uploadfile") MultipartFile uploadfile) {
        String filename = usuario.getCedula() + "_" + uploadfile.getOriginalFilename();
        String directory="C:/clientes/";
        try {
            String filepath = Paths.get(directory, filename).toString();
            BufferedOutputStream stream = null;
            stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
            stream.write(uploadfile.getBytes());
            stream.close();
        }catch (Exception e){

        }
        usuario.setImagen(filename);
        usuarioServices.creacionUsuario(usuario);
        for (int i=0; i< roles.length;i++){
            Rol rol = new Rol();
            rol.setUsuario(usuario);
            rol.setRol(roles[i]);
            rolServices.creacionRol(rol);
        }
        return "redirect:/";
    }





}
