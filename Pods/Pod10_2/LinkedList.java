package Pods.Pod10_2;

/**
 * CSCI 1110
 * @author ASiegel
 */

import java.util.NoSuchElementException;

/**
 * A listnked list is a sequence of nodes with efficient element
 * insertion and removal. This class contains a subset of the methods
 * of the standard java.util.LinkedList class.
 *
 * You will finish off the contains method.
 */

public class LinkedList
{
    //attributes
    private Node head;
    private Node tail;

    //Node
    class Node
    {
        public Object data;
        public Node previous;
        public Node next;
    }

    /**
     * Constructs an empty linked list/
     */
    public LinkedList()
    {
        head = null;
        tail = null;
    }



    /**
     * @method removeHead()
     * @param data : object to be removed
     * @returns void
     *
     *
     */

    public void remove(Object data) {
        Node node = head;
        //the case that the head is to be removed
        if(node.data.equals(data)){
            head = node.next;
            node.next = null;
            head.previous = null;
        }
        //the case that the tail is to be removed
        else if(tail.data.equals(data)){
            node = tail;
            tail = node.previous;
            tail.next = null;
            node.previous = null;
        }
        //the case that's in the middle
        else{
            node = head.next;
            while(node != null){
                if(node.data.equals(data)){
                    Node previous = node.previous;
                    Node next = node.next;
                    previous.next = next;
                    next.previous = previous;
                    node.previous = null;
                    node.next = null;
                }
                node = node.next;
            }
        }
    }

    /**
     * Appends a new node to the end of the linked list.
     */
    public void append(Object element)
    {
        if (head == null) //Empty linked list
        {
            Node firstNode = new Node();
            firstNode.data = element;
            firstNode.previous = null;
            firstNode.next = null;
            head = firstNode;
            tail = firstNode;
        }
        else //At least one node already exists.
        {
            Node newNode = new Node();
            newNode.data = element;
            newNode.previous = tail;
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
        }
    }


    public String toString()
    {
        Node position = head;
        String output = "";
        while (position != null)
        {
            output += position.data + "\n";
            position = position.next;
        }
        return output;
    }
}