package com.grosshaeuser.ai_panel.ui.user;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "user", layout = UserLayout.class)
@PageTitle("User Dashboard")
@RolesAllowed("ROLE_USER")
public class UserDashboard extends VerticalLayout {
    public UserDashboard() {
        add(new H1("User Dashboard"));
    }
}
