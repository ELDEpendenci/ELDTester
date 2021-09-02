package com.ericlam.mc.eldtester.gui;

import com.ericlam.mc.eldgui.view.UIContext;
import com.ericlam.mc.eldgui.view.UseTemplate;
import com.ericlam.mc.eldgui.view.View;
import org.bukkit.Material;


@UseTemplate(
        template = "main",
        groupResource = GUITemplate.class
)
public class MainView implements View<String> { // 此界面裝載 String 作為數據

    @Override
    public void renderView(String s, UIContext context) {
        PasswordFieldFactory password = context.factory(PasswordFieldFactory.class); // 獲取工廠接口
        context.pattern('A') // 指定 Pattern A
                .components( // 放入組件
                        password
                                .icon(Material.PAPER)
                                .label("&e輸入密碼")
                                .bindInput("password")
                                .hashType(PasswordFieldFactory.HashType.SHA_256)
                                .create()
                );
    }
}
