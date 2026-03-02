package CopmaratorOrComparable;

import java.util.*;
import java.util.stream.Collectors;

public class PracticeStream {
    public static void main(String[] args) {
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee(101, "John", "1234567890", 50000, "DEV"));
        emp.add(new Employee(108, "Alice", "0987654321", 60000, "HR") );
        emp.add(new Employee(102, "Bob", "1111111111", 55000, "QA"));
        emp.add(new Employee(104, "Charlie", "2222222222", 45000, "DEV"));
        emp.add(new Employee(103, "David", "3333333333", 70000, "HR"));
        emp.add(new Employee(106, "Eve", "4444444444", 65000, "QA"));
        emp.add(new Employee(5,"Mahesh","911912234",10000,"DEV"));
        emp.add(new Employee(2,"Mahesh","8922345438",20000,"HR"));
        emp.add(new Employee(1,"Akash","7463534853",30000,"QA"));
        emp.add(new Employee(6,"Ravi","853748764574",40000,"DEV"));
        emp.add(new Employee(9,"Ravi","91191912344",30000, "HR"));
        emp.add(new Employee(8,"Hari","9363436453",20000,"QA"));
        emp.add(new Employee(7,"Ram","7845362544",10000,"DEV"));

        //
        List<Integer> idNameStartsWithm = emp.stream().filter(e->e.getName().toLowerCase().startsWith("m")).map(Employee::geteId).collect(Collectors.toList());
        for(Integer i:idNameStartsWithm){
            System.out.println(i);
        }

        // print names of employees whose salary is greater than 20000
        System.out.println("print names of employees whose salary is greater than 20000");
        emp.stream().filter(e->e.getSalary()>20000).map(Employee::getName).forEach(System.out::println);

        //
        long count = emp.stream().filter(e->e.getSalary()>=30000).count();
        System.out.println("count of employees whose salary is greater or equals than 30000: "+count);

        String name = emp.stream().filter(e->e.getSalary()>20000).findFirst().map(Employee::getName).orElse("null");
        System.out.println("first employee whose salary is greater than 20000: "+name);

        String Lastname = emp.stream().filter(e->e.getSalary()>=30000).reduce((a,b)->b).map(Employee::getName).orElse("null");

        // it is free to select any element in the stream. so it can return any employee whose salary is greater than 30000
        String Lastname2 = emp.stream().filter(e->e.getSalary()>=30000).findAny().map(Employee::getName).orElse("null");
        System.out.println("last employee whose salary is greater than 30000: "+Lastname);
        System.out.println("last employee whose salary is greater than 30000: "+Lastname2);

        int arr[]= {12, 5, 8, 15, 30, 22, 18, 7, 3, 14};

        int fifthLargest =Arrays.stream(arr).boxed().sorted((a,b)->b-1).distinct().skip(4).findFirst().orElse(-1);
        System.out.println("5th largest element in array: "+fifthLargest);


        System.out.println("-------------------------------------------------------------");

        //Grpouping by department and counting employees in each department
        emp.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting())).forEach((x,y)->System.out.println(x+" : "+y));

        System.out.println("-------------------------------------------------------------");

        Map<String, Long> map= emp.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        for(Map.Entry<String, Long> e:map.entrySet()){
            System.out.println(e.getKey()+" : "+e.getValue());
        }

        //get max salary in each department
        System.out.println("--------------------------get max salary in each department-----------------------------------");
       emp.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)))).forEach((x,y)-> System.out.println(x+" : "+y.get().getSalary()));

        //get min salary in each department
       emp.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.minBy(Comparator.comparingInt(Employee::getSalary)))).forEach((x,y)-> System.out.println(x+" : "+y.get().getSalary()));


        //i only want to know employee name in each department who is earning min salary

        emp.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.minBy(Comparator.comparingInt(Employee::getSalary))))
                .forEach((x,y)->System.out.println(x+" : "+y.get().getName()));

        ////i want to know all employee details who are working in each department(just groupBy and print)
        emp.stream().collect(Collectors.groupingBy(Employee::getDepartment)).forEach((x,y)->System.out.println(x+" : "+y));

        // i want employee details in each department who is earning more than 30000
        System.out.println( "--------------------------employee details in each department who is earning more than 30000-----------------------------------");

        emp.stream().filter(e->e.getSalary()>30000).collect(Collectors.groupingBy(Employee::getDepartment)).forEach((x,y)-> System.out.println(x+" : "+y));


        System.out.println("------------------------------PartitionBy-------------------------------");
        emp.stream().collect(Collectors.partitioningBy(e->e.getSalary()>50000)).forEach((x,y)-> System.out.println(x+" : "+y));



    }
}
