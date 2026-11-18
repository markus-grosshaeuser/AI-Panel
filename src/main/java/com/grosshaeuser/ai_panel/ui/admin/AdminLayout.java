package com.grosshaeuser.ai_panel.ui.admin;

import com.vaadin.flow.component.applayout.AppLayout;
import jakarta.annotation.security.RolesAllowed;

@RolesAllowed("ROLE_ADMIN")
public class AdminLayout extends AppLayout {
    public AdminLayout() {

    }
}
