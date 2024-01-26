package csci2110.labs.lab1;
import java.util.*;
import java.util.stream.Stream;

public class Exercise1 {
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
            Rectangle1 rec1 = new Rectangle1(para[0], para[1], para[2], para[3]);
            Rectangle1 rec2 = new Rectangle1(para[4], para[5], para[6], para[7]);
            //print the information of the rectangles
            System.out.println("Test case: " + (i + 1));
            System.out.println("Rectangle 1: " + rec1 + "\n" + "Rectangle 2: " + rec2);
            //check and print if the rectangles contain
            System.out.println("Is Rectangle 2 contained in Rectangle 1? " + rec1.contains(rec2) + "\n");
        }
    }
}
