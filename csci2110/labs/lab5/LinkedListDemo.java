package csci2110.labs.lab5;

import java.util.*;
public class LinkedListDemo{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();
        System.out.println("Enter Pokemon names, one on each line:");
        String input = in.nextLine();
        //read input and add to list
        while(!input.equals("quit")){
            list.add(input);
            input = in.nextLine();
        }
        System.out.println("This is the full list:");
        System.out.println(list.toString());
        System.out.println();
        System.out.println(displayEven(list));
        System.out.println(displayOdd(list));
        System.out.println(reverse(list).toString() + "\n");
        System.out.println(removeMiddle(list));
        System.out.println(list.toString());
    }

    //method to display even-numbered nodes
    public static String displayEven(LinkedList<String> list){
        Node<String> node = list.getFront();
        if (node == null) return "Empty list!";

        System.out.println("This is a list of strings with only even index:");
        while(node != null){
            System.out.print(node.getData() + "--> ");
            node = node.getNext();
            if(node == null) break;
            else node = node.getNext();
        }
        return "\n";
    }

    //method to display odd-numbered nodes
    public static String displayOdd(LinkedList<String> list){
        Node<String> node = list.getFront();
        if(node == null) return "Empty list!";

        node = node.getNext();
        System.out.println("This is a list of strings with only odd index:");
        while(node != null){
            System.out.print(node.getData() + "--> ");
            node = node.getNext();
            if(node == null) break;
            else node = node.getNext();
        }
        return "\n";
    }

    //method to create a reversed linked list

    public static LinkedList<String> reverse(LinkedList<String> list){
        int size = list.size();
        if(size == 0) return list;
        if(size == 1){
            System.out.println("This is the reversed list: ");
            return list;
        }

        LinkedList<String> out = new LinkedList<>();
        for(int i = 0; i < size; i++){
            out.add(list.getAt(i));
        }
        System.out.println("This is the reversed list: ");
        return out;
    }

    //method to remove the middle node in the linked list
    public static String removeMiddle(LinkedList<String> list){
        if (list.size() == 0) return "Empty list!";

        int size = list.size();
        list.removeAt(size / 2);
        return "Middle removed:";
    }
}
