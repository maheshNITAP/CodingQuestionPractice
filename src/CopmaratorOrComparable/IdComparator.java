package CopmaratorOrComparable;

import java.util.Comparator;

public class IdComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2){
        return e1.geteId()-e2.geteId();
    }
}
