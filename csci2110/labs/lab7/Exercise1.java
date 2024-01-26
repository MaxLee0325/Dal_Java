package csci2110.labs.lab7;

import java.util.*;
public class Exercise1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Factorial of a number\nEnter a positive integer: ");
        int fac = in.nextInt();
        System.out.printf("The factorial of %d is %d\n\n", fac, Factorial(fac));

        System.out.println("Fibonacci of a number\nEnter a positive integer: ");
        int fib = in.nextInt();
        System.out.printf("The first %d numbers in the Fibonacci series are:\n", fib);
        for(int i = 0; i < fib; i++) {
            if(i == fib -1) System.out.print(Fibonacci(i) + "\n\n");
            else System.out.print(Fibonacci(i) + ", ");
        }

        System.out.println("Power of a number\nEnter a positive integer x: ");
        int x = in.nextInt();
        System.out.println("Enter a positive integer n: ");
        int n = in.nextInt();
        System.out.printf("%d to the power of %d is %d\n", x, n, Expo(x, n));
        in.close();
    }

    public static int Factorial(int n){
        if(n == 0) return 1;
        else return n * Factorial(n - 1);
    }

    public static int Fibonacci(int n){
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else return Fibonacci(n - 2) + Fibonacci(n -1);
    }

    public static int Expo(int x, int n){
        if(n == 0) return 1;
        else return x * Expo(x, n - 1);
    }
}
