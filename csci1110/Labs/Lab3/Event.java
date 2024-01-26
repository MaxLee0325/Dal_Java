package csci1110.Labs.Lab3;

import java.text.DecimalFormat;

public class Event {
    private String type;
    private double price;
    private int sales;

    public Event(String type, double price, int sales){
        this.type = type;
        this.price = price;
        this.sales = sales;
    }

    public String getType(){return type;}
    public double getPrice(){return price;}
    public int getSales(){return sales;}

    public void setType(String type){this.type = type;}
    public void setPrice(double price){this.price = price;}
    public void setSales(int sales){this.sales += sales;}

    public boolean moreSales(Event newEvent){
        if(this.sales > newEvent.getSales())
            return true;
        else return false;
    }

    public String toString(){
        DecimalFormat df = new DecimalFormat("0.00");
        return "Event: " + type + " Price: $" + df.format(price) + " Sales: " + sales;
    }
}