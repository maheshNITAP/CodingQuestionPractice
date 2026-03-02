package Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(101,"Rahul",10,"1234567890");
        Student s2 = new Student(108,"Rohit",9,"0987654321");
        Student s3 = new Student(103,"Ramesh",11,"1122334455");
        Student s4 = new Student(99,"Suresh",8,"9988776655");
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        Collections.sort(students);

        students.stream().forEach(s->System.out.println(s.getRollNo()+" "+s.getName()+" "+s.getStandard()+" "+s.getPhone()));




    }
}
