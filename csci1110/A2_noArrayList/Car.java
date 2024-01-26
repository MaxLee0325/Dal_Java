package csci1110.A2_noArrayList;

import java.util.Arrays;

public class Car {
    private String[] cars;
    private String[][] cars2D;
    private String temp;

    public Car(){
    }

    public String[] getCars(){
        return cars;
    }
    public String[][] getCars2D(){
        return cars2D;
    }

    /**
     * This method takes in the input of cars, and the array of car models, then create another array combines the car models with plate number
     * @param input the user input begins with "CAR"
     * @param models the array of car models
     * @return the array contains car models and plates
     */
    public String[] setCars(String input, String[] models){
        temp += input;
        String[] tempCars = temp.split("CAR ");
        cars = new String[tempCars.length-1];
        for(int i = 0; i < cars.length; i++){
            cars[i] = tempCars[i+1];
        }
        for(int i = 0; i < cars.length; i++){
            String[] tempCar = cars[i].split(" ");
            for(int j = 0; j < models.length; j++){
                String[] tempModels = models[j].split(" ");
                if(tempCar[0].equals(tempModels[0])){
                    cars[i] += (" "+ tempModels[1] + " " + tempModels[2]);
                }
            }
        }
        return cars;
    }

    /**
     * This method takes in the array of car information and convert it into a 2-D array with outer array of different cars and inner array of detailed information
     * @param arrOfCars the array of every car listed
     * @return the 2-D array of cars and detailed information to be calculated
     */
    public String[][] GetCarInfo(String[] arrOfCars){
        //System.out.println(Arrays.toString(arrOfCars));
        cars2D = new String[arrOfCars.length][4];
        for(int i = 0; i < cars2D.length; i++){
            cars2D[i] = arrOfCars[i].split(" ");
        }
        return cars2D;
    }

    /**
     * toString method
     * @return the string of 2-D array
     */
    public String toString(){
        return Arrays.deepToString(cars2D);
    }
}
