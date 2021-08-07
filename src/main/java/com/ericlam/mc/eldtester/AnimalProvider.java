package com.ericlam.mc.eldtester;

import javax.inject.Inject;
import javax.inject.Provider;

public class AnimalProvider implements Provider<Animal> {

    private final boolean isDog;

    @Inject
    public AnimalProvider(TestConfig testConfig){
        this.isDog = testConfig.bool;
    }

    @Override
    public Animal get() {
        return isDog ? new Dog() : new Cat();
    }
}
