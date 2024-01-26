package Pods.PraPra;

// WRITE YOUR CODE HERE

public class Student {
    private String name;
    private int arrivingTime;
    private int demandingTime;
    private int leavingTime;

    public Student(String name, int arrivingTime, int demandingTime, int leavingTime){
        this.name = name;
        this.arrivingTime = arrivingTime;
        this.demandingTime = demandingTime;
        this.leavingTime = leavingTime;
    }

    public String getName(){return name;}
    public int getArrivingTime(){return arrivingTime;}
    public int getDemandingTime(){return demandingTime;}
    public int getLeavingTime(){return leavingTime;}
}

