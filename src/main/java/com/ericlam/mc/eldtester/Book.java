package com.ericlam.mc.eldtester;

import com.ericlam.mc.eld.annotations.GroupResource;
import com.ericlam.mc.eld.components.GroupConfiguration;

import java.util.List;

@GroupResource(
        folder = "Books",
        preloads = {"internal-book"}
)
public class Book extends GroupConfiguration {

    public String title;
    public String author;
    public String description;
    public int pages;
    public List<String> contents;


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", pages=" + pages +
                ", contents=" + contents +
                '}';
    }
}
