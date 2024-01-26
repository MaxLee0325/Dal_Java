package Pods.Pods9_4;

import java.util.*;
public class Queue {

    private Node head;
    private Node tail;

    class Node{
        public String data;
        public Node previous;
        public Node next;
    }
    public Queue(){
        this.head = null;
        this.tail = null;
    }

    /**
     * add Method: Adds a batter to the batting order (linked list)
     * @param s string to add to the linked list
     * @return void
     */
    public void add(String s) {
        Node node = new Node();
        node.data = s;
        if(head == null){
            node.previous = null;
            node.next = null;
            head = node;
            tail = node;

        }
        else {
            tail.next = node;
            node.previous = tail;
            node.next = null;
            tail = node;
        }
    }

    /**
     * remove Method: Removes a batter from the batting order (linked list)
     * @return String batter's name
     */
    public String remove() {
        String str = head.data;
        Node node = head;
        head = head.next;
        node.next = null;
        return str;
    }
}

