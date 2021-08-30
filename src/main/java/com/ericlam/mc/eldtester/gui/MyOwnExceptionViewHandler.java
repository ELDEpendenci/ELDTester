package com.ericlam.mc.eldtester.gui;

import com.ericlam.mc.eldgui.UISession;
import com.ericlam.mc.eldgui.exception.ExceptionViewHandler;
import com.ericlam.mc.eldgui.exception.HandleForControllers;
import com.ericlam.mc.eldgui.view.BukkitRedirectView;
import com.ericlam.mc.eldgui.view.BukkitView;
import org.bukkit.entity.Player;

@HandleForControllers(MainController.class)
public class MyOwnExceptionViewHandler implements ExceptionViewHandler {

    @Override
    public BukkitView<?, ?> createErrorView(Exception e, String s, UISession uiSession, Player player) {
        uiSession.setAttribute("error", e);
        uiSession.setAttribute("from", s);
        return new BukkitRedirectView("error");
    }
}
