package csci1110.A1;

import java.util.*;
public class A1P2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfEmployers = in.nextInt();
        String[][] str = new String[numOfEmployers][4];
        for (int i = 0; i < numOfEmployers; i++) {
            for (int j = 0; j < 4; j++) {
                str[i][j] = in.next();
            }
        }
        int normalHour = 0;
        int normalWage = 0;
        int extraWage = 0;
        int actualHour = 0;
        int sum = 0;

        for (int i = 0; i < numOfEmployers; i++) {
            for (int j = 0; j < 4; j++) {
                if (str[i][j].charAt(0) == 't') {
                    normalHour = Integer.parseInt(str[i][j].substring(2, str[i][j].length()));
                } else if (str[i][j].charAt(0) == 'T') {
                    actualHour = Integer.parseInt(str[i][j].substring(2, str[i][j].length()));
                } else if (str[i][j].charAt(0) == 'd') {
                    normalWage = Integer.parseInt(str[i][j].substring(2, str[i][j].length()));
                } else if (str[i][j].charAt(0) == 'D') {
                    extraWage = Integer.parseInt(str[i][j].substring(2, str[i][j].length()));
                }
            }

            if (actualHour <= normalHour) {
                sum += actualHour * normalWage;
            } else {
                sum += normalHour * normalWage + (actualHour - normalHour) * extraWage;
            }


        }
        String output = String.valueOf(sum) + " Dollars";
        StringBuilder stars = new StringBuilder();
        int starLen = digits(output);
        for (int i = 0; i < output.length(); i++) {
            stars = stars.append("*");
        }
        System.out.println(stars);
        System.out.println(output);
        System.out.println(stars);
    }

    public static int digits(String sentence){
        int numberOfStars = sentence.length();
        return numberOfStars;
    }
}
