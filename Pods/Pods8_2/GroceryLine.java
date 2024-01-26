package Pods.Pods8_2;

import java.util.*;

public class GroceryLine
{
    //attributes
    protected LinkedList<Person> groceryLine = new LinkedList<Person>();

    public GroceryLine(){}

    public Person nextCustomer(){
        Person a = groceryLine.getFirst();
        groceryLine.removeFirst();
        return a;
    }

    public void newCustomer(Person person){
        groceryLine.add(person);
    }

    public Person newCashier(){
        Person b = groceryLine.getLast();
        groceryLine.removeLast();
        return b;
    }

    public String toString()
    {

        String lineMembers = "GROCERY LINE:\n";
        int lineCount = 0;

        for (Person person: groceryLine)
        {
            lineCount++;
            lineMembers += lineCount + ". " + person.toString();
        }
        return lineMembers;
    }
}
