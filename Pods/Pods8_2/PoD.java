package Pods.Pods8_2;

import java.util.*;

public class PoD
{
    public static void main( String [] args )
    {
        Scanner in = new Scanner( System.in );
        GroceryLine groceryLine = new GroceryLine();

        //Read in initial line of customers

        String inputLine1 = in.nextLine();
        String[] initialLine = inputLine1.split(",");

        for (int i=0; i<initialLine.length; i++)
        {
            String[] personDetails = initialLine[i].split(" ");

            Person nextPerson = new Person(personDetails[0],personDetails[1]);
            groceryLine.newCustomer(nextPerson);
        }

        System.out.println("--- INITIAL GROCERY LINE ---");
        System.out.println(groceryLine);

        //Modify initial line of customers

        String inputLine2 = in.nextLine();
        String[] tasks = inputLine2.split(",");
        int lastTask = tasks.length;
        Person lastCustomer = null;

        for (int i=0; i<lastTask; i++)
        {
            if (tasks[i].equals("first"))
            {
                //Next Customer
                lastCustomer = groceryLine.nextCustomer();
            }
            else if (tasks[i].equals("last"))
            {
                //New Cashier
                lastCustomer = groceryLine.newCashier();
            }
            else
            {
                //New customer
                String[] personDetails = tasks[i].split(" ",2);
                lastCustomer = new Person(personDetails[0],personDetails[1]);
                groceryLine.newCustomer(lastCustomer);
            }

        }

        System.out.println("Last person to enter/leave line:");
        System.out.println(lastCustomer);
        System.out.println("--- FINAL GROCERY LINE ---");
        System.out.println(groceryLine);



        in.close();
        System.out.print("END OF OUTPUT");

    }
}