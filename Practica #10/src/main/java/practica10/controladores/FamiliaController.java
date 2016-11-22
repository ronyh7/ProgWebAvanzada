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
import practica10.entidades.Equipo;
import practica10.entidades.FamiliaEquipo;
import practica10.entidades.SubFamiliaEquipo;
import practica10.entidades.Usuario;
import practica10.servicios.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by rony- on 10/25/2016.
 */
@Controller
@RequestMapping("/familia")
public class FamiliaController {

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
    public String listarFamilias(Model model, HttpServletRequest request){
        List<FamiliaEquipo> familias = familiaServices.familiaEquipos();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario u = new Usuario();
        u.setUsername(user);
        if(user.equals("anonymousUser"))
            u.setUsername(" ");
        model.addAttribute("usuario",u);
        model.addAttribute("familia", new FamiliaEquipo());
        model.addAttribute("familias",familias);

        return "/familias";
    }

    @RequestMapping("/subFamilia")
    public String listarSubFamilias(@RequestParam("id") int id,Model model, HttpServletRequest request){
        FamiliaEquipo fa = familiaServices.familiaID(id);

        List<SubFamiliaEquipo> familias = subFamiliaServices.subFamiliasFamilia(fa);
        String user =SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario u = new Usuario();
        u.setUsername(user);
        if(user.equals("anonymousUser"))
            u.setUsername(" ");
        model.addAttribute("usuario",u);
        model.addAttribute("familia", fa);
        model.addAttribute("subFamilia", new SubFamiliaEquipo());
        model.addAttribute("subFamilias",familias);
        return "/subFamilias";
    }

    @PostMapping("/crearSubFamilia")
    @Transactional
    public String nuevaSubFamilia(@ModelAttribute SubFamiliaEquipo subFamiliaEquipo, Model model ){
        FamiliaEquipo fa = familiaServices.familiaID(subFamiliaEquipo.getfID());
        subFamiliaEquipo.setFamiliaEquipo(fa);
        subFamiliaServices.creacionSubFamilia(subFamiliaEquipo);

        List<SubFamiliaEquipo> familias = subFamiliaServices.subFamiliasFamilia(fa);
        String user =SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario u = new Usuario();
        u.setUsername(user);
        if(user.equals("anonymousUser"))
            u.setUsername(" ");
        model.addAttribute("usuario",u);
        model.addAttribute("familia", fa);
        model.addAttribute("subFamilia", new SubFamiliaEquipo());
        model.addAttribute("subFamilias",familias);
        return "/subFamilias";
    }




    @PostMapping("/crearFamilia")
    @Transactional
    public String nuevaFamilia(@ModelAttribute FamiliaEquipo familiaEquipo, Model model) {
        System.out.println("Nombre: "+familiaEquipo.getNombre());
        familiaServices.creacionFamilia(familiaEquipo);
        List<FamiliaEquipo> familias = familiaServices.familiaEquipos();
        String user =SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario u = new Usuario();
        u.setUsername(user);
        if(user.equals("anonymousUser"))
            u.setUsername(" ");
        model.addAttribute("usuario",u);
        model.addAttribute("familia", new FamiliaEquipo());
        model.addAttribute("familias",familias);
        return "familias";
    }





}
