package com.company;

import java.io.Serializable;

public class Person implements Serializable {
    String name;
    String phoneNumber;
    String DOB;
    String email;

    public Person(){
        name = "";
        phoneNumber = "";
        DOB = "";
        email = "";
    }

    public Person(String name, String phoneNumber, String DOB, String email){
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.DOB = DOB;
    this.email = email;
    }

    @Override
    public String toString(){
        return "Person [name= " + name + "   Phone Number= " + phoneNumber + "   DOB= " + DOB + "   Email= " + email+"]";
    }
}
