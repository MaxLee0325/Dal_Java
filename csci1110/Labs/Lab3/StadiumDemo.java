package csci1110.Labs.Lab3;

import java.util.Scanner;
import java.text.DecimalFormat;

public class StadiumDemo {
    public static void main (String [] args){
        Scanner in = new Scanner(System.in);
        String sta = in.next();
        int max = in.nextInt();
        int toS = in.nextInt();
        int num = in.nextInt();
        Event event;
        Stadium stadium = new Stadium(sta, max, toS);

        String name = "";
        double price = 0;
        int sales = 0;

        for(int i = 0; i < num; i++){
            name = in.next();
            price = in.nextDouble();
            sales = in.nextInt();
            event = new Event(name, price, sales);
            stadium.addEvent(event);
        }

        System.out.println(stadium.toString());

        for(Event i : stadium.getEvents()){
            if(i != null){
                System.out.println(i.toString());
            }
        }

        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Revenue: $" + df.format(stadium.getRevenue()));
    }
}