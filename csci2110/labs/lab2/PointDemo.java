package csci2110.labs.lab2;
import java.util.*;

public class PointDemo {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Point<Integer> point1 = new Point<Integer>(in.nextInt(), in.nextInt());
        Point<Double> point2 = new Point<Double>(in.nextDouble(), in.nextDouble());
        Point<String> point3 = new Point<String>(in.next(), in.next());
        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point3);
    }
}

