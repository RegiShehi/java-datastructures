package com.BinarySearchTree;

public class Main {

    public static void main(String[] args) {
        Tree<Person> bst = new BinarySearchTree<>();

/*        bst.insert(32);
        bst.insert(10);
        bst.insert(1);
        bst.insert(19);
        bst.insert(16);
        bst.insert(23);
        bst.insert(55);
        bst.insert(79);

        bst.remove(32);*/

        bst.insert(new Person("Regi", 25));
        bst.insert(new Person("Geri", 25));
        bst.insert(new Person("Xhoi", 15));
        bst.insert(new Person("Xheni", 23));
        bst.insert(new Person("Enxhi", 21));
        bst.insert(new Person("Megi", 22));

        bst.traversal();
    }
}
