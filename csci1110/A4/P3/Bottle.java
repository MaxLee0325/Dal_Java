package csci1110.A4.P3;

/*
Student name: Yongteng Li
Student id: B00940715
Email: yn201290@dal.ca
Course: csci1110 section03
Instructor: Yujie Tang
Date: 29 Mar 2023
*/
import java.util.ArrayList;

public class Bottle {
    //instance variables
    private int row;
    private int col;
    private String message;
    private String name;
    private boolean disable = false;
    private ArrayList<String> record;

    //constructor
    public Bottle(int row, int col, String name){
        this.row = row;
        this.col = col;
        this.name = name;
        record = new ArrayList<>();
    }

    //method to set the message, used to update read in the message
    public void setMessage(String message){
        this.message = message;
    }

    //method to set the row, used to update the position
    public void setCol(int col){
        this.col = col;
    }

    //method to set the row, used to update the position
    public void setRow(int row){
        this.row = row;
    }

    //getter methods to obtain information
    public String getMessage(){return message;}
    public int getRow(){return row;}
    public int getCol(){return col;}
    public String getName(){return name;}
    public boolean getState(){return disable;}
    public ArrayList<String> getRecord(){return record;}

    /**
     * getDirection method takes in the oceans map, and using the row and col to get the bottles' direction
     * @param oceans the 2-D array of the map
     * @return a string of the direction
     */
    public String getDirection(Ocean[][] oceans){
        return oceans[row][col].getDirection();
    }

    /**
     * update method takes in the direction of the bottle, and make a move according to the direction
      * @param direction the string that indicates the direction
     */
    public void update(String direction){
        if(direction.equals("E"))
            this.setCol(this.getCol()+1);
        else if(direction.equals("W"))
            this.setCol(this.getCol()-1);
        else if(direction.equals("N"))
            this.setRow(this.getRow()-1);
        else this.setRow(this.getRow()+1);
    }

    /**
     * disable method set the disable boolean into true
      */
    public void disable(){
        disable = true;
    }

    /**
     * addRecord method takes in the coordinates and add the coordinates into an arraylist
      * @param row the current row
     * @param col the current col
     */
    public void addRecord(int row, int col){
        String position = row + "," + col;
        record.add(position);
    }

    /**
     * toString method
      * @return the sentence
     */
    public String toString(){
        return name + ": Starting at (" + row + ", " + col + ")";
    }
}


