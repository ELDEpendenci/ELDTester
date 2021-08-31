package com.ericlam.mc.eldtester.gui;

import com.ericlam.mc.eldgui.component.factory.ButtonFactory;
import com.ericlam.mc.eldgui.view.UIContext;
import com.ericlam.mc.eldgui.view.UseTemplate;
import com.ericlam.mc.eldgui.view.View;
import com.ericlam.mc.eldgui.view.ViewDescriptor;
import org.bukkit.Material;


@UseTemplate(
        template = "main",
        groupResource = GUITemplate.class
)
public class MainView implements View<String> {

    @Override
    public void renderView(String s, UIContext context) {
        ButtonFactory button = context.factory(ButtonFactory.class);
        context.pattern('A')
                .components(
                        button.icon(Material.DIAMOND_BLOCK)
                                .title(s)
                                .bind("say", "Have a nice day!") // 綁定屬性 say 為數值 "Have a nice day!"
                                .create()
                );
    }
}
