package practica10.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practica10.entidades.Equipo;
import practica10.entidades.SubFamiliaEquipo;
import practica10.servicios.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by rony- on 10/25/2016.
 */
@Controller
@RequestMapping("/factura")
public class FacturaController {

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
        List<Equipo> equipos = equipoServices.equipos();
        model.addAttribute("equipos",equipos);
        return "/equipos";
    }

    @RequestMapping("/crearEquipo")
    public String equipo(Model model, HttpServletRequest request) {
        model.addAttribute("equipo", new Equipo());
        model.addAttribute("familias", familiaServices.familiaEquipos());
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