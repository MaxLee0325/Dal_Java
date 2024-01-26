package csci1110.A2_noArrayList;

public class CarModel {

    private String[] modelArray;
    private String temp;
    public CarModel(){
    }

    public String[] getModels(){
        return modelArray;
    }

    /**
     * This method takes in the input starts with "MODEL", and convert it into an arry to store the models
     * @param input the user input begins with "MODEL"
     * @return the array consisted of car models
     */
    public String[] setModelArray(String input){
        temp += input;
        String[] tempArr = temp.split("MODEL ");
        modelArray = new String[tempArr.length-1];
        for(int i = 0; i < modelArray.length; i++){
            modelArray[i] = tempArr[i+1];
        }
        return modelArray;
    }
}
