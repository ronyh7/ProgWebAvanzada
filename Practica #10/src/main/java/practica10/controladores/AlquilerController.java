package practica10.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import practica10.entidades.*;
import practica10.servicios.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by rony- on 10/25/2016.
 */
@Controller
@RequestMapping("/alquiler")
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


    @RequestMapping("")
    public String getIndexPage(Model model, HttpServletRequest request) {
        List<Equipo> equipos = equipoServices.equipos();

        model.addAttribute("equipos",equipos);
        model.addAttribute("alquiler", new Alquiler());

        return "/indice";
    }

    @PostMapping ("/agregar")
    @Transactional
    public String addAlquiler(@RequestParam("equipo") int id,Model model, HttpServletRequest request) {
        Usuario u = (Usuario) request.getSession().getAttribute("usuario");
        Equipo equipo = equipoServices.equipoByID(id);
        Alquiler alquiler = new Alquiler();
        alquiler.setEquipo(equipo);
        alquiler.setDevuelto(false);
        Factura factura = new Factura();

        if(request.getSession().getAttribute("factura")==null) {
            factura.setCheckedOut(false);
            factura.setCliente(u);
            facturaServices.creacionFactura(factura);
        }
        else{
            factura = (Factura)request.getSession().getAttribute("factura");
        }
        alquiler.setFactura(factura);
        alquilerServices.creacionAlquiler(alquiler);
        List<Equipo> equipos = equipoServices.equipos();

        model.addAttribute("equipos",equipos);
        model.addAttribute("alquiler",alquiler);

        return "/indice";
    }






}
