package com.elsevier.nameParserService.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupTest {

    @Test
    @DisplayName("Name parser test: H-C Jensen, Peter Hans Kristensen, John Doe")
    void multipleNameParser_parseMultipleNames() {
        String input = "H-C Jensen, Peter Hans Kristensen, John Doe";

        Group group = new Group(input);

        ArrayList<Person> names = group.getGroup();

        Person person1 = names.get(0);
        assertEquals("H-C", person1.getFirstName());
        assertEquals("Jensen", person1.getLastName());

        Person person2 = names.get(1);
        assertEquals("Peter Hans", person2.getFirstName());
        assertEquals("Kristensen", person2.getLastName());

        Person person3 = names.get(2);
        assertEquals("John", person3.getFirstName());
        assertEquals("Doe", person3.getLastName());


    }
}
