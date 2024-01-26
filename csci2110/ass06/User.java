package csci2110.ass06;

public class User {

    private String actualName;
    private String userName;
    private String password;

    public User(String actualName, String userName, String password){
        this.actualName = actualName;
        this.userName = userName;
        this.password = password;
    }

    public String getActualName(){return actualName;}
    public String getUserName(){return userName;}
    public String getPassword(){return password;}

}
