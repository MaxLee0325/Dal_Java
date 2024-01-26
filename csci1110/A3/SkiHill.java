package csci1110.A3;

import java.util.*;

public class SkiHill {
    private String name;
    private ArrayList<SkiRun> skiRuns = new ArrayList<>();

    public SkiHill(String name){
        this.name = name;
    }

    public String getName(){return name;}
    public ArrayList<SkiRun> getSkiRuns(){return skiRuns;}

    public void addSkiRun(SkiRun newRun){
        skiRuns.add(newRun);
    }

    public int numberSkiRuns(){
        return skiRuns.size();
    }

    public void openHill(){
        for(SkiRun i : skiRuns){
            i.openRun();
        }
    }

    public void closeHill(){
        for(SkiRun i : skiRuns){
            i.closeRun();
        }
    }

    public int numberOpenRuns(){
        return (int)skiRuns.stream().filter(x -> x.isOpen()).count();
    }

    public int numberClosedRuns(){
        return (int)skiRuns.stream().filter(x -> !x.isOpen()).count();
    }

    public ArrayList<SkiRun> getOpenRuns(){
        ArrayList<SkiRun> openRuns =  new ArrayList<>();
        skiRuns.stream().filter(x -> x.isOpen()).forEach(x -> openRuns.add(x));
        return openRuns;
    }

    public ArrayList<SkiRun> getClosedRuns(){
        ArrayList<SkiRun> closedRuns =  new ArrayList<>();
        skiRuns.stream().filter(x -> !x.isOpen()).forEach(x -> closedRuns.add(x));
        return closedRuns;
    }
}