package Beans;

import Domain.Producto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.HashMap;

/**
 * Created by rony- on 10/4/2016.
 */
@SessionScoped
@ManagedBean(name = "carroBean")
public class CarroBean {
    private HashMap<Producto,Integer> carro;

    public HashMap<Producto, Integer> getCarro() {
        return carro;
    }

    public void setCarro(HashMap<Producto, Integer> carro) {
        this.carro = carro;
    }
}
