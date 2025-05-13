package CopmaratorOrComparable;

public class Emp implements Comparable<Emp>{

    private int eId;
    private String name;
    private String phone;

    public Emp(int eid,String name,String phone){
        this.eId=eid;
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
        return "Emp{" +
                "eId=" + eId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public int compareTo(Emp o) {
        return this.eId-o.eId;
    }
}
