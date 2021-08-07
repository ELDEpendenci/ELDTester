package com.ericlam.mc.eldtester.sql;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

public class CustomARepoImpl implements CustomARepo {

    @Inject
    private Provider<EntityManager> entityManagerProvider;

    @Override
    public void doSpecialThing(User user) {
        EntityManager em = entityManagerProvider.get();
        // 使用 EntityManager 操作...
    }
}
