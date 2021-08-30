package com.ericlam.mc.eldtester.gui;

import org.bukkit.event.inventory.ClickType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyOwnFilter {

    ClickType type();

}
