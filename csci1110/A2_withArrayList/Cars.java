package csci1110.A2_withArrayList;

public class Cars {
    private String brand;
    private String plate;
    private String eco;
    private String tank;

    public Cars(){}

    public void SetBrand(String in){ brand = in; }
    public void SetPlate(String in){ plate = in; }
    public void SetEco(String in){ eco = in; }
    public void SetTank(String in){ tank = in; }

    public String GetBrand(){ return brand; }
    public String GetPlate(){ return plate; }
    public String GetEco(){ return eco; }
    public String GetTank(){ return tank; }
}
