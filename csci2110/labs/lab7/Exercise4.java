package csci2110.labs.lab7;

import java.util.*;
public class Exercise4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a positive integer x: ");
        int x = in.nextInt();
        System.out.println("Enter a positive integer n: ");
        int n = in.nextInt();
        multiplies(x, n);
    }

    public static int multiplies(int x, int n) {
        int t;
        if (n == 1) {
            System.out.printf("%d, ", x * n);
            return x * n;
        }
        else {
            t = x + multiplies(x, n - 1);
            System.out.printf("%d, ", t);
            return t;
        }
    }
}
