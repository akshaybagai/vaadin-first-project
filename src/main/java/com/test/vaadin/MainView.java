package com.test.vaadin;

import com.test.vaadin.component.Anything;
import com.test.vaadin.component.PaperComponent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;


/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */
@Route
public class MainView extends VerticalLayout {

   public MainView() {

       TextArea textArea = new TextArea("Input text here... ");
       textArea.setMinLength(500);


       Button button = new Button("Add a new label");
       button.addClickListener(buttonClickEvent -> {
           add(new Label("New Label"));
       });

       PaperComponent paperComponent = new PaperComponent();

       Grid<Anything> anythingGrid = new Grid<>();
       anythingGrid.addColumn(Anything::getField1).setHeader("Field 1");
       anythingGrid.addColumn(Anything::getField2).setHeader("Field 2");
       anythingGrid.setItems(new Anything("f1", "f2"), new Anything("f3","f4"));

       add(button);
       add(textArea);
       add(paperComponent);
       add(anythingGrid);




   }





}
