package Comparator;

import java.util.Comparator;

public class IdComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2){
//        return e1.getId() - e2.getId();//ascending order
         return e2.getId() - e1.getId();//descending order
    }
}
