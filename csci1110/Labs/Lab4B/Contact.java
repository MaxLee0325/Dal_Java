package csci1110.Labs.Lab4B;

public class Contact implements Comparable<Contact>{
    private String lastName;
    private String firstName;
    private String streetName;
    private String phoneNumber;

    public Contact(String lastName, String firstName, String streetName, String phoneNumber){
        this.lastName = lastName;
        this.firstName = firstName;
        this.streetName = streetName;
        this.phoneNumber = phoneNumber;
    }

    public String getLastName(){return lastName;}
    public String getFirstName(){return firstName;}
    public String getStreetName(){return streetName;}
    public String getPhoneNumber(){return phoneNumber;}

    public String toString(){
        return lastName + ", " + firstName + ": " + streetName + ", " + phoneNumber;
    }

    public boolean equals(Contact newContact){
        if(lastName.equals(newContact.getLastName()) && firstName.equals(newContact.getFirstName()) &&
                streetName.equals(newContact.getStreetName()) && phoneNumber.equals(newContact.getPhoneNumber())){
            return true;
        }
        else return false;
    }

    public int compareTo(Contact newContact){
        if(lastName.charAt(0) - newContact.lastName.charAt(0) != 0)
            return lastName.charAt(0) - newContact.lastName.charAt(0);
        else if(firstName.charAt(0) - newContact.firstName.charAt(0) != 0)
            return firstName.charAt(0) - newContact.firstName.charAt(0);
        else if(streetName.charAt(0) - newContact.streetName.charAt(0) != 0)
            return streetName.charAt(0) - newContact.streetName.charAt(0);
        else return phoneNumber.charAt(0) - newContact.phoneNumber.charAt(0);
    }
}

