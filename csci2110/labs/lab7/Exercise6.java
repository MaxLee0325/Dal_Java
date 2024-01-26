package csci2110.labs.lab7;

import java.util.*;
public class Exercise6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a positive integer: ");
        int n = in.nextInt();
        System.out.printf("Squares(%d) would return: %d", n, squares(n));
    }

    public static int squares(int n) {
        if(n == 1) return 1;
        else return n*n + squares(n - 1);
    }
}
