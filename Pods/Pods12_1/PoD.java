package Pods.Pods12_1;

/**
 * CSCI 1110
 * @author ASiegel
 */

import java.util.*;

public class PoD
{

//=============================================================================
    /**
     * Returns true if the binary tree is a strict binary tree, in which
     * each node in the tree has either zero or two children.
     * @param bTree BinaryTree of interest
     * @return
     */

    public static boolean isStrictBinaryTree(BinaryTree bTree) {
        if(bTree == null){
            return true;
        }
        else if(!bTree.left().isEmpty() && !bTree.right().isEmpty()){
            return isStrictBinaryTree(bTree.left()) && isStrictBinaryTree((bTree.right()));
        }
        else if((bTree.left().isEmpty() && !bTree.right().isEmpty()) || (!bTree.left().isEmpty() && bTree.right().isEmpty())){
            return false;
        }
        else return true;
    }
//=============================================================================


    public static void main( String [] args )
    {

        Scanner in = new Scanner( System.in );

        int i = in.nextInt();
        int j = in.nextInt();

        BinaryTree newBT = makeBT(i,j);

        boolean isStrictBT = isStrictBinaryTree(newBT);

        if (isStrictBT) {
            System.out.println("Strict binary tree");
        }
        else {
            System.out.println("NOT a strict binary tree");
        }

        in.close();

        System.out.print("END OF OUTPUT");
    }





    public static BinaryTree makeBT(int n, int k)
    {
        BinaryTree b;
        if ((n>0) && (n%2==0))
        {
            b = new BinaryTree(n,makeBT(n-1,k),makeBT(n-2,k));
        }
        else if (n>0 & n%2==k) {
            b = new BinaryTree(n, null, makeBT(n - 2,k));
        }
        else
        {
            b = new BinaryTree(0,null,null);
        }

        return b;

    }
}
