package Pods.Pods8_2;

import java.util.*;

public class Person
{
    //attributes
    protected String firstName = null;
    protected String lastName = null;

    //constructor
    public Person(String first, String last)
    {
        this.firstName = first;
        this.lastName = last;
    }

    public String toString()
    {

        String personDetails = this.firstName + " " + this.lastName +"\n";
        return personDetails;
    }
}
