package com.elsevier.nameParserService;

import com.elsevier.nameParserService.model.Group;
import com.elsevier.nameParserService.model.Person;
import com.tupilabs.human_name_parser.HumanNameParserBuilder;
import com.tupilabs.human_name_parser.HumanNameParserParser;
import com.tupilabs.human_name_parser.Name;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameParserServiceImpl implements NameParserService {

    @Override
    public Person parseName(String name) {
        Name newName = new Name(name);
        String firstName;
        String lastName;

        // using library to parse names from string
        HumanNameParserBuilder builder = new HumanNameParserBuilder(newName);
        HumanNameParserParser parser = builder.build();
        // Need to add the middle names to the first name (if any)
        if (!parser.getMiddle().isEmpty()) {
            firstName = parser.getFirst() + " " + parser.getMiddle();
        } else {
            firstName = parser.getFirst();
        }

        lastName = parser.getLast();

        return new Person(firstName, lastName);
    }

    @Override
    public Group parseNames(String groupOfNames) {

        // split the names around ','
        String[] names = groupOfNames.split(",");

        //remove leading (and trailing) white space around each name (each string)
        //first make the list into a collection
        List<String> namesCollection = Arrays.asList(names);
        //then apply trim() to each string and return as a new list
        List<String> trimmedNames = namesCollection.stream().map(String::trim).collect(Collectors.toList());

        //lastly create Person objects from each name string
        ArrayList<Person> group = new ArrayList<>();
        trimmedNames.forEach( (name) -> group.add(parseName(name)));
        return new Group(group);
    }
}
