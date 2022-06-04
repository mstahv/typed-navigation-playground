package org.example;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.History;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Location;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.QueryParameters;
import com.vaadin.flow.router.Route;

@Route
public class AnotherView extends VerticalLayout implements HasUrlParameter<String> {

    private Location location;

    public AnotherView() {
        add(new H1("AnotherView"));
    }

    /**
     * This method is well documented and Java compiler checks
     * we are using it properly.
     *
     * @param thing object
     */
    public void doStuffWith(ComplexThing thing) {
        add(new Paragraph(thing.toString()));
        updateQueryParameters(thing);
    }

    /**
     * Makes sure the URL parameters are up-to-date, in case
     * somebody shares a link to their colleague.
     * Basically we encode the ComplexThing into url parameters.
     * In a more realistic use case, we would probably use entity id or similar.
     * @param o o
     */
    private void updateQueryParameters(ComplexThing o) {
        History history = getUI().get().getPage().getHistory();
        history.replaceState(null , location.getPath() + "?string=" + o.getString() + "&integer=" + o.getInteger());
        // a JS haxie solution, don't need to save the location in navigation, might be more stable...
        // getElement().executeJs("setTimeout(() => {window.history.replaceState(null, '', window.location.pathname + '?string=" + o.getString() + "&integer=" + o.getInteger() + "')},0);");
    }

    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
        try {
            // If there are proper parameters when navigating to the page, doStuffWith(things);
            // This is the reverse operation of updateQueryParameters method
            location = event.getLocation();
            QueryParameters queryParameters = location.getQueryParameters();
            String string = queryParameters.getParameters().get("string").get(0);
            int integer = Integer.parseInt(queryParameters.getParameters().get("integer").get(0));
            doStuffWith(new ComplexThing(string,integer));
        } catch (Exception e) {
            // Ignore, there was just no valid parameters when navigating to page
        }
    }
}
