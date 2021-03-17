package com.elsevier.nameParserService.model;

public class Person {
    private final String firstName;
    private final String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Person(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }
}
