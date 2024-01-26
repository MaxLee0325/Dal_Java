package csci2110.labs.lab1;

import java.util.Scanner;
import java.util.stream.Stream;

public class Exercise2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //read the number of tests
        int tests = in.nextInt(); in.nextLine();
        //create an array to store the inputs
        String[] input = new String[tests];
        for(int i = 0; i < tests; i++){
            input[i] = in.nextLine().trim() + "\s" + in.nextLine().trim();
        }

        //loop through the tests
        for(int i = 0; i < tests; i++){
            //parse the string input into an array of integers
            int[] para = Stream.of(input[i].split("\s")).mapToInt(Integer::parseInt).toArray();
            //apply the parameters to the rectangle1 and rectangle2
            Rectangle2 rec1 = new Rectangle2(para[0], para[1], para[2], para[3]);
            Rectangle2 rec2 = new Rectangle2(para[4], para[5], para[6], para[7]);
            //print the information of the rectangles
            System.out.println("Test case: " + (i + 1));
            System.out.println("Rectangle 1: " + rec1 + "\n" + "Rectangle 2: " + rec2);
            //check and print of the rectangles contain and touch
            System.out.println("Is Rectangle 2 contained in Rectangle 1? " + rec1.contains(rec2));
            System.out.println("Is Rectangle 2 touching Rectangle 1? " + rec1.touches(rec2) + "\n");
        }
    }
}
