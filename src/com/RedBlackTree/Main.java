package com.RedBlackTree;

public class Main {
    public static void main(String[] args) {
        RedBlackTree<Integer> rbt = new RedBlackTree<>();

        rbt.insert(1);
        rbt.insert(2);
        rbt.insert(3);
        rbt.insert(4);
        rbt.insert(5);

        rbt.traverse();
    }
}
