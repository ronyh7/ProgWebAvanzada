import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rony- on 9/15/2016.
 */
@ManagedBean(name = "contacto")
@SessionScoped
public class ContactoBean implements Serializable{
    private long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String adress;
    public long idt=1;
    private boolean update=false;
    private ArrayList<Contacto> contactos= new ArrayList<Contacto>(Arrays.asList(new Contacto("r","h","4","@","sti",idt)));
//
    public String update(Contacto contacto, long id){
        for(int i=0; i<getContactos().size();i++) {
            if(getContactos().get(i).getId()==id) {
                getContactos().get(i).setFirstName(contacto.getFirstName());
                getContactos().get(i).setLastName(contacto.getLastName());
                getContactos().get(i).setPhone(contacto.getPhone());
                getContactos().get(i).setEmail(contacto.getEmail());
                getContactos().get(i).setAdress(contacto.getAdress());
                break;
            }
        }
        update=false;
        return null;
    }
    public String delete(Contacto contacto){
        getContactos().remove(contacto);
        return null;
    }
    public String text(Contacto contacto){
        setFirstName(contacto.getFirstName());
        setLastName(contacto.getLastName());
        setAdress(contacto.getAdress());
        setPhone(contacto.getPhone());
        setEmail(contacto.getEmail());
        setId(contacto.getId());
        update=true;
        return null;
    }

    public String add(String firstName, String lastName, String phone, String email, String adress){



        if(!update) {
            idt++;
            Contacto contacto = new Contacto(firstName,lastName,phone,email,adress,idt);
            getContactos().add(contacto);

        }
        else{
            Contacto contacto = new Contacto(firstName,lastName,phone,email,adress,getId());
            update(contacto,getId());

        }
        setFirstName("");
        setLastName("");
        setAdress("");
        setPhone("");
        setEmail("");
        setId(0);
        return null;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
