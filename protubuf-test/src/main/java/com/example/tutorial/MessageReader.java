package com.example.tutorial;

import java.io.FileInputStream;

/**
 * @author: siyunfei
 * @date: 2018/8/10 11:50
 */
public class MessageReader {
    public static void main(String[] args) {
        try {
            AddressBookProtos.AddressBook addressBook = AddressBookProtos.AddressBook.parseFrom(new FileInputStream("d:\\proto-buf.data"));
            System.out.println(addressBook);
            System.out.println(addressBook.getPeople(0).getPhones(0).getNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
