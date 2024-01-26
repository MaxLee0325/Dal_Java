package csci1110.A2_withArrayList;
import java.util.*;
public class Main {
    public static void main(String[] args){
        long time0 = System.nanoTime();
        Scanner in = new Scanner(System.in);
        String input = in.next();
        //create a list of car models
        ArrayList<CarModel> models = new ArrayList<>();
        //create a list of cars
        ArrayList<Cars> cars = new ArrayList<>();
        //create a list of successful trips
        ArrayList<String[]> trips = new ArrayList<>();
        //read in the models and cars
        while(input.equals("MODEL") || input.equals("CAR")) {
            //identify the models and create a new instance of model
            if(input.equals("MODEL")) {
                CarModel carSpec = new CarModel();
                input = in.next();
                carSpec.SetBrand(input);
                input = in.next();
                carSpec.SetEco(input);
                input = in.next();
                carSpec.SetTank(input);
                //add the new instance into the list of models
                models.add(carSpec);
            }
            //identify the cars and create a new instance
            else if(input.equals("CAR")) {
                Cars car = new Cars();
                input = in.next();
                car.SetBrand(input);
                input = in.next();
                car.SetPlate(input);
                //add the new instance into the list o cars
                cars.add(car);
            }
            input = in.next();
        }
        //match the cars with the models
        for(Cars i : cars){
            for(CarModel j : models){
                //get the fuel information of cars from the models
                if(i.GetBrand().equals(j.GetBrand())){
                    i.SetEco(j.GetEco());
                    i.SetTank(j.GetTank());
                }
            }
        }
        //read in until finish
        while(!input.equals("FINISH")){
            //identify the trips
            if(input.equals("TRIP")){
                String plate = in.next();
                double distance = in.nextDouble();
                boolean match = false;
                //match the trips with the cars
                for(Cars i : cars){
                    if(i.GetPlate().equals(plate)){
                        match = true;
                        //calculate and update the fuel consumption
                        Double cons = Double.parseDouble(i.GetTank()) - Double.parseDouble(i.GetEco()) * distance / 100;
                        i.SetTank(Double.toString(cons));
                        if(cons >= 0){
                            //update the list of successful trips
                            String[] temp = new String[2];
                            temp[0] = i.GetPlate();
                            temp[1] = Double.toString(distance);
                            trips.add(temp);
                            System.out.println("Trip completed successfully for #" + i.GetPlate());
                        }
                        else
                            System.out.println("Not enough fuel for #" + i.GetPlate());
                    }
                }
                //for the cases that there is no matched cars
                if(!match){
                    System.out.println("Not enough fuel for #" + plate);
                }
            }
            //identify refill
            else if(input.equals("REFILL")){
                String plate = in.next();
                String capacity = "";
                //match the plate
                for(Cars i : cars){
                    if(i.GetPlate().equals(plate)){
                        String brand = i.GetBrand();
                        //find the car model by the plate
                        for(CarModel j : models){
                            if(j.GetBrand().equals(brand)){
                                capacity = j.GetTank();
                            }
                        }
                        //set the car tank back according to the information in the car models
                        i.SetTank(capacity);
                    }
                }
            }
            //identify input of long trips
            else if(input.equals("LONGTRIPS")){
                String plate = in.next();
                Double range = in.nextDouble();
                int count = 0;
                //match the plate in the list of trips
                for(String[] i : trips){
                    if(i[0].equals(plate)){
                        if(Double.parseDouble(i[1]) >= range){
                            count++;
                        }
                    }
                }
                System.out.println("#" + plate + " made " + count + " trips longer than " + range.intValue());
            }
            input = in.next();
        }
        long time1 = System.nanoTime();
        System.out.println((time1-time0)/1000000);
    }
}
