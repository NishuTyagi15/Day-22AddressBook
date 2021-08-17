package com.addressbook;

import java.util.List;

public class AddressBookModel {
    private List<Person> persons;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
