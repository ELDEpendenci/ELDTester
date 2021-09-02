package com.ericlam.mc.eldtester.gui;

import com.ericlam.mc.eldgui.component.ComponentFactory;

// 密碼輸入組件
public interface PasswordFieldFactory extends ComponentFactory<PasswordFieldFactory> { // 繼承 ComponentFactory

    // 綁定屬性。由於是密碼，所以沒有初始數值。
    PasswordFieldFactory bindInput(String field);

    // 顯示密碼文字
    PasswordFieldFactory showPasswordTxt(String show);

    // 隱藏密碼文字
    PasswordFieldFactory hidePasswordTxt(String hide);

    // 設置密碼混淆類型
    PasswordFieldFactory hashType(HashType type);

    // 設置標題顯示
    PasswordFieldFactory label(String label);

    // 設置輸入提示訊息
    PasswordFieldFactory inputMessage(String input);

    // 設置無效提示訊息
    PasswordFieldFactory invalidMessage(String invalid);

    // 設置 regex 來規限密碼格式
    PasswordFieldFactory regex(String regex);

    // 設置等待最大輸入時間
    PasswordFieldFactory maxWait(long maxWait);

    // 設置禁用組件
    PasswordFieldFactory disabled();

    // hash類型
    enum HashType {
        SHA_256, MD5
    }

}
