package com.ericlam.mc.eldtester;

import com.ericlam.mc.eld.ELDependenci;
import com.ericlam.mc.eld.annotations.ELDPlugin;
import com.ericlam.mc.eld.exceptions.ArgumentParseException;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

@ELDPlugin(registry = TesterRegistry.class)
public class ELDTester extends JavaPlugin {

    public static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        var provider = ELDependenci.getApi().register(this, service -> {
            service.addConfiguration(TestConfig.class);
            service.addService(MyService.class, MyServiceImpl.class);
        });
        var parser = provider.getArgumentManager();

        parser.registerParser(String.class, (iterator, commandSender) -> iterator.next());

        parser.registerParser(StringList.class, (iterator, commandSender) -> {
            var list = new StringList();
            iterator.forEachRemaining(list::add);
            return list;
        });
        parser.registerParser(String.class, "message", (iterator, commandSender) -> {
            var builder = new StringBuilder();
            iterator.forEachRemaining(s -> builder.append(s).append(" "));
            return builder.toString();
        });

        parser.registerParser(Integer.class, (iterator, commandSender) -> {
            try{
                return Integer.parseInt(iterator.next());
            }catch (NumberFormatException e){
                throw new ArgumentParseException(e.getMessage());
            }
        });

        parser.registerParser(Player.class, ((iterator, commandSender) -> {
            var player = Bukkit.getPlayer(iterator.next());
            if (!player.isOnline()){
                throw new ArgumentParseException("玩家未上線");
            }else{
                return player;
            }
        }));
        var config = provider.getConfigStorage().getConfigAs(TestConfig.class);
        System.out.println("onEnable: " + config.toString());
    }

    public static class StringList extends ArrayList<String> {
    }
}
