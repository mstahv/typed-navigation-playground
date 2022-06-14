package org.example;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteConfiguration;

@Route
public class UserEditor extends VerticalLayout implements HasUrlParameter<Integer> {

    /**
     * This method can be called directly by other views.
     *
     * @param user the User instance to edit
     */
    public void editUser(User user) {
        // do actual UI changes
        createFormForUser(user);
        // maintain a complete url in the browser
        updateQueryParameters(user);
    }

    private void updateQueryParameters(User o) {
        String deepLinkingUrl = RouteConfiguration.forSessionScope()
                .getUrl(getClass(), o.getId());
        // Assign the full deep linking URL directly using
        // History object: changes the URL in the browser,
        // but does not reload the page
        getUI().get().getPage().getHistory()
                .replaceState(null, deepLinkingUrl);

    }

    @Override // HasUrlParameter interface
    public void setParameter(BeforeEvent event,
                             @OptionalParameter Integer id) {
        if(id != null) {
            // This method is called if user arrives via "deep link"
            // directly to this form. In a real world app, one would
            // likely fetch an entity/DTO via service based on its id
            createFormForUser(new User("User " + id, id));
        }
    }

    private void createFormForUser(User user) {
        // just show the user ID as this is really not a form example
        add(new Paragraph("User: " + user.getId()) );
    }

}
