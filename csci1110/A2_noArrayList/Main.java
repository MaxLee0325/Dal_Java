package csci1110.A2_noArrayList;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        long time0 = System.nanoTime();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        CarModel carModels = new CarModel();
        Car cars = new Car();
        String[] details = input.trim().split(" ");
        //keep reading until TRIP starts
        while (details[0].equals("CAR") || details[0].equals("MODEL")) {
            //when read in MODEL, store the info of the models
            if (details[0].equals("MODEL")) {
                carModels.setModelArray(input);
            }
            //when read in CAR, store the info of cars
            else if (details[0].equals("CAR")) {
                cars.setCars(input, carModels.getModels());
                //convert the car info into a 2-D array
                cars.GetCarInfo(cars.getCars());
            }
            //keep reading input
            input = in.nextLine();
            details = input.trim().split(" ");
        }
        //create a temporary array to store the original information of cars
        String[] temp = cars.getCars().clone();
        //create a 2-D array to be calculated and updated
        String[][] usage = cars.getCars2D();
        //create an arraylist to store the successful trips
        ArrayList<String> successfulTrips = new ArrayList<>();
        //keep reading until "FINISH"
        while(!input.equals("FINISH")){
            details = input.trim().split(" ");
            if (details[0].equals("TRIP")) {
                //convert the trips into array
                String[] trips = input.trim().split(" ");
                boolean match = false;
                //loop through the car info to match the trip and update the car information
                for(int i = 0; i < usage.length; i++){
                    if(usage[i][1].equals(trips[1])){
                        match = true;
                        usage[i][3] = Double.toString(Double.parseDouble(usage[i][3]) - Double.parseDouble(usage[i][2]) * Double.parseDouble(trips[2]) / 100);
                        if(Double.parseDouble(usage[i][3]) >= 0){
                            System.out.println("Trip completed successfully for #" + usage[i][1]);
                            //add the successful trips in an array list as string
                            successfulTrips.add(usage[i][1] + " " + trips[2]);
                        }
                        else{
                            System.out.println("Not enough fuel for #" + usage[i][1]);
                        }
                    }
                }
                //the case that has no matched cars
                if(!match){
                    System.out.println("Not enough fuel for #" + trips[1]);
                }
            }
            //when read in REFILL
            else if (details[0].equals("REFILL")) {
                String[] ref = input.split(" ");
                for(int i = 0; i < usage.length; i++){
                    if(usage[i][1].equals(ref[1])){
                        //since temp array is a copy of the original array, it can hold the original information of tank capacity
                        usage[i][3] = cars.GetCarInfo(temp)[i][3];
                    }
                }
            }
            //when read in "LONGTRIPS"
            else if (details[0].equals("LONGTRIPS")){
                //count the number of trips to be recorded
                int count = 0;
                //match the plate number and compare the distance
                for(String i : successfulTrips){
                    if(i.split(" ")[0].equals(details[1]) &&
                        Double.parseDouble(i.split(" ")[1]) >= Double.parseDouble(details[2] )){
                        count ++;
                    }
                }
                System.out.println("#" + details[1] + " made " + count + " trips longer than " + details[2]);
            }
            //keep reading input
            input = in.nextLine();
        }
        long time1 = System.nanoTime();
        System.out.println((time1-time0)/1000000);
    }
}
