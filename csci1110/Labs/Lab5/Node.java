package csci1110.Labs.Lab5;

public class Node{
    //attributes
    private String carrier;
    private String infected;
    private Node next;

    //constructor
    public Node(String carrier, String infected, Node next){
        this.carrier = carrier;
        this.infected = infected;
        this.next = next;
    }
    //get and set methods
    public String getCarrier(){ return carrier;}
    public String getInfected(){ return infected;}
    public Node getNext(){ return next;}

    public void setCarrier(String c){ carrier = c;}
    public void setInfected(String i){ infected = i;}
    public void setNext(Node n){ next = n; }

    //toString
    public String toString(){
        return "[" + carrier + ", " + infected  + "]--> ";
    }
}

