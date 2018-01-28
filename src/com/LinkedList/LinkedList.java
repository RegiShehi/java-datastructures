package com.LinkedList;

public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;
    private int size;

    @Override
    public void insertDataAtBeginning(T data) {
        this.size++;

        if (isEmpty())
            this.root = new Node<>(data);
        else {
            Node<T> newNode = new Node<>(data);
            newNode.setNextNode(root);
            this.root = newNode;
        }
    }

    @Override
    public void insertDataAtEnd(T data) {
        this.size++;
        Node<T> tempNode = this.root;

        if (isEmpty())
            this.root = new Node<>(data);
        else {
            navigateToEnd(tempNode);
            tempNode.setNextNode(new Node<>(data));
        }
    }

    private void navigateToEnd(Node<T> node) {
        if (node.getNextNode() != null)
            navigateToEnd(node.getNextNode());
    }

    @Override
    public void remove(T data) {
        if (isEmpty())
            System.out.println("List is empty");
        if (this.root.getData().compareTo(data) == 0) {
            Node<T> tempNode = this.root;
            this.root = this.root.getNextNode();
            tempNode = null;
            --this.size;
        } else {
            remove(data, root, root.getNextNode());
        }
    }

    private void remove(T dataToRemove, Node<T> previousNode, Node<T> currentNode) {
        boolean flag = false;
        while (currentNode.getNextNode() != null) {
            if (currentNode.getData().compareTo(dataToRemove) == 0) {
                previousNode.setNextNode(currentNode.getNextNode());
                currentNode = null;
                flag = true;
                --this.size;
                return;
            }

            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
        if (flag == false)
            System.out.println(dataToRemove + " is not an item of the list");
    }

    @Override
    public void display() {
        if (isEmpty())
            System.out.println("List is empty");
        else {
            Node<T> tempNode = this.root;
            while (tempNode != null) {
                System.out.print(tempNode + " ");
                tempNode = tempNode.getNextNode();
            }
            System.out.println("");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (root == null)
            return true;
        else
            return false;
    }
}