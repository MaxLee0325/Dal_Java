package csci2110.labs.lab2;

public class StudentRecord {
    private String firstName, lastName;
    private int bannerID;

    public StudentRecord(String firstName, String lastName, int bannerID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.bannerID = bannerID;
    }

    public void setFirstName(String firstName){this.firstName = firstName;}
    public void setLastName(String lastName){this.lastName = lastName;}
    public void setBannerID(int bannerID){this.bannerID = bannerID;}

    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public int getBannerID(){return bannerID;}

    public String toString(){
        return String.format("Student name: %s %s, ID: %d", firstName, lastName, bannerID);
    }

}
