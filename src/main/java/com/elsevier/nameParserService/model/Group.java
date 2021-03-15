package com.elsevier.nameParserService.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Group {
    private final ArrayList<Person> group = new ArrayList<>();

    public ArrayList<Person> getGroup() {
        return group;
    }

    public Group(String groupOfNames) {

        // split the names around ','
        String[] names = groupOfNames.split(",");

        //remove leading (and trailing) white space around each name (each string)
        //first make the list into a collection
        List<String> namesCollection = Arrays.asList(names);
        //then apply trim() to each string and return as a new list
        List<String> trimmedNames = namesCollection.stream().map(String::trim).collect(Collectors.toList());

        //lastly create Person objects from each name string
        trimmedNames.forEach( (name) -> group.add(new Person(name)));

    }
}
