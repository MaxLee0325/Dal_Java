package csci2110.labs.lab4;

/*
This program runs section sort for four arrays with length of 100, 1000, 10000 and 100000
Some lines are commented out because they are there only to generate more samples for plot
 */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class SectionSort {
    public static void main(String[] args) {
        long start, end, duration;
        //LinkedList<Integer> input = new LinkedList<>();
        //LinkedList<Long> output = new LinkedList<>();
        for(int i = 1; i < 5; i++){
            //for(int i = 1; i < 40; i++){
            int n = (int)Math.pow(10, i + 1);
            //int n = 1 + 4000 * i;
            //input.add(n);
            int arr[] = new int[n];

            for(int j = 0; j < n; j++){
                double ratio = new Random().nextDouble();
                arr[j] = (int)(ratio * n);
            }

            start = System.currentTimeMillis();
            sort(arr);
            end = System.currentTimeMillis();
            duration = end - start;
            System.out.println(duration);
            //output.add(duration);
        }

//        for(int i = 0; i < 39; i++){
//            System.out.print(input.get(i) + ", ");
//        }
//        System.out.println();
//        for(int i = 0; i < 39; i++){
//            System.out.print(output.get(i) + ", ");
//        }
    }
    public static int[] sort(int[] arr){
        int len = arr.length;
        int tmp;
        for(int i = 0; i < len; i++){
            int min = arr[i];
            int idx = i;
            tmp = arr[i];
            for(int j = i + 1; j < len; j++){
                if(arr[j] < min){
                    min = arr[j];
                    idx = j;
                }
            }
            arr[i] = min;
            arr[idx] = tmp;
        }
        return arr;
    }
}