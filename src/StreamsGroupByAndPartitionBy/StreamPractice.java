package StreamsGroupByAndPartitionBy;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String args[]){
        List<String> strList = Arrays.asList("Java", "Ruby", "AWS", "Docker", "Java", "Ruby", "Java");

        strList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).forEach((x,y)-> System.out.println(x+ " "+y));

        Map<String, Long> map= strList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(map);

        List<Employee> empLis = new ArrayList<>();
        empLis.add(new Employee("Raj", 42, 25000, "DEV"));
        empLis.add(new Employee("Ashok", 22, 35000, "dev"));
        empLis.add(new Employee("Sankar", 32, 24000, "QA"));
        empLis.add(new Employee("Aswin", 37, 80000, "DEV"));
        empLis.add(new Employee("Mohan", 45, 60000, "HR"));
        empLis.add(new Employee("Kamal", 33, 56000, "QA"));

        //All Employee names starts with m

        List<String> names= empLis.stream().filter(e->e.getName().toLowerCase().startsWith("m")).map(Employee::getName).collect(Collectors.toList());
        System.out.println(names);

//        / print names of employees whose salary is greater than 20000
        List<String> names2= empLis.stream().filter(e->e.getSalary()>30000).map(Employee::getName).collect(Collectors.toList());
        System.out.println(names2);

        ////print count of employees whose salary is greater or equals than 30000
        long count=empLis.stream().filter(e->e.getSalary()>20000).count();
        System.out.println(count);

        //first employee whose salary is greater than 20000
        String firstName=empLis.stream().filter(e-> e.getSalary()>30000).findFirst().map(Employee::getName).orElse(null);
        System.out.println(firstName);

        ////Grpouping by department and counting employees in each department

        Map<String,Long> map2= empLis.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        System.out.println(map2);

        //get max salary in each department

        Map<String, Optional<Employee>> map3= empLis.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));
        System.out.println(map3);

        //get min salary in each department
        empLis.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.minBy(Comparator.comparingInt(Employee::getSalary)))).forEach((x,y)-> System.out.println(x+" "+y));

        //i want only employee max salary in each department not full details of employee
        empLis.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.minBy(Comparator.comparingInt(Employee::getSalary)))).forEach((x,y)-> System.out.println(x+ " "+y.get().getSalary()));

        //        i want all employee Salary in each department
        Map<String, List<Integer>> map4= empLis.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getSalary,Collectors.toList())));
        System.out.println(map4);

        //i want to know all employee details who are working in each department
        Map<String, List<String>> map5= empLis.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName,Collectors.toList())));
        System.out.println(map5);

        // i want employee details in each department who is earning more than 30000
        Map<String, List<String>> map6= empLis.stream().filter(e->e.getSalary()>30000).collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName,Collectors.toList())));
        System.out.println(map6);

        // //PartitionBy-- when we want two groups one which is satisfying the condition and other which in not satisfying condition

        Map<Boolean, List<Employee>> map7= empLis.stream().collect(Collectors.partitioningBy(e->e.getSalary()>30000));
        System.out.println(map7.get(false));
        System.out.println(map7);

        //return count after partition
        Map<Boolean, Long> map8= empLis.stream().collect(Collectors.partitioningBy(e->e.getSalary()>30000,Collectors.counting()));
        System.out.println(map8);

        //get char which occurs kt max times
        String s="abbbbcccd";
        int k=2;
        Character ch=s.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet()
                .stream().sorted((a,b)->Long.compare(b.getValue(),a.getValue())).skip(k-1).map(a->a.getKey()).findFirst().get();
        System.out.println(ch);

        //pint count of each char
        String s1="Rajendra";

        Map<Character,Long> map9= s1.chars().mapToObj(c->(char) c).map(Character::toLowerCase).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map9);


    }
}
