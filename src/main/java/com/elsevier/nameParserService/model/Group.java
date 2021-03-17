package com.elsevier.nameParserService.model;

import java.util.ArrayList;

public class Group {
    private final ArrayList<Person> group;

    public ArrayList<Person> getGroup() {
        return group;
    }

    public Group(ArrayList<Person> group) {
        this.group = group;
    }
}
