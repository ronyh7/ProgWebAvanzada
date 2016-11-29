package practica10.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practica10.entidades.Equipo;
import practica10.servicios.AlquilerServices;
import practica10.servicios.EquipoServices;
import practica10.servicios.FamiliaServices;
import practica10.servicios.SubFamiliaServices;

import java.util.List;

/**
 * Clase que representa un controlador para trabajar con el API REST.
 * Created by vacax on 20/09/16.
 */
@ResponseBody
@RestController
public class RestApiController {

    //Inyección de dependecia.
    @Autowired
    private SubFamiliaServices subFamiliaServices;

    @Autowired
    private FamiliaServices familiaServices;


    @Autowired
    private EquipoServices equipoService;

    @Autowired
    private AlquilerServices alquilerServices;


    @RequestMapping(value ="/sub_familias/",method = RequestMethod.GET, produces = "application/json")
    public List<Object> getSubfamilias(){
        return alquilerServices.subFamiliasAlquiladas();
    }

    @RequestMapping(value ="/familias/",method = RequestMethod.GET, produces = "application/json")
    public List<Object> getFamilias(){
        return alquilerServices.familiasAlquiladas();
    }

    /*@RequestMapping(value ="/validar_existencia",method = RequestMethod.GET, produces = "application/json")
    public String validarExistencia(@RequestParam("id") int equipo_id){
        Equipo equipo = equipoService.getEquipo(equipo_id);
        MensajeValidador mensajeValidador = new MensajeValidador();
        if(equipo.getCantidad() <= 0){
            mensajeValidador.setValido(false);
            mensajeValidador.setMensaje("Este equipo no esta disponible.");
        }
        else {
            mensajeValidador.setValido(true);
            mensajeValidador.setMensaje("exito");
        }
        Gson gson = new Gson();
        String result = gson.toJson(mensajeValidador);
        return result;
    }*/
}
