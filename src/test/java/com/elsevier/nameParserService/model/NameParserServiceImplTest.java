package com.elsevier.nameParserService.model;

import com.elsevier.nameParserService.NameParserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameParserServiceImplTest {
    private final NameParserServiceImpl service = new NameParserServiceImpl();

    @Test
    @DisplayName("Name parser test: John Doe")
    void nameParser_spaceSeparator() {
        String input = "John Doe";
        Person person = service.parseName(input);

        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
    }

    @Test
    @DisplayName("Name parser test: Doe, John")
    void nameParser_lastnameFirstWithCommaSeparator() {
        String input = "Doe, John";
        Person person = service.parseName(input);

        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
    }

    @Test
    @DisplayName("Name parser test: Hans-Christian Jensen")
    void nameParser_dashInFirstName() {
        String input = "Hans-Christian Jensen";
        Person person = service.parseName(input);

        assertEquals("Hans-Christian", person.getFirstName());
        assertEquals("Jensen", person.getLastName());
    }

    @Test
    @DisplayName("Name parser test: H-C Jensen")
    void nameParser_dashInFirstNameShort() {
        String input = "H-C Jensen";
        Person person = service.parseName(input);

        assertEquals("H-C", person.getFirstName());
        assertEquals("Jensen", person.getLastName());
    }

    @Test
    @DisplayName("Name parser test: P. H. Kristensen")
    void nameParser_initialsWithPeriod() {
        String input = "P. H. Kristensen";
        Person person = service.parseName(input);

        assertEquals("P. H.", person.getFirstName());
        assertEquals("Kristensen", person.getLastName());
    }

    @Test
    @DisplayName("Name parser test: Kristensen, P. H.")
    void nameParser_initialsWithPeriodLastnameFirst() {
        String input = "Kristensen, P. H.";
        Person person = service.parseName(input);

        assertEquals("P. H.", person.getFirstName());
        assertEquals("Kristensen", person.getLastName());
    }

    @Test
    @DisplayName("Name parser test: Peter Hans Kristensen")
    void nameParser_firstAndMiddleName() {
        String input = "Peter Hans Kristensen";
        Person person = service.parseName(input);

        assertEquals("Peter Hans", person.getFirstName());
        assertEquals("Kristensen", person.getLastName());
    }

    @Test
    @DisplayName("Name parser test: Peter H. Kristensen")
    void nameParser_firstAndMiddleNameWithInitial() {
        String input = "Peter H. Kristensen";
        Person person = service.parseName(input);

        assertEquals("Peter H.", person.getFirstName());
        assertEquals("Kristensen", person.getLastName());
    }

    @Test
    @DisplayName("Name parser test: H-C Jensen, Peter Hans Kristensen, John Doe")
    void multipleNameParser_parseMultipleNames() {
        String input = "H-C Jensen, Peter Hans Kristensen, John Doe";

        Group group = service.parseNames(input);

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
