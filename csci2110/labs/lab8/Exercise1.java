package csci2110.labs.lab8;

import java.util.*;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter int or '0':");
        int input = in.nextInt();
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        while(input != 0){
            System.out.println("Enter int or '0':");
            tree.insert(input);
            input = in.nextInt();
        }

        System.out.printf("The max data value in the BST is: %d\n", tree.findMax());
        System.out.printf("The min data value in the BST is: %d\n", tree.findMin());

        System.out.println("What key would you like to search for?");
        int target = in.nextInt();
        in.close();
        if(tree.recursiveSearch(target) != null) System.out.println("Found!");
        else System.out.println("Not found!");
    }
}
