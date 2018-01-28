package com.Stack;

public class Stack<T extends Comparable<T>> implements List<T> {
    private Node<T> root;
    private int size;

    @Override
    public boolean isEmpty() {
        if (this.root == null)
            return true;
        else
            return false;
    }

    @Override
    public void push(T data) {
        ++this.size;
        if (isEmpty())
            this.root = new Node<>(data);
        else {
            Node<T> oldRoot = this.root;
            Node<T> newNode = new Node<>(data);
            newNode.setNextNode(oldRoot);
            this.root = newNode;
        }
    }

    @Override
    public T pop() {
        T data = this.root.getData();
        this.root = this.root.getNextNode();
        this.size--;

        return data;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void display() {
        Node<T> tempNode = this.root;
        while (tempNode != null) {
            System.out.print(tempNode + " ");
            tempNode = tempNode.getNextNode();
        }
    }
}
