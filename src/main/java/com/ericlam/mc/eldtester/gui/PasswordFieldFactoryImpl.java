package com.ericlam.mc.eldtester.gui;

import com.ericlam.mc.eld.services.ItemStackService;
import com.ericlam.mc.eldgui.component.AttributeController;
import com.ericlam.mc.eldgui.component.Component;
import com.ericlam.mc.eldgui.component.factory.AbstractComponentFactory;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.regex.Pattern;

public class PasswordFieldFactoryImpl extends AbstractComponentFactory<PasswordFieldFactory> implements PasswordFieldFactory {

    private static final Map<HashType, String> hashConvert = Map.of(
            HashType.MD5, "MD5",
            HashType.SHA_256, "SHA-256"
    );

    // 設置可變屬性
    private String showPasswordTxt;
    private String hidePasswordTxt;
    private String inputMessage;
    private String invalidMessage;
    private long maxWait;
    private Pattern regex;
    private HashType hashType;
    private boolean disabled;

    public PasswordFieldFactoryImpl(ItemStackService itemStackService, AttributeController attributeController) {
        super(itemStackService, attributeController);
    }

    // 在這裏設置默認數值
    @Override
    protected void defaultProperties() {
        this.showPasswordTxt = "&a顯示密碼";
        this.hidePasswordTxt = "&c隱藏密碼";
        this.inputMessage = "請在聊天欄輸入你的密碼。";
        this.invalidMessage = "無效的密碼格式。";
        this.maxWait = 200L;
        this.regex = Pattern.compile("\\d+"); // 僅限數字的密碼格式
        this.hashType = HashType.MD5;
        this.disabled = false;
    }

    @Override
    public Component build(ItemStackService.ItemFactory itemFactory) {
        return new PasswordField(
                attributeController,
                itemFactory,
                showPasswordTxt,
                hidePasswordTxt,
                inputMessage,
                invalidMessage,
                maxWait,
                regex,
                hashType,
                disabled
        );
    }

    @Override
    public PasswordFieldFactory bindInput(String field) {
        bind(AttributeController.FIELD_TAG, field);
        bind(AttributeController.VALUE_TAG, null); // 設置初始賦值為 null
        return this;
    }

    @Override
    public PasswordFieldFactory showPasswordTxt(String show) {
        this.showPasswordTxt = show;
        return this;
    }

    @Override
    public PasswordFieldFactory hidePasswordTxt(String hide) {
        this.hidePasswordTxt = hide;
        return this;
    }

    @Override
    public PasswordFieldFactory hashType(HashType type) {
        this.hashType = type;
        return this;
    }

    @Override
    public PasswordFieldFactory label(String label) {
        return editItemByFactory(f -> f.display(label)); // 調用 editItemByFactory 來更改物品的顯示
    }

    @Override
    public PasswordFieldFactory inputMessage(String input) {
        this.inputMessage = input;
        return this;
    }

    @Override
    public PasswordFieldFactory invalidMessage(String invalid) {
        this.invalidMessage = invalid;
        return this;
    }

    @Override
    public PasswordFieldFactory regex(String regex) {
        this.regex = Pattern.compile(regex);
        return this;
    }

    @Override
    public PasswordFieldFactory maxWait(long maxWait) {
        this.maxWait = maxWait;
        return this;
    }

    @Override
    public PasswordFieldFactory disabled() {
        this.disabled = true;
        return this;
    }

    // 定義 hash 方法
    static String hash(String plain, HashType type) {
        try {
            MessageDigest digest = MessageDigest.getInstance(hashConvert.get(type));
            byte[] hashed = digest.digest(plain.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hashed);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // 將 bytes 轉變為 hex string 的方法
    private static final byte[] HEX_ARRAY = "0123456789ABCDEF".getBytes(StandardCharsets.US_ASCII);

    private static String bytesToHex(byte[] bytes) {
        byte[] hexChars = new byte[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars, StandardCharsets.UTF_8);
    }
}
