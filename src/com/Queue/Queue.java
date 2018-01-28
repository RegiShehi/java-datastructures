package com.Queue;

public class Queue<T extends Comparable<T>> {
    private Node<T> startNode;
    private Node<T> endNode;
    private int size;

    public Queue(){
        this.size = 0;
        this.startNode = null;
        this.endNode = null;
    }

    public boolean isEmpty() {
        if (this.startNode == null)
            return true;
        else
            return false;
    }

    public int size() {
        return this.size;
    }

    public void enqueue(T data) {
        ++this.size;
        if (isEmpty()) {
            this.startNode = new Node<>(data);
            this.endNode = this.startNode;
            this.endNode.setNextNode(null);
        } else {
            Node<T> tempNode = this.endNode;

            this.endNode = new Node<>(data);
            this.endNode.setNextNode(null);
            tempNode.setNextNode(this.endNode);
        }
    }

    public T dequeue() {
        --this.size;

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        T data = this.startNode.getData();
        this.startNode = this.startNode.getNextNode();

        return data;
    }

    public void display(){
        Node<T> tempNode = this.startNode;
        while (tempNode != this.endNode){
            System.out.print(tempNode.getData() + " ");
            tempNode = tempNode.getNextNode();
        }
        System.out.println(endNode.getData());
    }
}
