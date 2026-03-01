package LLD.builderDesignPattern;

public class Director {
    StudentBuilder studentBuilder ;
    public Director(StudentBuilder studentBuilder){
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent(){
        if(studentBuilder instanceof MbaStudentBuilder){
            return createMbaStudent();
        }else if(studentBuilder instanceof EngineeringStudentBuilder){
            return createEngineeringStudent();
        }
        return null;
    }

    private Student createMbaStudent(){
        return studentBuilder.setRollNumber(1)
                .setAge(22)
                .setName("John Doe")
                .setFatherName("Richard Roe")
                .setMotherName("Jane")
                .setMobileNumber("1234567890")
                .setSubjects()
                .build();
    }

    private Student createEngineeringStudent(){
        return studentBuilder.setRollNumber(2)
                .setAge(20)
                .setName("Alice Smith")
                .setMotherName("Carol")
                .setMobileNumber("0987654321")
                .setSubjects()
                .build();
    }


}
