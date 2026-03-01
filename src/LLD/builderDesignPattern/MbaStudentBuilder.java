package LLD.builderDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class MbaStudentBuilder extends StudentBuilder{
    @Override
    public StudentBuilder setSubjects() {
        List<String> mbaSubjects = new ArrayList<>();
        mbaSubjects.add("Marketing");
        mbaSubjects.add("Finance");
        mbaSubjects.add("Human Resource Management");
        mbaSubjects.add("Operations Management");

       this.subjects = mbaSubjects;
        return this;
    }
}
