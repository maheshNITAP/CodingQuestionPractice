package CopmaratorOrComparable;

public class Employee {
    private int eId;
    private String name;
    private String phone;

    public Employee(int eId,String name, String phone){
        this .eId=eId;
        this.name=name;
        this.phone=phone;
    }

    public int geteId() {
        return eId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId=" + eId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
