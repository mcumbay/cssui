package com.hcsc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.hcsc.cssui.model.Liability;
import com.hcsc.cssui.model.type.CorporateEntityCode;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener( e -> {
            layout.addComponent(new Label("Thanks " + name.getValue() 
                    + ", it works!"));
        });
        
        layout.addComponents(name, button);
        
        List<Liability> liabilityList = new ArrayList<>();
        for(long i=0;i<50;i++){
        	Liability liability = new Liability();
        	liability.setId(i);
        	liability.setCorpEntCd(CorporateEntityCode.Texas);
        	liability.setHcscSubscriber("0000000"+i);
        	liability.setQhpid("76002"+i+"TX1");
        	liability.setAmount(new Double(i));
        	liabilityList.add(liability);
        }
        
        Grid<Liability> grid = new Grid<>();
        grid.setItems(liabilityList);
        grid.addColumn(Liability::getId).setCaption("Claim Id");
        grid.addColumn(Liability::getCorpEntCd).setCaption("Corp Ent Cd");
        grid.addColumn(Liability::getHcscSubscriber).setCaption("Hcsc Sub.");
        grid.addColumn(Liability::getQhpid).setCaption("Qhpid");
        grid.addColumn(Liability::getAmount).setCaption("Amount");
        
        layout.addComponent(grid);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
