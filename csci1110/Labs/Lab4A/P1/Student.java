package csci1110.Labs.Lab4A.P1;

public class Student extends Person{
    private int StudentID;

    public Student(String name, int StudentID){
        super(name);
        this.StudentID = StudentID;
    }

    public void setStudentID(int id){StudentID = id;}
    public int getStudentID(){return StudentID;}

    public boolean isSame(Student student){
        if(StudentID == student.getStudentID()){
            return true;
        }
        else return false;
    }

    public String toString(){
        return ("Name: " + name + " StudentID: " + StudentID);
    }
}


