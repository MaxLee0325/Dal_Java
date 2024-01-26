package csci2110.labs.lab3;
/*
Prime Solution
*/
/**
 This class tests the code for Exercise1. It calls a method to calculate the nth prime and prints information about running time. */
import java.util.*;
public class Prime{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long nthPrime = in.nextLong();
        //use 0 as a stop sign
        while(nthPrime != 0){
            long starTime, endTime, executionTime;
            starTime = System.currentTimeMillis();
            System.out.print(nthPrime + " " + nthPrime(nthPrime) + " ");
            endTime = System.currentTimeMillis();
            executionTime = endTime - starTime;
            System.out.println(executionTime);
            nthPrime = in.nextLong();
        }
        in.close();
    }
    public static long nthPrime(long p){
        boolean found = false;
        int nth = 0;
        long num = 2;
        while(!found){
            boolean prime = true;
            //loop through each integer before squareroot of the number, if divides then it's not prime
            for(int i = 2; i <= Math.sqrt(num); i++){
                if(num%i == 0){
                    prime = false;
                }
            }
            num++;
            if(prime){
                nth++;
            }
            if(nth == p){
                found = true;
            }
        }
        return num - 1;
    }
}
