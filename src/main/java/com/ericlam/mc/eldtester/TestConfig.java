package com.ericlam.mc.eldtester;

import com.ericlam.mc.eld.annotations.Resource;
import com.ericlam.mc.eld.components.Configuration;
import org.bukkit.ChatColor;

@Resource(locate = "config.yml")
public class TestConfig extends Configuration {
    public boolean useMySQL;
    public String host;
}
