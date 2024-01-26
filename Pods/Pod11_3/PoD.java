package Pods.Pod11_3;

/**
 * CSCI 1110
 * @author ASiegel
 */

import java.util.*;

public class PoD
{

    public static void main( String [] args )
    {
        Scanner in = new Scanner( System.in );

        final int N = in.nextInt();
        final int K = in.nextInt();

        System.out.println("n:      " + N);
        System.out.println("k:      " + K);
        System.out.println("C(n,k): " + combination(N,K));

        in.close();

        System.out.print("END OF OUTPUT");
    }

    public static int combination(int n, int k){
        if(n == 1 || k == 0 || n == k)
            return 1;
        else
            return combination(n-1, k-1) + combination(n-1, k);
    }

}