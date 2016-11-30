package com.ProgWebA.servicios;

import com.ProgWebA.entidades.Evento;
import com.ProgWebA.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by rony- on 11/27/2016.
 */
@Component
public class EmailServices {

    @Autowired
    EventoServices eventoServices;

    @Autowired
    UsuarioServices usuarioServices;

    @Autowired
    private MailSender mailSender;


    @Scheduled(fixedRate = 10000)
    public void notificaciones(){
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        int minutos = 5;
        cal.add(GregorianCalendar.MINUTE, minutos);
        List<Evento> eventos = eventoServices.eventos();
        for(Evento evento: eventos){
            long diff = cal.getTime().getTime() - evento.getFechaInicio().getTime();
            if(diff > 0 && !evento.isNotificacionEnviada()){
                Usuario u = usuarioServices.user("admin");
                String correo="palomoUnDosTres@gmail.com";
                String mensaje="Evento: "+evento.getTitulo()+" estara pasando en: "+evento.getFechaInicio();
                sendMail(correo,u.getCorreo(),evento.getDescripcion(),mensaje);
                evento.setNotificacionEnviada(true);
                eventoServices.creacionEvento(evento);
            }
        }
    }
    public void sendMail(String from, String to, String subject, String msg) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(msg);
        mailSender.send(message);
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }
}
