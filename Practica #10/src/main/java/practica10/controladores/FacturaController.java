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
import practica10.repositorios.FacturaRepository;
import practica10.servicios.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @RequestMapping("/")
    public String actual(@RequestParam("id") int id,Model model, HttpServletRequest request){
        Factura factura = facturaServices.facturaID(id);
            ArrayList<Alquiler> alquiler = new ArrayList<>();
            for(int i=0; i < factura.getEquiposAlquilados().size();i++){
                if(!factura.getEquiposAlquilados().get(i).isDevuelto())
                    alquiler.add(factura.getEquiposAlquilados().get(i));
            }
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario u = new Usuario();
        u.setUsername(user);
        if(user.equals("anonymousUser"))
            u.setUsername(" ");
        model.addAttribute("usuario",u);
            model.addAttribute("factura",factura);
            model.addAttribute("alquiler",alquiler);
            model.addAttribute("fecha",new Date());
            return "/facturaD";

    }

    @RequestMapping("/facturas")
    public String listarUsuarios(Model model, HttpServletRequest request){
        List<Factura> facturas = facturaServices.facturas();
        ArrayList<Factura> facturasA = new ArrayList<>();
        ArrayList<Factura> facturasP = new ArrayList<>();
        for (int i=0; i < facturas.size();i++){
            if(facturas.get(i).isActiva()){
                facturasA.add(facturas.get(i));
            }
            else{
                facturasP.add(facturas.get(i));
            }
        }
        String user =SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario u = new Usuario();
        u.setUsername(user);
        if(user.equals("anonymousUser"))
            u.setUsername(" ");
        model.addAttribute("usuario",u);
        model.addAttribute("facturasA",facturasA);
        model.addAttribute("facturasP",facturasP);
        return "/facturas";
    }

    @RequestMapping("/devolver")
    public String facturar(@RequestParam("id") int id, @RequestParam("fid") int fid,@RequestParam("fecha") String fechaS, Model model){
        String user =SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario u = new Usuario();
        u.setUsername(user);
        if(user.equals("anonymousUser"))
            u.setUsername(" ");
        System.out.println("STRING"+fechaS);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = format.parse(fechaS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        float total=0;
        Factura factura = facturaServices.facturaID(fid);
        long diff = fecha.getTime()-factura.getFecha().getTime();
        int dias =  (int)TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)+1;

        if(id==0){
            for (int i=0; i < factura.getEquiposAlquilados().size();i++){
                if(!factura.getEquiposAlquilados().get(i).isDevuelto())
                    total+=factura.getEquiposAlquilados().get(i).getEquipo().getCobroDia()*dias;
            }
            model.addAttribute("cantidad",factura.getEquiposAlquilados().size());
            if(factura.getEquiposAlquilados().size()>1) {
                model.addAttribute("alquiler", new Alquiler());
                model.addAttribute("usuario", u);
            }
            else {
                model.addAttribute("usuario", u);
                model.addAttribute("alquiler", factura.getEquiposAlquilados().get(0));
            }
        }
        else{
            Alquiler alquiler = alquilerServices.alquilerID(id);
            if(!alquiler.isDevuelto())
                total += alquiler.getEquipo().getCobroDia()*dias;
            model.addAttribute("usuario",u);
            model.addAttribute("alquiler",alquiler);
            model.addAttribute("cantidad",1);
        }
        model.addAttribute("usuario",u);
        model.addAttribute("total",total);
        model.addAttribute("factura",factura);
        return "/devoluciones";
    }

    @PostMapping("/facturar")
    @Transactional
    public String facturar(@RequestParam int id){
        Factura factura = facturaServices.facturaID(id);
        for(int i=0; i < factura.getEquiposAlquilados().size();i++){
            Alquiler alquiler = factura.getEquiposAlquilados().get(i);
            alquiler.getEquipo().setCantidad(alquiler.getEquipo().getCantidad()-1);
            equipoServices.creacionEquipo(alquiler.getEquipo());
        }
        factura.setActiva(true);
        factura.setFacturada(true);
        factura.setFecha(new Date());

        return "redirect:/";
    }

    @PostMapping("/devolver")
    @Transactional
    public String devolverEquipo(@RequestParam int id){
        Alquiler alquiler= alquilerServices.alquilerID(id);
        alquiler.setDevuelto(true);
        Equipo equipo = alquiler.getEquipo();
        equipo.setCantidad(equipo.getCantidad()+1);
        equipoServices.creacionEquipo(equipo);
        alquilerServices.creacionAlquiler(alquiler);
        if(alquiler.getFactura().isVacia()){
            System.out.println("WEYYY");
            alquiler.getFactura().setActiva(false);
            facturaServices.creacionFactura(alquiler.getFactura());
        }
        return "redirect:/";
    }

    @PostMapping("/devolverM")
    @Transactional
    public String devolverMuchos(@RequestParam int id){
        Factura factura = facturaServices.facturaID(id);
        for(int i=0; i< factura.getEquiposAlquilados().size();i++){
            Alquiler alquiler = factura.getEquiposAlquilados().get(i);
            alquiler.setDevuelto(true);
            Equipo equipo = alquiler.getEquipo();
            equipo.setCantidad(equipo.getCantidad()+1);
            equipoServices.creacionEquipo(equipo);
            alquilerServices.creacionAlquiler(alquiler);
        }
        factura.setActiva(false);
        facturaServices.creacionFactura(factura);
        return "redirect:/";
    }





}
