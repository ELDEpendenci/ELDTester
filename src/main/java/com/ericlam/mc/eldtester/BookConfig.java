package com.ericlam.mc.eldtester;

import com.ericlam.mc.eld.annotations.GroupResource;
import com.ericlam.mc.eld.components.GroupConfiguration;

import java.util.List;

@GroupResource(folder = "Books")
public class BookConfig extends GroupConfiguration {

    public String title;
    public String author;
    public String description;
    public int pages;
    public List<String> contents;

}
