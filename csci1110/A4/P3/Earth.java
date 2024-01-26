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

public class Earth {
    //instance variables
    private int row;
    private int col;
    private Ocean[][] oceans;
    private ArrayList<Ocean> oceanList;

    //constructor
    public Earth(int row, int col){
        this.row = row;
        this.col = col;
        this.oceanList = new ArrayList<>();
    }

    //method that creates a 2-D array of Ocean object using the row and col variables
    public void setEarth(){
        oceans = new Ocean[row][col];
    }

    //getter method to get the 2-D array
    public Ocean[][] getEarth(){return oceans;}

    /**
     * getOceanList method looks through the map and add the ocean blocks into an arraylist
      * @return the arraylist of all the ocean blocks
     */
    public ArrayList<Ocean> getOceanList(){
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (oceans[i][j] == null) {
                    oceans[i][j] = new Ocean();
                    oceanList.add(oceans[i][j]);
                }
            }
        }
        return oceanList;
    }

    /**
     * addland method takes in a coordinate and set that position into land
      * @param row the current row
     * @param col the current col
     */
    public void addLand(int row, int col){
        oceans[row][col] = new Ocean();
        oceans[row][col].setDirection("X");
    }
}
