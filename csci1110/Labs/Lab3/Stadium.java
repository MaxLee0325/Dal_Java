package csci1110.Labs.Lab3;

public class Stadium {
    private String name;
    private int totalSeats;
    private int maxEvents;
    private int currEvents;
    private Event[] events;

    public Stadium(String name, int maxEvents, int totalSeats){
        this.name = name;
        this.maxEvents = maxEvents;
        this.totalSeats = totalSeats;
        this.currEvents = 0;
        this.events = new Event[maxEvents];
    }

    public int getTotalSeats(){return totalSeats;}
    public int getMaxEvents(){return maxEvents;}
    public String getName(){return name;}
    public Event[] getEvents(){return events;}

    public void setName(String name){this.name = name;}

    public double getRevenue(){
        double r = 0;
        for(Event i : events){
            if(i != null)
                r += (i.getPrice() * i.getSales());
        }
        return r;
    }

    public boolean addEvent(Event event){
        if(currEvents < maxEvents){
            events[currEvents] = event;
            currEvents++;
            return true;
        }
        else return false;
    }

    public String toString(){
        return name + " Seats: " + totalSeats + " Events: " + currEvents;
    }
}
