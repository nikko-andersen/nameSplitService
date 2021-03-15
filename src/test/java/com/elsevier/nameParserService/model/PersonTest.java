package com.elsevier.nameParserService.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    @DisplayName("Name parser test: John Doe")
    void nameParser_spaceSeparator() {
        String input = "John Doe";
        Person person = new Person(input);

        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
    }

    @Test
    @DisplayName("Name parser test: Doe, John")
    void nameParser_lastnameFirstWithCommaSeparator() {
        String input = "Doe, John";
        Person person = new Person(input);

        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
    }

    @Test
    @DisplayName("Name parser test: Hans-Christian Jensen")
    void nameParser_dashInFirstName() {
        String input = "Hans-Christian Jensen";
        Person person = new Person(input);

        assertEquals("Hans-Christian", person.getFirstName());
        assertEquals("Jensen", person.getLastName());
    }

    @Test
    @DisplayName("Name parser test: H-C Jensen")
    void nameParser_dashInFirstNameShort() {
        String input = "H-C Jensen";
        Person person = new Person(input);

        assertEquals("H-C", person.getFirstName());
        assertEquals("Jensen", person.getLastName());
    }

    @Test
    @DisplayName("Name parser test: P. H. Kristensen")
    void nameParser_initialsWithPeriod() {
        String input = "P. H. Kristensen";
        Person person = new Person(input);

        assertEquals("P. H.", person.getFirstName());
        assertEquals("Kristensen", person.getLastName());
    }

    @Test
    @DisplayName("Name parser test: Kristensen, P. H.")
    void nameParser_initialsWithPeriodLastnameFirst() {
        String input = "Kristensen, P. H.";
        Person person = new Person(input);

        assertEquals("P. H.", person.getFirstName());
        assertEquals("Kristensen", person.getLastName());
    }

    @Test
    @DisplayName("Name parser test: Peter Hans Kristensen")
    void nameParser_firstAndMiddleName() {
        String input = "Peter Hans Kristensen";
        Person person = new Person(input);

        assertEquals("Peter Hans", person.getFirstName());
        assertEquals("Kristensen", person.getLastName());
    }

    @Test
    @DisplayName("Name parser test: Peter H. Kristensen")
    void nameParser_firstAndMiddleNameWithInitial() {
        String input = "Peter H. Kristensen";
        Person person = new Person(input);

        assertEquals("Peter H.", person.getFirstName());
        assertEquals("Kristensen", person.getLastName());
    }


}
