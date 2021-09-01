package com.ericlam.mc.eldtester.gui;

import com.ericlam.mc.eldgui.component.factory.ButtonFactory;
import com.ericlam.mc.eldgui.component.factory.NumInputFactory;
import com.ericlam.mc.eldgui.view.UIContext;
import com.ericlam.mc.eldgui.view.UseTemplate;
import com.ericlam.mc.eldgui.view.View;
import com.ericlam.mc.eldgui.view.ViewDescriptor;
import org.bukkit.Material;


@UseTemplate(
        template = "main",
        groupResource = GUITemplate.class
)
public class MainView implements View<String> { // 此界面裝載 String 作為數據

    @Override
    public void renderView(String s, UIContext context) {
        ButtonFactory button = context.factory(ButtonFactory.class); //獲取 按鈕組件工廠
        NumInputFactory numInput = context.factory(NumInputFactory.class);
        context.pattern('A') // 指定 Pattern A
                .components( // 放入組件
                        numInput.icon(Material.DIAMOND_BLOCK) // 設置鑽石方塊
                                .label(s) // 設置顯示
                                .useNumberType(Double.class)
                                .then()
                                .create() // 創建組件
                );
    }
}
