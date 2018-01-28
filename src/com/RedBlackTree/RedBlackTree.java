package com.RedBlackTree;

public class RedBlackTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;

    @Override
    public void traverse() {
        if (root == null)
            System.out.println("Tree is empty! Nothing to display...");
        else
            inOrderTraversal(root);
    }

    private void inOrderTraversal(Node<T> node) {
        if (node.getLeftChild() != null)
            inOrderTraversal(node.getLeftChild());

        System.out.print(node);

        if (node.getRightChild() != null)
            inOrderTraversal(node.getRightChild());
    }

    @Override
    public void insert(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> node, T data) {
        if (node == null)
            return new Node<>(data);

        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(insert(node.getLeftChild(), data));
            node.getLeftChild().setParent(node);
        }
        if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(insert(node.getRightChild(), data));
            node.getRightChild().setParent(node);
        }

        return node;
    }
}
