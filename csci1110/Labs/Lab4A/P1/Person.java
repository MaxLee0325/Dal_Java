package csci1110.Labs.Lab4A.P1;

public class Person {
    protected String name;

    public Person(String name){
        this.name = name;
    }

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public boolean isSame(Person person){
        if(name.equals(person.getName())){
            return true;
        }
        else return false;
    }

    public String toString(){
        return "Name: " + name;
    }
}
