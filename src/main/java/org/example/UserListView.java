package org.example;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.Arrays;
import java.util.List;

@Route
public class UserListView extends VerticalLayout {

    List<User> userList = Arrays.asList(new User("User 1",1), new User("User 2", 2));

    public UserListView() {

        UI ui = UI.getCurrent();

        userList.forEach(user -> {
            add(new HorizontalLayout(
                    new Paragraph("Customer " + user.getId() + " " + user.getName()),
new Button("Edit " + user.getName(), event -> {
    ui.navigate(UserEditor.class)
            .ifPresent(editor -> editor.editUser(user));
})
            ));

        });
    }
}
