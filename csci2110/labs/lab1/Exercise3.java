package csci2110.labs.lab1;

import java.util.Scanner;
import java.util.stream.Stream;

public class Exercise3 {
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
        for(int i = 0; i < tests; i++) {
            //parse the string input into an array of integers
            double[] para = Stream.of(input[i].split("\s")).mapToDouble(Double::parseDouble).toArray();
            //apply the parameters to the rectangle1 and rectangle2
            Circle circle1 = new Circle(para[0], para[1], para[2]);
            Circle circle2 = new Circle(para[3], para[4], para[5]);
            //print the information of the rectangles
            System.out.println("Test case: " + (i + 1));
            System.out.println("The first Circle's centre is at: " + circle1.getXpos() + "," + circle1.getYpos());
            System.out.println("The first Circle's radius is: " + circle1.getRadius() + " units");
            System.out.println("The second Circle's centre is at: " + circle2.getXpos() + "," + circle2.getYpos());
            System.out.println("The second Circle's radius is: " + circle2.getRadius() + " units");
            //check and print if the circles contain and touch
            System.out.println("Second circle contained in first circle?: " + circle1.contains(circle2));
            System.out.println("Second circle touches first circle?: " + circle1.touches(circle2) + "\n");
        }
    }
}
