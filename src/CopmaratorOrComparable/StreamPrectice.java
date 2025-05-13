package CopmaratorOrComparable;

import java.util.*;
import java.util.stream.Collectors;

public class StreamPrectice {
    public static void main(String args[]){
        List<Employee> emp= new ArrayList<>();

        emp.add(new Employee(5,"Mahesh","911912234",10000));
        emp.add(new Employee(2,"Mahesh","8922345438",20000));
        emp.add(new Employee(1,"Akash","7463534853",30000));
        emp.add(new Employee(6,"Ravi","853748764574",40000));
        emp.add(new Employee(9,"Ravi","91191912344",30000));
        emp.add(new Employee(8,"Hari","9363436453",20000));
        emp.add(new Employee(7,"Ram","7845362544",10000));

//        print id of employees who's anme starts with m'
        List<Integer> idsWhosNameStartsWithm=emp.stream().filter(e->e.getName().toLowerCase().startsWith("m")).map(Employee::geteId).collect(Collectors.toList());
//        System.out.println(idsWhosNameStartsWithm);

        //return all the employee names whose salary is grater than 20000
        List<String> empNames=emp.stream().filter(e->e.getSalary()>20000).map(Employee::getName).collect(Collectors.toList());
        System.out.println(empNames);

        //print count of employees whose salary is greater or equals than 30000
        System.out.println(emp.stream().filter(e->e.getSalary()>=30000).count());

        //get the first employees whose salary is greater than 20000
        String firstName=emp.stream().filter(e->e.getSalary()>20000).reduce((a,b)->a).map(Employee::getName).get();//if we use get than it can throw null pointer
                                                                                                                    //so instead of null we should use .orElse(
        System.out.println(firstName);

        //get the last employees whose salary is greater than 20000
        String lastName=emp.stream().filter(e->e.getSalary()>20000).reduce((a,b)->b).map(Employee::getName).orElse("null");
        System.out.println(lastName);

//        using find first

        String findFirst=emp.stream().filter(e->e.getSalary()>20000).findFirst().map(Employee::getName).orElse("NULL");
        System.out.println(findFirst);

        //using find Any

        String findAny=emp.stream().filter(e->e.getSalary()>20000).findAny().map(Employee::getName).orElse("NULL");
        System.out.println(findAny);

//        find last
        String findLast=emp.stream().filter(e->e.getSalary()>40000).map(Employee::getName).reduce((a,b)->b).orElse("");
        System.out.println(findLast);

        int arr[]= new int[6];
       Map<Integer,Integer> map= new HashMap<>();
        Arrays.stream(arr).forEach(e->map.put(e,map.getOrDefault(e,1)));


//        5th largest element in array
        int[] array = {12, 5, 8, 15, 30, 22, 18, 7, 3, 14};

        int fifthLargest = Arrays.stream(array)
                .boxed()                                  // Convert int[] to Stream<Integer>
                .sorted((a, b) -> b - a)                  // Sort in descending order
                .distinct()                               // Remove duplicates
                .skip(4)                                  // Skip the first 4 elements (since we want the 5th largest)
                .findFirst()                              // Get the 5th largest
                .orElseThrow(() -> new RuntimeException("Array doesn't have 5 distinct elements"));
        int fourththLargest=Arrays.stream(array).boxed().sorted((a,b)->b-a).distinct().skip(3).findFirst().orElse(-1);
        System.out.println("fouth largest ele in array"+ fourththLargest);

        System.out.println("The 5th largest element is: " + fifthLargest);
    }
}
