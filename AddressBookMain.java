package com.addressbook;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import java.io.*;
import java.util.*;

public class AddressBookMain implements AddressBookInterface {

    Scanner S = new Scanner(System.in);
    int counter = 0;
    String path = "C:\\Users\\tyagi\\eclipse-workspace\\AddressBook\\src\\com\\addressbook\\addressbook.json";
    String statename = "";
    static AddressBookModel model = new AddressBookModel();
    static ArrayList<Person> persons = new ArrayList<Person>();

    @Override
    public void readJson() {
        // checking whether it is empty or not
        File file = new File(path);
        if (file.exists() && file.length() != 0) {
            try {
                model = (AddressBookModel) JsonMethod.read(path, model);
            } catch (IOException e) {
                e.printStackTrace();
            }
            persons.addAll(model.getPersons());
            counter = persons.size();
        }
    }

    @Override
    public void addPerson() {
        System.out.println(".....Add Person's Details.....");
        Person person = new Person();

        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < persons.size(); i++) {
            map.put(persons.get(i).getMobile(), persons.get(i).getMobile());
        }
        System.out.println("Available Mobile Numbers: " + map.keySet());
        System.out.println("Enter Mobile Number: ");
        Long mobile = S.nextLong();
        // validating mobile is not taken by anyone
        boolean isMobileTaken = false;
        for (int j = 0; j < persons.size(); j++) {
            if (persons.get(j).getMobile().equals(mobile)) {
                isMobileTaken = true;
                break;
            }
        }
        if (isMobileTaken) {
            System.out.println("This Mobile Number is Already Taken!");
        } else {
            person.setMobile(mobile);
            System.out.println("Enter Person First Name: ");
            person.setFirstname(S.next().toLowerCase());
            System.out.println("Enter Person Last Name: ");
            person.setLastname(S.next().toLowerCase());
            System.out.println("Enter E-mail Address: ");
            person.setEmail(S.next());
            System.out.println("Enter Address Details Here ");
            Address address = new Address();
            System.out.println("Enter Address: ");
            address.setAddressLocal(S.next());
            System.out.println("Enter City: ");
            address.setCity(S.next());
            address.setState(statename);
            System.out.println("Enter ZipCode: ");
            address.setZip(S.nextInt());

            person.setAddressObj(address);

            persons.add(person);

            System.out.println();
            System.out.println("Person's Details Added!");
            counter++;
        }
    }

    @Override
    public void save() {
        System.out.println("------------Save Persons Details-------------");

        System.out.println("......Saving details into json file......");
        model.setPersons(persons);
        try {
            JsonMethod.write(path, model);
        } catch (IOException e) {

            e.printStackTrace();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("Writing into file Successful....");
        System.out.println("---------------Save Address Book-----------------");
    }

    public static void main(String[] args)
            throws InterruptedException, JsonParseException, JsonMappingException, IOException {
        AddressBookMain main = new AddressBookMain();
        main.readJson();
        Scanner S = new Scanner(System.in);

        boolean isExitAddressBook = false;
        System.out.println("Address Book Manager!\n");
        while (!isExitAddressBook) {

            System.out.println("Select an Option!");
            System.out.println("1. Add an Entry");
            System.out.println("2. Save Details");
            System.out.println("3. Exit from the Menu");
            System.out.print("> ");
            int choice = S.nextInt();
            switch (choice) {
                case 1:
                    //Add Person Details
                    main.addPerson();
                    break;

                case 2:
                    //Save Person Details
                    main.save();
                    break;

                case 3:
                    // Exit
                    System.out.println("---------------Exit Address Book-----------------");
                    isExitAddressBook = true;
                    System.out.println("Thank you for your Time!");

                    break;
                default:
                    System.out.println("Invalid Option! Please Choose Correct Options from the Menu!");
                    break;
            }
        }
    }
}
