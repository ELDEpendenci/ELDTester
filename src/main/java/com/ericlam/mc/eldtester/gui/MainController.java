package com.ericlam.mc.eldtester.gui;

import com.ericlam.mc.eldgui.controller.UIController;
import com.ericlam.mc.eldgui.event.ClickMapping;
import com.ericlam.mc.eldgui.view.BukkitView;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;


@UIController("main")
public class MainController {

    public BukkitView<?, ?> index(Player player) {
        String greeting = "hello, " + player.getName() + "!"; // 將顯示玩家的名稱
        return new BukkitView<>(MainView.class, greeting);
    }

    @MyOwnFilter(type = ClickType.MIDDLE) // 中鍵點擊才會被觸發
    @ClickMapping(pattern = 'A', view = MainView.class)
    public void onClickA(Player player) {
        player.sendMessage("activated !!!!");
    }

}
