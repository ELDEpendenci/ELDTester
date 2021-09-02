package com.ericlam.mc.eldtester.gui;

import com.ericlam.mc.eld.services.ItemStackService;
import com.ericlam.mc.eldgui.component.AbstractComponent;
import com.ericlam.mc.eldgui.component.AttributeController;
import com.ericlam.mc.eldgui.component.modifier.Clickable;
import com.ericlam.mc.eldgui.component.modifier.Listenable;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.List;
import java.util.regex.Pattern;

public class PasswordField extends AbstractComponent implements Listenable<AsyncChatEvent>, Clickable {

    // 獲取剛才的屬性
    private final String showPasswordTxt;
    private final String hidePasswordTxt;
    private final String inputMessage;
    private final String invalidMessage;
    private final long maxWait;
    private final Pattern regex;
    private final PasswordFieldFactory.HashType hashType;
    private final boolean disabled;

    private String plainText; // 純文字密碼
    private boolean showTxt = false; // 切換顯示

    public PasswordField(
            AttributeController attributeController,
            ItemStackService.ItemFactory itemFactory,
            String showPasswordTxt,
            String hidePasswordTxt,
            String inputMessage,
            String invalidMessage,
            long maxWait,
            Pattern regex,
            PasswordFieldFactory.HashType hashType,
            boolean disabled
    ) {
        super(attributeController, itemFactory);
        this.showPasswordTxt = showPasswordTxt;
        this.hidePasswordTxt = hidePasswordTxt;
        this.inputMessage = inputMessage;
        this.invalidMessage = invalidMessage;
        this.maxWait = maxWait;
        this.regex = regex;
        this.hashType = hashType;
        this.disabled = disabled;

        this.plainText = attributeController.getAttribute(getItem(), AttributeController.VALUE_TAG);
        this.updateItem(); // 更新物品顯示
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        if (event.getClick() != ClickType.MIDDLE) return;
        this.showTxt = !showTxt;
        this.updateItem();  // 更新物品顯示
    }

    @Override
    public boolean isDisabled() {
        return disabled;
    }

    @Override
    public void onListen(Player player) {
        player.sendMessage(inputMessage);
    }

    @Override
    public long getMaxWaitingTime() {
        return maxWait;
    }

    @Override
    public void callBack(AsyncChatEvent event) {
        String message = ((TextComponent) event.message()).content();
        if (!regex.matcher(message).find()) {
            event.getPlayer().sendMessage(invalidMessage);
            return;
        }
        this.plainText = message;
        final String value = PasswordFieldFactoryImpl.hash(this.plainText, hashType);
        attributeController.setAttribute(getItem(), AttributeController.VALUE_TAG, value); // 設置密碼 hash 值
        updateItem();  // 更新物品顯示
    }

    @Override
    public Class<AsyncChatEvent> getEventClass() {
        return AsyncChatEvent.class;
    }

    @Override
    public boolean shouldActivate(InventoryClickEvent e) {
        return e.getClick() != ClickType.MIDDLE; // 非中鍵點擊才會觸發監聽輸入
    }


    private void updateItem() {
        // 如果 plainText 為 null, 則顯示 NONE
        // 如果 showTxt 為 true, 則顯示純文字密碼
        // 如果 showTxt 為 false, 則顯示 ****
        itemFactory.lore(List.of(
                "-> " + (plainText == null ? "NONE" : showTxt ? plainText : "*".repeat(plainText.length())),
                "&b中鍵以 "+ (showTxt ? hidePasswordTxt : showPasswordTxt) // 提示字眼
        ));
        this.updateInventory(); // 必須調用 updateInventory 以重新渲染組件顯示
    }
}
