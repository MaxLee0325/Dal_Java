package csci2110.labs.lab7;

import java.util.*;
public class Exercise5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a positive integer: ");
        int n = in.nextInt();
        writeVertical(n);
    }

    public static int writeVertical(int n) {
        int t;
        if(n/10 == 0) {
            System.out.println(n%10);
            return n % 10;
        }
        else{
            t = writeVertical(n/10);
            System.out.println(n%10);
            return t;
        }
    }
}
