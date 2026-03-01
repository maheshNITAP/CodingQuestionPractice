package LLD.builderDesignPattern;

import java.util.List;

public abstract class StudentBuilder {
    protected int rollNumber;
    protected int age;

    protected String name;

    protected String fatherName;

    protected String motherName;

    protected String mobileNumber;

    protected List<String> subjects;

    public StudentBuilder setRollNumber(int rollNumber){
        this.rollNumber = rollNumber;
        return this;
    }

    public StudentBuilder setAge(int age){
        this.age=age;
        return this;
    }

    public StudentBuilder setName(String name){
        this.name=name;
        return this;
    }

    public StudentBuilder setFatherName(String fatherName){
        this.fatherName=fatherName;
        return this;
    }

    public StudentBuilder setMotherName(String motherName){
        this.motherName=motherName;
        return this;
    }

    public StudentBuilder setMobileNumber(String mobileNumber){
        this.mobileNumber=mobileNumber;
        return this;
    }

    abstract public StudentBuilder setSubjects();

    public Student build(){
        return new Student(this);
    }
}
