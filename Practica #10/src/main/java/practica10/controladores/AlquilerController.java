package practica10.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import practica10.entidades.*;
import practica10.servicios.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rony- on 10/25/2016.
 */
@Controller
@RequestMapping("/")
public class AlquilerController {

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
    public String getIndexPage(Model model, HttpServletRequest request) {
        List<Equipo> equipos = equipoServices.equipos();
        String user =SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario u = new Usuario();
        if(user.equals("anonymousUser"))
            u.setUsername(" ");
        else
            u = usuarioServices.user(user);

//        System.out.println("IMG: "+u.getImagen());

        model.addAttribute("usuario",u);
        model.addAttribute("equipos",equipos);
        model.addAttribute("alquiler", new Alquiler());

        return "/indice";
    }

    @RequestMapping("/crearCliente")
    public String cliente(Model model, HttpServletRequest request){

        model.addAttribute("usuario",new Usuario());

        return "/crearCliente";
    }

    @RequestMapping("/factual")
    public String actual(@RequestParam("id") int id,Model model, HttpServletRequest request){
        Factura factura;
        if(id==0){
            if(request.getSession().getAttribute("factura")==null){
                factura = new Factura();
            }
            else {
                int idf = (Integer) request.getSession().getAttribute("factura");
                factura = facturaServices.facturaID(idf);
            }
            String user =SecurityContextHolder.getContext().getAuthentication().getName();
            Usuario u = usuarioServices.user(user);
            //u.setUsername(user);
            if(user.equals("anonymousUser"))
                u.setUsername(" ");
            model.addAttribute("usuario",u);
            model.addAttribute("factura",factura);
            model.addAttribute("alquiler",factura.getEquiposAlquilados());
            return "/factura";

        }
        else {
            factura = facturaServices.facturaID(id);
            ArrayList<Alquiler> alquiler = new ArrayList<>();
            for(int i=0; i < factura.getEquiposAlquilados().size();i++){
                if(!factura.getEquiposAlquilados().get(i).isDevuelto())
                    alquiler.add(factura.getEquiposAlquilados().get(i));
            }
            String user =SecurityContextHolder.getContext().getAuthentication().getName();
            Usuario u = new Usuario();
            u.setUsername(user);
            if(user.equals("anonymousUser"))
                u.setUsername(" ");
            model.addAttribute("usuario",u);
            model.addAttribute("factura",factura);
            model.addAttribute("alquiler",factura.getEquiposAlquilados());
            model.addAttribute("fecha",new Date());
            return "/facturaD";
        }

    }

    @PostMapping("/crearCliente")
    @Transactional
    public String crearCliente(@ModelAttribute Usuario cliente){
        usuarioServices.creacionUsuario(cliente);
        Rol rol = new Rol();
        rol.setUsuario(cliente);
        rol.setRol("ROLE_CLIENTE");
        rolServices.creacionRol(rol);

        return "redirect:/login";
    }

    @PostMapping ("/alquiler")
    @Transactional
    public String addAlquiler(@RequestParam("equipo") int id,Model model, HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario u = usuarioServices.user(auth.getName());
        Equipo equipo = equipoServices.equipoByID(id);
        Alquiler alquiler = new Alquiler();
        alquiler.setEquipo(equipo);
        alquiler.setDevuelto(false);
        Factura factura = new Factura();

        if(request.getSession().getAttribute("factura")==null) {
            factura.setActiva(false);
            factura.setFacturada(false);
            factura.setCliente(u);
            facturaServices.creacionFactura(factura);
            request.getSession().setAttribute("factura",factura.getId());
            System.out.println("1");
        }
        else{
            int fid = (Integer) request.getSession().getAttribute("factura");
            factura = facturaServices.facturaID(fid);
            System.out.println("2");
        }
        alquiler.setFactura(factura);
        alquilerServices.creacionAlquiler(alquiler);
        List<Equipo> equipos = equipoServices.equipos();
        model.addAttribute("usuario",u);
        model.addAttribute("equipos",equipos);
        model.addAttribute("alquiler",alquiler);

        return "/indice";
    }






}
