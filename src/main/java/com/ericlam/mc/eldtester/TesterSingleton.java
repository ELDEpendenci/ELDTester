package com.ericlam.mc.eldtester;

import java.util.HashMap;
import java.util.Map;

public class TesterSingleton {

    private final Map<String, String> collection = new HashMap<>();

    public void setKey(String key, String value){
        this.collection.put(key, value);
    }

    public String getString(){
        return this.collection.toString();
    }
}
