package com.ericlam.mc.eldtester;

public class YamlStorageService implements StorageService{
    @Override
    public void initialize() {
        System.out.println("initialize with yaml");
    }

    @Override
    public void save() {
        System.out.println("using yaml to save");
    }
}
