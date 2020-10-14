package com.ericlam.mc.eldtester;

import javax.inject.Inject;

public class MySQLStorageService implements StorageService{

    @Inject
    private TestConfig config;

    @Override
    public void initialize() {
        System.out.println("initialize with mysql with host: "+config.host);
    }

    @Override
    public void save() {
        System.out.println("using mysql to save");
    }
}
