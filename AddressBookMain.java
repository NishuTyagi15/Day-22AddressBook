package com.addressbook;

import java.util.Scanner;

public class AddressBookMain {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private long phoneNumber;
    private String email;

    void entries() {
        Scanner S = new Scanner(System.in);

        System.out.print("\nFirst Name : ");
        firstName = S.nextLine();
        System.out.print("\nLast Name : ");
        lastName = S.nextLine();
        System.out.print("\nComplete Address : ");
        address = S.nextLine();
        System.out.print("\nCity : ");
        city  = S.nextLine();
        System.out.print("\nState : ");
        state  = S.nextLine();
        System.out.println("\nE-mail Address : ");
        email = S.nextLine();
        System.out.print("\nZip Code : ");
        zipCode = S.nextInt();
        System.out.print("\nPhone Number : ");
        phoneNumber = S.nextLong();
    }

    public void readEntries() {
        System.out.println("First Name:"+firstName );
        System.out.println("Last Name:"+lastName );
        System.out.println("Complete Address:"+address );
        System.out.println("City:"+city );
        System.out.println("State:"+state);
        System.out.println("E-mail Address:"+email );
        System.out.println("Zip Code:"+zipCode );
        System.out.println("Phone Number:"+phoneNumber );
    }

    public static void main(String[] args) {
        AddressBookMain ab = new AddressBookMain();
        ab.entries();
        ab.readEntries();
    }
}
