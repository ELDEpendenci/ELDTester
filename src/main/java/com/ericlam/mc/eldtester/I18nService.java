package com.ericlam.mc.eldtester;

import org.bukkit.entity.Player;

public interface I18nService {

    void sendMessage(Player player, String path);

    void switchLanguage(Player player, String lang);

}
