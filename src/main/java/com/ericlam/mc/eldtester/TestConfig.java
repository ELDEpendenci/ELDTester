package com.ericlam.mc.eldtester;

import com.ericlam.mc.eld.annotations.Resource;
import com.ericlam.mc.eld.components.Configuration;
import org.bukkit.ChatColor;

import java.util.List;
import java.util.Map;

@Resource(locate = "config.yml")
public class TestConfig extends Configuration {
    public String name;
    public int number;
    public boolean bool;
    public Map<String, Box> boxes;
    public List<Box> boxList;

    public static class Box {
        public String name;
        public int size;
        public ChatColor color;


        @Override
        public String toString() {
            return "Box{" +
                    "name='" + name + '\'' +
                    ", size=" + size +
                    ", color=" + color +
                    '}';
        }
    }


    @Override
    public String toString() {
        return "TestConfig{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", bool=" + bool +
                ", boxes=" + boxes +
                ", boxList=" + boxList +
                '}';
    }
}
