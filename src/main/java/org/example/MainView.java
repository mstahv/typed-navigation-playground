package org.example;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * The main view contains a button and a click listener.
 */
@Route
public class MainView extends VerticalLayout {

    ComplexThing thing = new ComplexThing("Thing", 69);

    public MainView() {
        add(new H1("MainView"));
        Button button = new Button("Click me", e -> {
                UI.getCurrent().navigateTo(AnotherView.class)
                        // Navigate to returns the target view,
                        // now we can call its type-checked well documented Java API
                        .doStuffWith(thing);

                /*
                 * If the Java API wouldn't be available,
                 * we'd need to communicate with the "next view" using
                 * url/path parameters. In addition to being clumsy compared to
                 * using proper Java API, this would leak its responsibilities to
                 * this and probably also other classes. Now both encoded/decode
                 * is in the actual view (AnotherView.java)
                 */

                });
        add(button);
    }
}
