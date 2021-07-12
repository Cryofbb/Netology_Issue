package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Issue {
    private int id;
    private String name;
    private String author;
    private int date;
    private Set<String> label = new HashSet<>();
    private String assignee;

    public void addLabel(String labels) {
        label.add(labels);
    }
}
