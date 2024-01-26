package csci1110.A2_withArrayList;

public class CarModel {
    private String brand;
    private String eco;
    private String tank;
    public CarModel(){}

    public void SetBrand(String in){ brand = in; }
    public void SetEco(String in){ eco = in; }
    public void SetTank(String in){ tank = in; }

    public String GetBrand(){ return brand; }
    public String GetEco(){ return eco; }
    public String GetTank(){ return tank; }

    public String toString(){
        return brand + " " + eco + " " + tank;
    }
}
