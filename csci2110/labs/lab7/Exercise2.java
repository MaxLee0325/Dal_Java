package csci2110.labs.lab7;

import java.util.*;
public class Exercise2 {
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a positive integer: ");
        int n = in.nextInt();
        countDown(n);
    }

    public static void countDown(int n) throws InterruptedException {
        if(n == 0) System.out.printf("BlastOff!");
        else {
            System.out.printf("%d     ", n);
            Thread.sleep(500);
            countDown(n - 1);
        }
    }
}
