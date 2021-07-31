package com.ericlam.mc.eldtester.sql;

import chu77.eldependenci.sql.EntityRegistration;

import java.util.List;

public class EldTesterRegistration implements EntityRegistration {

    @Override
    public List<Class<?>> getEntityClasses() {
        return List.of(
                User.class
        );
    }
}
