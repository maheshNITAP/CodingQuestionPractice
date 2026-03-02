package Comparator;

import java.util.Comparator;

public class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2){
//        return e1.getName().compareTo(e2.getName());//ascending order
        return e2.getName().compareTo(e1.getName());//descending order
    }
}
