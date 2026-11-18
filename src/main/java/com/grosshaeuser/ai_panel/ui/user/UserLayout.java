package com.grosshaeuser.ai_panel.ui.user;

import com.vaadin.flow.component.applayout.AppLayout;
import jakarta.annotation.security.RolesAllowed;

@RolesAllowed("ROLE_USER")
public class UserLayout extends AppLayout {
    public UserLayout() {

    }
}
