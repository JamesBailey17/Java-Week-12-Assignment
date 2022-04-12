/*
Description: This program uses object serialization to
collect and process the following information: the person's name,
their phone number, their date of birth, and their email address.

Program Author: James Bailey
 */

package com.company;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner keyboardInput = new Scanner(System.in);
        ArrayList<Person> People = new ArrayList<>();
        boolean mainLoop = true;
        int userChoice;
        while (true) {
            System.out.println();
            System.out.println("1) Add information into file.");
            System.out.println("2) Retrieve information and display.");
            System.out.println("3) Delete Information.");
            System.out.println("4) Update Information");
            System.out.println("5) Exit.");
            System.out.println("");
            userChoice = keyboardInput.nextInt();
            keyboardInput.nextLine(); // clear input buffer

            switch (userChoice) {
                case 1:
                    Person newPerson = new Person();
                    System.out.println("You have selected to enter a person's data.");
                    System.out.println("Enter the name:");
                    newPerson.name = keyboardInput.nextLine();
                    System.out.println("Enter the phone number:");
                    newPerson.phoneNumber = keyboardInput.nextLine();
                    System.out.println("Enter the date of birth");
                    newPerson.DOB = keyboardInput.nextLine();
                    System.out.println("Enter the email:");
                    newPerson.email = keyboardInput.nextLine();
                    People.add(newPerson);
                    // write person's information to the file
                    try {
                        for (int x=0; x< People.size(); x++)
                            writeToFile(People.get(x));
                        writeToFile(newPerson);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("\nReading information from .bin File: ");
                    try {
                        readFile();
                    } catch (ClassNotFoundException | IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("\nDelete information from .bin File: ");
                    break;

                case 4:
                    System.out.println("\nUpdate information from the .bin File: ");
                    break;
                case 5:
                    System.out.println("\nExiting Program:");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nNot a valid menu selection, please make a selection 1 - 5");
                    break;
            }
        /*try {
            writeToFile(person);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            readFile();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
        }*/
        }
    }
    public static void writeToFile(Person P) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Person.bin"));
        objectOutputStream.writeObject(P);
    }

    public static void readFile() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Person.bin"));
        Person info = (Person) objectInputStream.readObject();
        System.out.println(info);
        objectInputStream.close();
    }
}
