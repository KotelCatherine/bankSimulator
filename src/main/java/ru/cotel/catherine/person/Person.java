package ru.cotel.catherine.person;

public class Person {
    private final String name;
    private final String lastName;

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getFullNamePerson(){
        return lastName + " " + name;
    }


}
