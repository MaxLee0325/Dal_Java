package csci1110.A1;

import java.util.*;
public class A1P1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        for(int i = 0; i < n; i++){
            int normalHour = in.nextInt();
            int normalWage = in.nextInt();
            int extraWage = in.nextInt();
            int actualHour = in.nextInt();
            if(actualHour <= normalHour){
                sum += actualHour * normalWage;
            }
            else{
                sum += normalHour * normalWage + (actualHour - normalHour) * extraWage;
            }
        }
        System.out.println(sum);

    }
}
