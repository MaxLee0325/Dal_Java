/*
    Student name: Yongteng Li
    Student id: B00940715
    Course: csci2110
    Project: assignment 4
 */

import java.util.*;

public class Exercise2 {
    public static void main(String[] args) {
        //since I am not using index to make the tree, linked list would be more efficient than array list
        LinkedList<BinaryTree> treeList1 = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Input the elements, end input with \"!\".");

        //take input, make it into a tree node, and store it in the Linked List
        String input = in.next();
        while(!input.equals("!")){
            BinaryTree<String> node = new BinaryTree<>();
            node.makeRoot(input);
            treeList1.add(node);
            input =in.next();
        }
        in.close();

        //validate the input, if empty input, throw the warning and break
        if(treeList1.isEmpty()){
            System.out.println("Invalid input! You should input at least one element!");
            return;
        }

        //store the top root of the tree
        BinaryTree<String> topRoot = treeList1.getFirst();
        //make a copy of the linked list
        LinkedList<BinaryTree> treeList2 = (LinkedList<BinaryTree>) treeList1.clone();


        /*
          making the tree involves two lists
          list1 offers the root node
          list2 offers the leaf node
          the operation ends when all the nodes are attached to the tree (list2 is empty)
          the second list stores the leaf nodes, so the first node should be removed before we start
         */
        treeList2.removeFirst();
        while(true){
            //take the first node from list1 and make it as root
            BinaryTree<String> root = treeList1.removeFirst();
            //take the first two nodes from list2, make them left and right children
            //validate the size of list2, break the operation if it's empty
            if(treeList2.isEmpty()) break;
            BinaryTree<String> left = treeList2.removeFirst();
            root.attachLeft(left);
            //always validate before removing
            if(treeList2.isEmpty()) break;
            BinaryTree<String> right = treeList2.removeFirst();
            root.attachRight(right);
        }

        // test statements
        System.out.printf("Height of the tree is: %d\n", BinaryTree.height(topRoot));

        System.out.printf("Number of nodes in the tree is: %d\n", BinaryTree.nodes(topRoot));

        System.out.println();

        System.out.print("Inorder:\t");
        BinaryTree.inorder(topRoot);
        System.out.println();

        System.out.print("Preorder:\t");
        BinaryTree.preorder(topRoot);
        System.out.println();

        System.out.print("Postorder:\t");
        BinaryTree.postorder(topRoot);
        System.out.println();

        System.out.print("Level order:\t");
        BinaryTree.levelOrder(topRoot);
        System.out.println();
        System.out.println();

        System.out.printf("And is it height balanced... %s\n", BinaryTree.heightBalanced(topRoot) ? "Yes!" : "No.");

        System.out.println();
    }

}
