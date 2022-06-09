package com.ericlam.mc.eldtester.gui;

import com.ericlam.mc.eldgui.middleware.InterceptContext;
import com.ericlam.mc.eldgui.middleware.MiddleWare;

public class PermissionMiddleWare implements MiddleWare<HasPermission> {
    @Override
    public void intercept(InterceptContext interceptContext, HasPermission hasPermission) throws Exception {
        var permission = hasPermission.value();
        var player = interceptContext.getPlayer();
        if (player.hasPermission(permission)) return;
        throw new RuntimeException("no permission");
    }
}
