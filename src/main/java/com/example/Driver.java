package com.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import static com.example.PersonProto.Person;

public class Driver {
    public static void main(String[] args) {
        Person person = Person.newBuilder()
                .setId(1)
                .setUsername("John Doe")
                .build();
        try (FileOutputStream out = new FileOutputStream("/home/rohans-ubuntu/Desktop/proto-out")) {
            person.writeTo(out);
            System.out.println("Write successful");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (FileInputStream in = new FileInputStream("/home/rohans-ubuntu/Desktop/proto-out")) {
            Person.Builder personBuilder = Person.newBuilder();
            Person inPerson = personBuilder.mergeFrom(in).build();
            System.out.println(inPerson.getId() + " : " + inPerson.getUsername());
            System.out.println("Read Successful");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
