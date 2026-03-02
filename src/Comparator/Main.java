package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "John", "1234567890", 50000);
        Employee e2 = new Employee(108, "Alice", "0987654321", 60000);
        Employee e3 = new Employee(102, "Bob", "1111111111", 55000);
        Employee e4 = new Employee(104, "Charlie", "2222222222", 45000);

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);

        Collections.sort(employees, new IdComparator());

        employees.stream().forEach(e -> System.out.println(e.getId() + " " + e.getName() + " " + e.getPhone() + " " + e.getSalary()));

        System.out.println("-------------------------------------------------");


        Collections.sort(employees, new NameComparator());
        employees.stream().forEach(e -> System.out.println(e.getId() + " " + e.getName() + " " + e.getPhone() + " " + e.getSalary()));

    }
}
