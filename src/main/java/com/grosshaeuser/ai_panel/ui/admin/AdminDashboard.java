package com.grosshaeuser.ai_panel.ui.admin;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "admin", layout = AdminLayout.class)
@PageTitle("Admin Dashboard")
@RolesAllowed("ROLE_ADMIN")
public class AdminDashboard extends VerticalLayout {
    public AdminDashboard() {
        add(new H1("Admin Dashboard"));
    }
}
