package com.ericlam.mc.eldtester;

import com.ericlam.mc.eld.annotations.InjectPool;
import com.ericlam.mc.eld.configurations.GroupLang;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class I18nServiceImpl implements I18nService {

    private final Map<UUID, String> languageMap = new HashMap<>(); // 語言儲存資料庫，你應實作離線儲存

    @InjectPool
    private GroupLang<TesterMultiLang> languagePool;

    // 根據玩家的語言發送訊息
    @Override
    public void sendMessage(Player player, String path) {
        String lang = languageMap.getOrDefault(player.getUniqueId(), "en-us");
        var langConfig = languagePool.getByLocale(lang).orElseGet(() -> {
            player.sendMessage("由於沒有你的語言 (".concat(lang).concat("), 因此使用回默認語言 en-us"));
            return languagePool.getDefault();
        }); // 發送玩家所使用的語言的訊息, 若無則自動返回默認語言文件
        player.sendMessage(langConfig.getLang().get(path));
    }

    // 切換語言
    @Override
    public void switchLanguage(Player player, String lang) {
        languageMap.put(player.getUniqueId(), lang);
    }
}
