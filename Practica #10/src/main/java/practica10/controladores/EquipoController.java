package practica10.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practica10.entidades.*;
import practica10.servicios.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by rony- on 10/25/2016.
 */
@Controller
@RequestMapping("/equipo")
public class EquipoController {

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
        List<Equipo> equipos = equipoServices.equipos();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario u = new Usuario();
        u.setUsername(user);
        if(user.equals("anonymousUser"))
            u.setUsername(" ");
        model.addAttribute("usuario",u);
        model.addAttribute("equipos",equipos);
        return "/equipos";
    }

    @RequestMapping("/crearEquipo")
    public String equipo(@RequestParam("fid") int id, Model model, HttpServletRequest request) {
        FamiliaEquipo fa = familiaServices.familiaID(id);
        String user =SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario u = new Usuario();
        u.setUsername(user);
        if(user.equals("anonymousUser"))
            u.setUsername(" ");
        model.addAttribute("usuario",u);
        model.addAttribute("equipo", new Equipo());
        model.addAttribute("familias", subFamiliaServices.subFamiliasFamilia(fa));
        return "/crearEquipo";
    }

    @PostMapping("/crearEquipo")
    @Transactional
    public String nuevoEquipo(@ModelAttribute Equipo equipo, @RequestParam("subFamilia") int idF) {
        SubFamiliaEquipo subFamiliaEquipo = subFamiliaServices.subFamiliaEquipoID(idF);
        equipo.setFamilia(subFamiliaEquipo);
        equipoServices.creacionEquipo(equipo);
        System.out.println("LOL");
        return "redirect:/";
    }





}
