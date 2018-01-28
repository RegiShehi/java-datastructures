package com.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();

        queue.enqueue("Regi");
        queue.enqueue("Geri");
        queue.enqueue("Xhoi");

        System.out.println(queue.size());

        queue.display();
    }
}
