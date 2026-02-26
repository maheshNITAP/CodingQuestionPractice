package StreamsGroupByAndPartitionBy;


import java.io.OutputStream;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String args[]) {

        List<String> strList = Arrays.asList("Java", "Ruby", "AWS", "Docker", "Java", "Ruby", "Java");

        strList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((x, y) -> System.out.println(x + " : " + y));
        System.out.println("-------------------------------------------------------------");


        List<Employee> empLis = new ArrayList<>();
        empLis.add(new Employee("Raj", 42, 25000, "DEV"));
        empLis.add(new Employee("Ashok", 22, 35000, "dev"));
        empLis.add(new Employee("Sankar", 32, 24000, "QA"));
        empLis.add(new Employee("Aswin", 37, 80000, "DEV"));
        empLis.add(new Employee("Mohan", 45, 60000, "HR"));
        empLis.add(new Employee("Kamal", 33, 56000, "QA"));


        //if it is primitive data type then use boxed
        //   Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).forEach();

        empLis.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).forEach((x, y) -> System.out.println(x + " : " + y));
        System.out.println("-------------------------------------------------------------");

        Map<String, Long> map = empLis.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(map);

        System.out.println("-------------------------------------------------------------");

        //i want to know employee details who is earning max in each department
        empLis.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))))
                .forEach((x, y) -> System.out.println(x + " : " + y));//to print employee details toString method should be there

        System.out.println("-------------------------------------------------------------");

        //i want only employee max salary in each department not full details of employee

        empLis.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))))
                .forEach((x,y)-> System.out.println(x+" : "+y.get().getSalary()));

        System.out.println("-------------------------------------------------------------");


        ////i want to know employee details who is earning min in each department

        empLis.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.minBy(Comparator.comparingInt(Employee::getSalary))))
                .forEach((x,y)-> System.out.println(x+" : "+ y));

        System.out.println("-------------------------------------------------------------");


        //i only want to know employee name in each department who is earning min salary

        empLis.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.minBy(Comparator.comparingInt(Employee::getSalary))))
                .forEach((x,y)-> System.out.println(x+" : "+y.get().getName()));

        System.out.println("-------------------------------------------------------------");


        //i want to know all employee details who are working in each department

        empLis.stream().collect(Collectors.groupingBy(Employee::getDepartment)).forEach((x,y)-> System.out.println(x+" : "+y));

        System.out.println("-------------------------------------------------------------");

        // i want employee details in each department who is earning more than 30000

        empLis.stream().collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().stream().filter(e1->e1.getSalary()>30000).collect(Collectors.toList())))
                .forEach((x,y)-> System.out.println(x+" : "+y));


        //PartitionBy-- when we want two groups one which is satisfying the condition and other which in not satisfying condition

        //Basically we will be doing partition based on some condition


        System.out.println("------------------------------PartitionBy-------------------------------");

        empLis.stream().collect(Collectors.partitioningBy(e->e.getSalary()>50000)).forEach((x,y)-> System.out.println(x+" : "+y));

        System.out.println("-------------------------------------------------------------");
        //return count after partition
        empLis.stream().collect(Collectors.partitioningBy(e->e.getSalary()>50000,Collectors.counting())).forEach((x,y)-> System.out.println(x+" : "+y));

        String s="Rajendra";

        s.chars().mapToObj(c->(char)c)//mapToObj to convert int stream to char stream
                .map(e->Character.toLowerCase(e))//to convert lowercase
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .forEach((x,y)-> System.out.println(x+" : "+y));






    }
}
