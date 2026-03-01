package LLD.builderDesignPattern;

import java.util.List;

public class Student {
    private int rollNumber;
    private int age;

    private String name;

    private String fatherName;

    private String motherName;

    private String mobileNumber;

    private List<String> subjects;

    public Student(StudentBuilder builder){
        this.rollNumber = builder.rollNumber;
        this.age = builder.age;
        this.name = builder.name;
        this.fatherName = builder.fatherName;
        this.motherName = builder.motherName;
        this.mobileNumber = builder.mobileNumber;
        this.subjects = builder.subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber=" + rollNumber +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
