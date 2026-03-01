package LLD.builderDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class EngineeringStudentBuilder extends StudentBuilder{
    @Override
    public StudentBuilder setSubjects() {
        List<String> engineeringSubjects = new ArrayList<>();
        engineeringSubjects.add("Mathematics");
        engineeringSubjects.add("Physics");
        engineeringSubjects.add("Computer Science");
        engineeringSubjects.add("Electronics");
        this.subjects = engineeringSubjects;
        return this;
    }
}
