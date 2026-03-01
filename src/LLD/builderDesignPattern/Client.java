package LLD.builderDesignPattern;

public class Client {
    public static void main(String[] args){
        Director mbaStudent = new Director(new MbaStudentBuilder());
        Director engineeringStudent = new Director(new EngineeringStudentBuilder());

        Student mbaStu = mbaStudent.createStudent();
         Student engStu= engineeringStudent.createStudent();
        System.out.println(mbaStu.toString());
        System.out.println(engStu.toString());
    }
}
