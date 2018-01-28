package com.BinarySearchTree;

public interface Tree<T> {
    void traversal();

    void insert(T data);

    void remove(T data);

    T getMax();

    T getMin();
}
