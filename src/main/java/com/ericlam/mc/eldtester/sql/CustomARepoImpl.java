package com.ericlam.mc.eldtester.sql;

import com.ericlam.mc.eldtester.ELDTester;

import javax.inject.Inject;

public class CustomARepoImpl implements CustomARepo {

    @Inject
    private ELDTester eldTester;

    @Override
    public void myMethodA() {
        eldTester.getLogger().info("A method from "+this.getClass());
    }
}
