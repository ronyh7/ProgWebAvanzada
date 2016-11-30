package com.ProgWebA.vistas;


import com.ProgWebA.entidades.Evento;
import com.ProgWebA.entidades.Usuario;
import com.ProgWebA.servicios.EmailServices;
import com.ProgWebA.servicios.EventoServices;
import com.ProgWebA.servicios.UsuarioServices;
import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.UserError;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Locale;

/**
 * Created by vacax on 17/10/16.
 */
@SpringUI(path = "/indice")
@Theme("valo")
public class Calendario extends UI {

    protected Calendar calendario;

    @Autowired
    UsuarioServices usuarioServices;

    @Autowired
    EventoServices eventoServices;

    @Autowired
    private EventoForm form;

    @Autowired
    EmailServices email;

    BeanItemContainer beanItemContainer;


    @Override
    protected void init(VaadinRequest request) {

        Usuario usuario = (Usuario)getCurrent().getSession().getAttribute("usuario");
        if(usuario==null){
            getUI().getPage().setLocation("http://localhost:8080/login");
        }
        form.setCalendarioUI(this);
        calendario = new Calendar();
        calendario.setLocale(Locale.US);
        calendario.setFirstVisibleDayOfWeek(2);   //Lunes
        calendario.setLastVisibleDayOfWeek(6);   // Viernes
        calendario.setFirstVisibleHourOfDay(0); // 8 am
        calendario.setLastVisibleHourOfDay(24); // 5 pm
        calendario.setWidth("1215px");
        calendario.setHeight("720px");
        List<Evento> eventos = eventoServices.eventos();
        beanItemContainer = new BeanItemContainer<Evento>(Evento.class,eventos);
        calendario.setContainerDataSource(beanItemContainer, "titulo",
                "descripcion", "fechaInicio", "fechaFin","box");
        Button guardar = new Button("Guardar Calendario");

        guardar.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                for(int i=0; i < beanItemContainer.size();i++){
                    Evento e = (Evento)beanItemContainer.getIdByIndex(i);
                    eventoServices.creacionEvento(e);
                }
            }
        });


        VerticalLayout vl = new VerticalLayout();
        HorizontalLayout hl = new HorizontalLayout();
        hl.addComponent(calendario);
        hl.addComponent(guardar);
        vl.addComponent(hl);
        vl.addComponent(form);
        setContent(vl);
    }
}
