package Pods.PraPra1;

public class Student {
    private String name;
    private int arrivalTime;

    public Student(int arrivalTime, String name){
        this.arrivalTime = arrivalTime;
        this.name = name;
    }

    public String getName(){return name;}
    public int getArrivalTime(){return arrivalTime;}
}
