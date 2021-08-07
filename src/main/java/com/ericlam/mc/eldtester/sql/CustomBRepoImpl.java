package com.ericlam.mc.eldtester.sql;

import com.ericlam.mc.eldtester.ELDTester;

import javax.inject.Inject;

public class CustomBRepoImpl implements CustomBRepo {


    @Inject
    private ELDTester eldTester;

    @Override
    public void doSomeThingCool(User user) {
        eldTester.getLogger().info(user.toString());
    }
}
