package com.ericlam.mc.eldtester;

import org.bukkit.entity.Player;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class I18nServiceImpl implements I18nService{

    private final Map<UUID, String> languageMap = new HashMap<>(); // 語言儲存資料庫，你應實作離線儲存

    @Inject
    private Map<String, TesterMultiLang> multiLangMap;

    // 根據玩家的語言發送訊息
    @Override
    public void sendMessage(Player player, String path) {
        String lang = languageMap.getOrDefault(player.getUniqueId(), "en-us");
        TesterMultiLang langConfig = multiLangMap.get(lang);
        if (langConfig == null){
            player.sendMessage("由於沒有你的語言 (".concat(lang).concat("), 因此使用回默認語言 en-us"));
            langConfig = multiLangMap.get("en-us");
        }
        player.sendMessage(langConfig.getLang().get(path)); // 發送玩家所使用的語言的訊息
    }

    // 切換語言
    @Override
    public void switchLanguage(Player player, String lang) {
        languageMap.put(player.getUniqueId(), lang);
    }
}
