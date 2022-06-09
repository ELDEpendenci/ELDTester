package com.ericlam.mc.eldtester.gui;

import com.ericlam.mc.eldgui.controller.MapAttribute;
import com.ericlam.mc.eldgui.controller.UIController;
import com.ericlam.mc.eldgui.event.ClickMapping;
import com.ericlam.mc.eldgui.lifecycle.PostUpdateView;
import com.ericlam.mc.eldgui.lifecycle.PreDestroyView;
import com.ericlam.mc.eldgui.view.BukkitView;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

import java.util.Map;


@UIController("main")
@HasPermission("gui.main")
public class MainController {

    @HasPermission("gui.main.index")
    public BukkitView<?, ?> index(Player player) {
        String greeting = "hello, " + player.getName() + "!"; // 將顯示玩家的名稱
        return new BukkitView<>(MainView.class, greeting);
    }


    @HasPermission("gui.main.submit")
    @ClickMapping(pattern = 'B', view = MainView.class)
    public void onSubmit(Player player, @MapAttribute('A') Map<String, Object> map) {
        var passwordHashed = (String) map.get("password");
        player.sendMessage(passwordHashed == null ? "null" : passwordHashed);
    }


    @PreDestroyView(MainView.class)
    public void onDestroyView(Player player){
        player.sendMessage("pre destroy view for main view");
    }

    @PostUpdateView(MainView.class)
    public void postUpdateView(Player player){
        player.sendMessage("updated to main view");
    }

}
