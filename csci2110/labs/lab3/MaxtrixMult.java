package csci2110.labs.lab3;
/*
Matrix Solution
*/
import java.util.*;
public class MaxtrixMult {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long startTime, endTime, executionTime;
        int dimensions;
        double value = 1;
        //use 0 as a stop sign
        while(value != 0){
            dimensions = in.nextInt();
            value = in.nextDouble();
            double[][] matrix = new double[dimensions][dimensions];
            for(int i = 0; i < dimensions; i++){
                for(int j = 0; j < dimensions; j++){
                    matrix[i][j] = value;
                }
            }
            startTime = System.currentTimeMillis();
            double[][] m3 = multiplyMatrix(matrix, matrix);
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;
            System.out.printf("Size: %d Time: %d ms\n", dimensions, executionTime);
        }
        in.close();
    }

    public static double[][] multiplyMatrix(double[][] m1, double[][] m2){
        double[][] m3 = new double[m1.length][m1.length];
        for(int i = 0; i < m1.length; i++){
            for(int j = 0; j < m1.length; j++){
                //initialize the output matrix
                m3[i][j] = 0;
                for(int m = 0; m < m1.length; m++){
                    //matrix calculation
                    m3[i][j] += m1[i][m] * m2[m][j];
                }
            }
        }
        return m3;
    }
}
