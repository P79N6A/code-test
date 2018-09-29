package com.example.tutorial;

import java.io.FileOutputStream;

/**
 * @author: siyunfei
 * @date: 2018/8/10 11:37
 */
public class MessageWriter {
    public static void main(String[] args) {
        try {
            AddressBookProtos.Person.PhoneNumber.Builder phoneNumber = AddressBookProtos.Person.PhoneNumber.newBuilder();
            phoneNumber.setType(AddressBookProtos.Person.PhoneType.HOME).setNumber("18271633177");

            AddressBookProtos.Person.Builder person = AddressBookProtos.Person.newBuilder();
            person.setId(1).setName("xiaobai").addPhones(phoneNumber);

            AddressBookProtos.AddressBook.Builder addressBook = AddressBookProtos.AddressBook.newBuilder();
            addressBook.addPeople(person);

            addressBook.build().writeTo(new FileOutputStream("d:\\proto-buf.data"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
