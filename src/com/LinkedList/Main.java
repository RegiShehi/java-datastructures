package com.LinkedList;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {
	    LinkedList<Person> list = new LinkedList<Person>();

	    list.insertDataAtEnd(new Person("Regi", 25));
        list.insertDataAtEnd(new Person("Lazarjol", 26));
        list.insertDataAtBeginning(new Person("Orhan", 25));

	    list.display();
        System.out.println(list.size());
    }
}
