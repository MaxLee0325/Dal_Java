package csci2110.labs.lab3;
/*
Matrix Solution
Considering the number of sample inputs and outputs becomes larger,
I decided to use lists to record the inputs as well as the outputs.
This makes plotting easier.
*/
import java.util.*;
public class Binary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long startTime, endTime, executionTime;
        //Use two linkedlists to store the input integer and output time, for plot convenience
        LinkedList<Integer> input = new LinkedList<>();
        LinkedList<Long> output = new LinkedList<>();
        int pow = in.nextInt();
        //input ends with sign number 0
        while(pow != 0){
            input.add(pow);
            startTime = System.currentTimeMillis();
            //method call
            generateBinary(pow);
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;
            //System.out.printf("Time: %d\n", executionTime);
            output.add(executionTime);
            pow = in.nextInt();
        }
        System.out.println("Input samples: ");
        for(Integer i : input){
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println("Time spent for each run: ");
        for(Long i : output){
            System.out.print(i + ", ");
        }
        in.close();
    }
    public static void generateBinary(int n){
        int result = (int)Math.pow(2, n);
        for(int i = 0; i < result; i++){
            Integer.toBinaryString(i);
        }
    }
}
