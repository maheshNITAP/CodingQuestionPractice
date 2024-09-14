package CopmaratorOrComparable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SortExample {
 public static void main(String args[]){

//     we will use collections.sort method fro both
     //Comparable implemented on Employee class--comparable implemented on class
     ArrayList<Emp> emp= new ArrayList<>();
     emp.add(new Emp(5,"Mahesh","911912234"));
     emp.add(new Emp(2,"Mahesh","8922345438"));
     emp.add(new Emp(6,"Ravi","853748764574"));
     emp.add(new Emp(1,"Akash","7463534853"));

     System.out.println(emp);

     Collections.sort(emp);
     System.out.println("Sorted by Id by Comparable"+ emp);

     //comparator--for comparator we need to make separate class
     ArrayList<Employee> emp1=new ArrayList<>();
     emp1.add(new Employee(9,"Ravi","91191912344"));
     emp1.add(new Employee(6,"Kisan","8437563657"));
     emp1.add(new Employee(8,"Hari","9363436453"));
     emp1.add(new Employee(7,"Lal","7845362544"));
     System.out.println(emp1);
     //sort by eId
     Collections.sort(emp1,new IdComparator());
     System.out.println( "sorted by Id by comparator"+emp1);

     //sort by eName
     ArrayList<Employee> emps1= new ArrayList<>(emp1);
     Collections.sort(emps1,new NameComparator());
     System.out.println("Sorted by Name by Comparator"+emps1);

 }

}
