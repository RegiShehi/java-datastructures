package com.BinarySearchTree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data);
        } else {
            insertNode(data, root);
        }
    }

    private void insertNode(T newData, Node<T> node) {
        if (newData.compareTo(node.getData()) < 0) {
            if (node.getLeftChild() != null) {
                insertNode(newData, node.getLeftChild());
            } else {
                Node<T> newNode = new Node<>(newData);
                node.setLeftChild(newNode);
            }
        } else {
            if (node.getRightChild() != null) {
                insertNode(newData, node.getRightChild());
            } else {
                Node<T> newNode = new Node<>(newData);
                node.setRightChild(newNode);
            }
        }
    }

    @Override
    public T getMax() {
        if (root == null)
            return null;
        else
            return getMaxValue(root);
    }

    private T getMaxValue(Node<T> node) {
        if (node.getRightChild() != null) {
            return getMaxValue(node.getRightChild());
        }
        return node.getData();
    }

    @Override
    public T getMin() {
        if (root == null)
            return null;
        else
            return getMinValue(root);
    }

    private T getMinValue(Node<T> node) {
        if (node.getLeftChild() != null) {
            return getMinValue(node.getLeftChild());
        }
        return node.getData();
    }

    @Override
    public void traversal() {
        if (root != null)
            inOrderTraversal(root);
    }

    private void inOrderTraversal(Node<T> node) {
        if (node.getLeftChild() != null)
            inOrderTraversal(node.getLeftChild());

        System.out.print(node.getData() + " -> ");

        if (node.getRightChild() != null)
            inOrderTraversal(node.getRightChild());
    }

    @Override
    public void remove(T data) {
        if (root != null)
            root = removeNode(data, root);
        else
            System.out.println("Tree is empty! Nothing to remove...");
    }

    private Node<T> removeNode(T data, Node<T> node) {
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(removeNode(data, node.getLeftChild()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(removeNode(data, node.getRightChild()));
        } else {
            //delete leaf node
            if (node.getLeftChild() == null && node.getRightChild() == null) {
                System.out.println("Removing a leaf node...");
                return null;
            }

            //delete node that has a single child
            if (node.getLeftChild() == null) {
                System.out.println("Removing the right child...");
                Node<T> tempNode = node.getRightChild();
                node = null;

                return tempNode;
            } else if (node.getRightChild() == null) {
                System.out.println("Removing the left child...");
                Node<T> tempNode = node.getLeftChild();
                node = null;

                return tempNode;
            }

            //delete node that has two children
            System.out.println("Removing node with two children");
            Node<T> tempNode = getPredecessor(node.getLeftChild());

            node.setData(tempNode.getData());
            node.setLeftChild(removeNode(tempNode.getData(), node.getLeftChild()));
        }
        return node;
    }

    private Node<T> getPredecessor(Node<T> node) {
        if (node.getRightChild() != null)
            return getPredecessor(node.getRightChild());

        return node;
    }
}
