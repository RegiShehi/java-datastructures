package com.LinkedList;

public interface List <T> {
    void insertDataAtBeginning(T data);
    void insertDataAtEnd(T data);
    void remove (T data);
    void display();
    int size();
    boolean isEmpty();
}
