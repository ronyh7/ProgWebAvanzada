package Domain;

import java.util.HashMap;

/**
 * Created by rony- on 9/27/2016.
 */
public class Carro {
   private HashMap<Long,Integer> productos;

   public Carro(){
      productos = new HashMap<>();
   }

   public HashMap<Long, Integer> getProductos() {
      return productos;
   }

   public void setProductos(HashMap<Long, Integer> productos) {
      this.productos = productos;
   }
}
