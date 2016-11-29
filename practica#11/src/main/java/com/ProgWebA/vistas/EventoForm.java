package com.ProgWebA.vistas;

import com.ProgWebA.entidades.Evento;
import com.ProgWebA.servicios.EventoServices;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Component;

import java.util.GregorianCalendar;

/**
 * Created by rony- on 11/27/2016.
 */
@Component
@UIScope
public class EventoForm extends FormLayout {
    @Autowired
    private EventoServices service;

    private TextField titulo=new TextField("Titulo");
    private TextField descripcion=new TextField("Descripcion");
    private DateField fechaInicio=new DateField("Hora y fecha");
    private DateField fechaFin = new DateField("Hora y fecha que termina");


    private Button guardar = new Button("Guardar");
    private Calendario calendarioUI;
    private Label validacion = new Label("HAY EMPALME EN ESA FECHA");

    public EventoForm(){
        fechaInicio.setResolution(Resolution.MINUTE);
        fechaFin.setResolution(Resolution.MINUTE);
        validacion.setVisible(false);

        addComponents(titulo,descripcion,fechaInicio,fechaFin,validacion,guardar);

        guardar.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                Evento evento = new Evento();
                evento.setTitulo(titulo.getValue());
                evento.setDescripcion(descripcion.getValue());
                evento.setFechaInicio(fechaInicio.getValue());
                evento.setFechaFin(fechaFin.getValue());
                evento.setNotificacionEnviada(false);
                if(validar(evento)){
                    service.creacionEvento(evento);
                    validacion.setVisible(false);
                    calendarioUI.beanItemContainer.addBean(evento);
                }
                else{
                    validacion.setVisible(true);
                }

            }
        });
    }

    public void setCalendarioUI(Calendario calendarioUI) {
        this.calendarioUI = calendarioUI;
    }


    private boolean validar(Evento evento){
        for(Evento e: service.eventos() ){
            DateTime start1 = new DateTime(evento.getFechaInicio());
            DateTime end1 = new DateTime(evento.getFechaFin());
            DateTime start2 =  new DateTime(e.getFechaInicio());
            DateTime end2 = new DateTime(e.getFechaFin());
            Interval interval = new Interval( start1, end1 );
            Interval interval2 = new Interval( start2, end2 );
            if(interval.overlaps(interval2))
                return  false;
        }
        return true;
    }

}
