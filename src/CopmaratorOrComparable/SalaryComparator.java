package CopmaratorOrComparable;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2){
//        return e2.getSalary()- e1.getSalary();//desc order
        return e1.getSalary()-e2.getSalary();
    }

}
