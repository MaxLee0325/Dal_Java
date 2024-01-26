package csci2110.ass02;
/**
 * student name: Yongteng Li
 * id: B00940715
 * course: csci2110
 */

import java.util.*;
public class Cousin {
    //variable length should be static and has a higher scope
    private static int length;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //continue input until input is 0
        while(n != 0) {
            long startTime, endTime, executionTime;
            //start the timer
            startTime = System.currentTimeMillis();
            //keep record of the max length in each computing
            int maxLen = 1;
            //keep record of the target integer that makes the longest sequence
            int target = 0;
            //start from 1 until our input integer compute the length of each integer
            for (int i = 1; i <= n; i++) {
                length  = 1;
                colCousin(i);
                //find out the integer with the largest length
                if(length > maxLen){
                    maxLen = length;
                    target = i;
                }
            }
            //calculate the time
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;
            //print the result
            System.out.println(n + " " + target + " " + maxLen + " " + executionTime);
            //continue inputting
            n = in.nextInt();
        }
    }

    /**
     * The method calculates the collatzCousin sequence of an integer
     * @param in the integer to be computed
     */
    public static void colCousin(long in){
        while(in != 1){
            length++;
            if(in%2 == 0)
                in /= 2;
            else if(in%4 == 1){
                in = in*7 + 1;
            }
            else if(in%4 == 3){
                in = in*7 - 1;
            }
        }
    }
}


