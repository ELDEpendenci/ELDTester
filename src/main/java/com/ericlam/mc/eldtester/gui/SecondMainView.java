package com.ericlam.mc.eldtester.gui;

import com.ericlam.mc.eldgui.component.factory.ButtonFactory;
import com.ericlam.mc.eldgui.view.UIContext;
import com.ericlam.mc.eldgui.view.View;
import com.ericlam.mc.eldgui.view.ViewDescriptor;
import org.bukkit.Material;

@ViewDescriptor(
        name = "Second View",
        rows = 1,
        patterns = "ZZZZAZZZZ"
)
public class SecondMainView implements View<Void> { //指定 void 類型表示 不需要 數據模型

    @Override
    public void renderView(Void model, UIContext context) {
        ButtonFactory button = context.factory(ButtonFactory.class);
        context.pattern('A')
                .components(
                        button.icon(Material.IRON_AXE)
                                .title("&aYou have successfully jumped to this page!")
                                .create()
                );
    }

}
