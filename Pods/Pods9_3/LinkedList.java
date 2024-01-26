package Pods.Pods9_3;

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

    //PLEASE START WORK HERE
    //===============================================

    /**
     * Check to see if element is contained
     * anywhere in the linked list.
     * @returns boolean: true if contained
     */

// WRITE YOUR CODE HERE

    //===============================================
    //PLEASE END WORK HERE
    public boolean contains(String player){
        if(head != null){
            Node node = head;
            while(!node.data.equals(player) && node.next != null){
                node = node.next;
            }
            if(node.data.equals(player)) return true;
            else return false;
        }
        else return false;
    }

}