package csci1110.Labs.Lab5;

import java.util.Scanner;

public class VirusDemo{
    public static void main (String [] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        LinkedList list = new LinkedList();

        while(!str.equals("*")){
            list.addToEnd(str, in.next());
            str = in.next();
        }
        String spreader = in.next();
        System.out.printf("Number of Pairs: %d\n", list.size());
        Node node = list.getFirst();
        String output = "";
        while(node != null){
            output += node.toString();
            node = node.getNext();
        }
        System.out.println(output);
        System.out.println("Carriers: " + list.carriers());
        System.out.println("Infected: " + list.infected());
        System.out.println("Immune: " + list.immune());
        System.out.println(spreader + " spread to " + list.spreader(spreader));
    }
}



