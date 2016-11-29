package com.ProgWebA.vistas;

import com.ProgWebA.entidades.Usuario;
import com.ProgWebA.servicios.UsuarioServices;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Locale;

/**
 * Created by vacax on 11/10/16.
 */
@SpringUI(path = "/")
@Theme("valo")
public class MainUI extends UI {

    private Grid grid = new Grid();
    private TextField filterText = new TextField();


    @Autowired
    private UsuarioServices usuarioServices;

    @Override
    protected void init(VaadinRequest request) {

        UI.getCurrent().setLocale(new Locale("en"));

        VerticalLayout layout = new VerticalLayout(); //creando el layout que estaremos trabajando.


        //bloque
        /*filterText.setInputPrompt("Filtrado Por Nombre");
        filterText.addTextChangeListener(new FieldEvents.TextChangeListener() {
            @Override
            void textChange(FieldEvents.TextChangeEvent e) {
                grid.setContainerDataSource(new BeanItemContainer<>(Estudiante.class, estudianteService.listarTodosEstudiantesPorNombre(e.getText())));
            }
        })*/


        /*Button clearFilterTextBtn = new Button(FontAwesome.TIMES);
        clearFilterTextBtn.setDescription("Limpiar");
        clearFilterTextBtn.addClickListener(new Button.ClickListener() {
            @Override
            void buttonClick(Button.ClickEvent e) {
                filterText.clear();
                updateList();
            }
        })*/


        CssLayout filtering = new CssLayout();
        //filtering.addComponents(filterText, clearFilterTextBtn);
        filtering.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);





        /*grid.addSelectionListener(new SelectionEvent.SelectionListener() {
            @Override
            void select(SelectionEvent event) {
                if (event.getSelected().isEmpty()) {
                    form.setVisible(false);
                } else {
                    Estudiante customer = (Estudiante) event.getSelected().iterator().next();
                    form.setEstudiante(customer);
                }
            }
        })*/

    }

    /*public void updateList() {
        List<Estudiante> customers = estudianteService.listarTodosEstudiantesPorNombre(filterText.getValue());
        grid.setContainerDataSource(new BeanItemContainer<>(Estudiante.class, customers));
    }*/
}
