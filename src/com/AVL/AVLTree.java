package com.AVL;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void insert(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> node, T data) {
        if (node == null)
            return new Node<>(data);

        if (data.compareTo(node.getData()) < 0)
            node.setLeftChild(insert(node.getLeftChild(), data));
        if (data.compareTo(node.getData()) > 0)
            node.setRightChild(insert(node.getRightChild(), data));

        node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);

        node = checkBalance(node);

        return node;
    }

    private Node<T> checkBalance(Node<T> node) {
        int balance = getBalance(node);

        /*if (balance > 1 && data.compareTo(node.getLeftChild().getData()) < 0)
            return rightRotation(node);
        if (balance < -1 && data.compareTo(node.getRightChild().getData()) > 0)
            return leftRotation(node);
        if (balance > 1 && data.compareTo(node.getLeftChild().getData()) > 0) {
            node.setLeftChild(leftRotation(node.getLeftChild()));
            return rightRotation(node);
        }
        if (balance < -1 && data.compareTo(node.getData()) < 0) {
            node.setRightChild(rightRotation(node.getRightChild()));
            return leftRotation(node);
        }

        return node;*/

        if (balance > 1) {
            if (getBalance(node.getLeftChild()) < 0)
                node.setLeftChild(leftRotation(node.getLeftChild()));

            return rightRotation(node);
        }

        if (balance < -1) {
            if (getBalance(node.getRightChild()) > 0)
                node.setRightChild(rightRotation(node.getRightChild()));

            return leftRotation(node);
        }
        return node;
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
        node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
        return checkBalance(node);
    }

    private Node<T> getPredecessor(Node<T> node) {
        Node<T> predecessor = node;

        while (predecessor.getRightChild() != null)
            predecessor = predecessor.getRightChild();

        return predecessor;
    }

    @Override
    public void traverse() {
        if (root == null)
            System.out.println("Tree is empty");
        else
            inOrderTraversal(root);
    }

    private void inOrderTraversal(Node<T> node) {
        if (node.getLeftChild() != null)
            inOrderTraversal(node.getLeftChild());

        System.out.print(node.getData() + " -> ");

        if (node.getRightChild() != null)
            inOrderTraversal(node.getRightChild());
    }

    private int height(Node<T> node) {
        if (node == null)
            return -1;

        return node.getHeight();
    }

    private int getBalance(Node<T> node) {
        if (root == null)
            return 0;
        else
            return height(node.getLeftChild()) - height(node.getRightChild());
    }

    private Node<T> rightRotation(Node<T> node) {
        System.out.println("Rotating right on node " + node);

        Node<T> tempLeftNode = node.getLeftChild();
        Node<T> t = tempLeftNode.getRightChild();

        tempLeftNode.setRightChild(node);
        node.setLeftChild(t);

        node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
        tempLeftNode.setHeight(Math.max(height(tempLeftNode.getLeftChild()), height(tempLeftNode.getRightChild())) + 1);

        return tempLeftNode;
    }

    private Node<T> leftRotation(Node<T> node) {
        System.out.println("Rotating left on node " + node);

        Node<T> tempRightNode = node.getRightChild();
        Node<T> t = tempRightNode.getLeftChild();

        tempRightNode.setLeftChild(node);
        node.setRightChild(t);

        node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
        tempRightNode.setHeight(Math.max(height(tempRightNode.getLeftChild()), height(tempRightNode.getRightChild())) + 1);

        return tempRightNode;
    }
}
