package csci2110.labs.lab7;

import java.util.*;
public class Exercise7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a positive integer: ");
        int n = in.nextInt();
        long startTime, endTime, executionTime;
        startTime = System.currentTimeMillis();
        System.out.println("Number of moves: " + solve(n, 1, 3, 2));
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Runtime: " + executionTime);
    }


    static long count = 0;
    public static long solve(int n, int start, int end, int temp) {
        if(n > 0){
            solve(n-1, start, temp, end);
            //System.out.printf("Move %d, from %d to %d.\n", n, start, end);
            count++;
            solve(n - 1, temp, end, start);
        }
        return count;
    }
}
