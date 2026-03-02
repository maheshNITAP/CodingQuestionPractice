package Comparable;

public class Student implements Comparable<Student>{
    private int rollNo;
    private String name;

    private int standard;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String phone;

    public Student(int rollNo, String name, int standard, String phone) {
        this.rollNo = rollNo;
        this.name = name;
        this.standard = standard;
        this.phone = phone;
    }

    @Override
    public int compareTo(Student o){
//        return this.rollNo-o.rollNo;//ascending order
         return o.rollNo-this.rollNo;//descending order
    }


}
