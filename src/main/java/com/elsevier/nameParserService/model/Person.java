package com.elsevier.nameParserService.model;

import com.tupilabs.human_name_parser.HumanNameParserBuilder;
import com.tupilabs.human_name_parser.HumanNameParserParser;
import com.tupilabs.human_name_parser.Name;

public class Person {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Person(String name) {
        Name newName = new Name(name);
        HumanNameParserBuilder builder = new HumanNameParserBuilder(newName);
        HumanNameParserParser parser = builder.build();
        if (!parser.getMiddle().isEmpty()) {
            this.firstName = parser.getFirst() + " " + parser.getMiddle();
        } else {
            this.firstName = parser.getFirst();
        }

        this.lastName = parser.getLast();
    }
}
