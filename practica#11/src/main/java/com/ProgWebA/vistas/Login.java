package com.ProgWebA.vistas;

import com.ProgWebA.entidades.Usuario;
import com.ProgWebA.servicios.UsuarioServices;
import com.ProgWebA.vistas.MainUI;
import com.vaadin.annotations.Theme;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.TextField;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;


@SpringUI(path = "/login")
@Theme("valo")
public class Login extends UI{

    @Autowired
    private UsuarioServices usuarioService;
    @Override
    protected void init(VaadinRequest vaadinRequest){
        AbsoluteLayout absoluteLayout = new AbsoluteLayout();
        absoluteLayout.setWidth("2000px");
        absoluteLayout.setHeight("500px");
        TextField username=new TextField("Username");
        TextField password=new TextField("Password");
        TextField correo = new TextField("Correo");
        TextField nombre= new TextField("Nombre");
        Label nombreC = new Label("Si desea cambiar el nombre o correo utilizado en la sesion anterior, puede hacerlo ahora");
        correo.addValidator(new EmailValidator("debe ser un correo valido"));
        if(usuarioService.usuarios().size() <= 0){
            Usuario usuario = new Usuario();
            usuario.setUsername("admin");
            usuario.setPassword("admin");
            usuario.setCorreo("rony.hernandez.809@gmail.com");
            usuario.setNombre("Rony Hernandez");
            usuarioService.creacionUsuario(usuario);
        }
        Button save = new Button("Ingresar", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                Usuario usuario = usuarioService.user("admin");
                if(username.getValue().equals(usuario.getUsername()) && password.getValue().equals(usuario.getPassword())){
                    if(!correo.isEmpty())
                        usuario.setCorreo(correo.getValue());
                    if(!nombre.isEmpty())
                        usuario.setNombre(nombre.getValue());
                    usuarioService.creacionUsuario(usuario);
                    getCurrent().getSession().setAttribute("usuario",usuario);
                    getUI().getPage().setLocation("http://localhost:8080/indice");
                }
                else{
                    password.setValue("");

                }
            }
        });

        absoluteLayout.addComponent(username,"left: 600px; top: 150px;");
        absoluteLayout.addComponent(password,"left: 600px; top: 225px;");
        absoluteLayout.addComponent(nombreC,"left:600px; top:300px;");
        absoluteLayout.addComponent(nombre,"left:600px; top:350px;");
        absoluteLayout.addComponent(correo,"left: 600px; top: 425px;");
        absoluteLayout.addComponent(save,"left: 650px; top: 475px;");
        VerticalLayout vertical = new VerticalLayout();
        vertical.addComponent(absoluteLayout);
        setContent(absoluteLayout);

    }




}
