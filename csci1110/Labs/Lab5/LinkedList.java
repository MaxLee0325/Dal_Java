package csci1110.Labs.Lab5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedList{
    private Node head;
    private int count;

    //constructor
    public LinkedList(){
        head = null;
        count = 0;
    }

    public int size() {return count;}
    public Node getFirst() {return head;}

    //use data to create a new Node to be added to the end of the list
    public void addToEnd(String carrier, String infected){
        Node node = new Node(carrier, infected, null);
        if(head == null){
            head = node;
        }
        else{
            Node temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
        count++;
    }

    //prints all Nodes in the list from start to end
    public String carriers(){
        Node node = head;
        ArrayList<String> carriers = new ArrayList<>();
        while(node != null){
            if(!carriers.contains(node.getCarrier())) {
                carriers.add(node.getCarrier());
            }
            node = node.getNext();
        }
        String carr = "";
        for(String i : carriers){
            carr += i + " ";
        }
        return carr;
    }

    //returns String of the infected with no repeats (one space between names)
    public String infected(){
        Node node = head;
        ArrayList<String> infected = new ArrayList<>();
        while(node != null){
            if(!infected.contains(node.getInfected())) {
                infected.add(node.getInfected());
            }
            node = node.getNext();
        }
        String infe = "";
        for(String i : infected){
            infe += i + " ";
        }
        return infe;
    }

    //returns a String of all the people who got infected but didn’t pass the virus on (no repeats) with one space between names
    public String immune(){
        HashSet<String> carriers = new LinkedHashSet<>();
        HashSet<String> infected = new LinkedHashSet<>();
        Node node = head;
        while(node != null){
            carriers.add(node.getCarrier());
            infected.add(node.getInfected());
            node = node.getNext();
        }
        String immune = "";
        for(String i : infected){
            if(!carriers.contains(i)){
                immune += i + " ";
            }
        }
        return immune.trim();
    }

    //returns a String with all the infected by the 'carrier '(no repeats) with one space between names
    public String spreader(String carrier){
        Node node = head;
        String spread = "";
        HashMap<String, String> map = new HashMap<>();
        HashSet<String> set = new LinkedHashSet<>();
        while(node != null){
            map.put(node.getCarrier(), node.getInfected());
            if(map.get(carrier) != null){
                set.add(map.get(carrier));
            }
            node = node.getNext();
        }
        for(String i : set){
            spread += i + " ";
        }
        return spread.trim();
    }
}


