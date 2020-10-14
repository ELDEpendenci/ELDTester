package com.ericlam.mc.eldtester;

import javax.inject.Inject;
import java.util.Map;

public class StorageManager {

    private final StorageService storageService;

    @Inject
    public StorageManager(TestConfig config, Map<String, StorageService> serviceMap){
        this.storageService = serviceMap.get(config.useMySQL ? "mysql" : "yaml");
        this.storageService.initialize();
    }


    public void save(){
        this.storageService.save();
    }
}
