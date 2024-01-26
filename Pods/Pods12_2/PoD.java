package Pods.Pods12_2;

/**
 * CSCI 1105
 * @author ASiegel, YourName
 */

import java.util.*;

public class PoD
{

//=============================================================================
    /**
     * Returns true if binary tree is height-balanced
     * @param bTree BinaryTree of interest
     * @return
     */

    public static boolean isBalanced(BinaryTree bTree) {
        if(bTree.isEmpty()){
            return true;
        }
        else if(Math.abs(bTree.left().height() - bTree.right().height()) <= 1){
            return isBalanced(bTree.left()) && isBalanced(bTree.right());
        }
        else return false;
    }
//=============================================================================



    public static void main( String [] args )
    {
        Scanner in = new Scanner( System.in );

        int i = in.nextInt();

        BinaryTree newBT = makeBT(i);

        boolean balanced = isBalanced(newBT);

        if (balanced) {
            System.out.println("Tree is balanced");
        }
        else {
            System.out.println("Tree is not balanced");
        }

        in.close();

        System.out.print("END OF OUTPUT");
    }

    public static BinaryTree makeBT(int n)
    {
        BinaryTree b;
        if ((n>0) && (n%3==0))
        {
            b = new BinaryTree(n,makeBT(n-1),makeBT(n-2));
        }
        else if (n>0)
        {
            b = new BinaryTree(n,makeBT(n-2),null);
        }
        else
        {
            b = new BinaryTree(n,null,null);
        }

        return b;

    }

// WRITE YOUR CODE HERE
}
