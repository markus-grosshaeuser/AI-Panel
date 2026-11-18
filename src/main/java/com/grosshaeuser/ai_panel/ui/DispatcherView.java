
package com.grosshaeuser.ai_panel.ui;

import com.grosshaeuser.ai_panel.ui.admin.AdminDashboard;
import com.grosshaeuser.ai_panel.ui.user.UserDashboard;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Route("")
@PermitAll
public class DispatcherView extends VerticalLayout implements BeforeEnterObserver {

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null) {
            return;
        }

        boolean isAdmin = auth.getAuthorities().stream()
                .anyMatch(a -> {
                    String authority = a.getAuthority();
                    assert authority != null;
                    return authority.equals("ROLE_ADMIN");
                });

        if (isAdmin) {
            event.forwardTo(AdminDashboard.class);
        }

        boolean isUser = auth.getAuthorities().stream()
                .anyMatch(a -> {
                    String authority = a.getAuthority();
                    assert authority != null;
                    return authority.equals("ROLE_USER");
                });

        if (isUser) {
            event.forwardTo(UserDashboard.class);
        }
    }
}