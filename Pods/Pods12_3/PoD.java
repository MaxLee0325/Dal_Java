package Pods.Pods12_3;

/**
 * CSCI 1110
 * @author ASiegel, YourName
 */

import java.util.*;

public class PoD
{

//=============================================================================
    /**
     * Returns true if the game tree (binary tree) can be won
     * where the last player to move wins
     * @param bTree BinaryTree of interest
     * @return
     */

    public static boolean gameCanBeWon(BinaryTree bTree) {
        boolean canWin = true;
        if(bTree.left().isEmpty() && bTree.right().isEmpty()){
            return false;
        }

        if(gameCanBeWon(bTree.left()) && gameCanBeWon(bTree.right())){
            return false;
        }

        if (!(bTree.left().isEmpty() && bTree.right().isEmpty()) &&
                !(gameCanBeWon(bTree.left()) && gameCanBeWon(bTree.right()))){
            return true;
        }

        canWin = gameCanBeWon(bTree.left()) || gameCanBeWon(bTree.right());
        return canWin;
    }
//=============================================================================


    public static void main( String [] args ) {

        Scanner in = new Scanner( System.in );

        int i = in.nextInt();

        BinaryTree newBT = makeBT(i);

        boolean canBeWon = gameCanBeWon(newBT);

        if (canBeWon) {
            System.out.println("You can win!"); //if you play perfectly!
        }
        else {
            System.out.println("You can not win this game"); //Under perfect play!
        }

        in.close();

        System.out.print("END OF OUTPUT");
    }





    public static BinaryTree makeBT(int n)
    {
        BinaryTree b;
        if (n>0)
        {
            b = new BinaryTree(n,makeBT(n-1),makeBT(n-2));
            //System.out.println(n+":"+(n-1)+"|"+(n-2));
        }
        else
        {
            b = new BinaryTree(0,null,null);
            //System.out.println(n+":null|null");
        }

        return b;

    }
}