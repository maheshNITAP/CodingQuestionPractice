package CopmaratorOrComparable;

public class Employee {
    private int eId;
    private String name;
    private String phone;
    private int salary;

    private String department;

    public Employee(int eId,String name, String phone,int salary,String department) {
        this .eId=eId;
        this.name=name;
        this.phone=phone;
        this.salary=salary;
        this.department=department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId=" + eId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
