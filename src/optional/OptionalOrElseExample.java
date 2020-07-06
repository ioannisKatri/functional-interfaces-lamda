package optional;


import data.Student;
import data.StudentDataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalOrElseExample {

    //orElse

    public static String optionalOrElse() {

//        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> studentOptional = Optional.ofNullable(null); // Option.empty

//        List<String> name = studentOptional.map(Student::getActivities).orElse(new ArrayList<String>());
        String name = studentOptional.map(Student::getName).orElse("Default");
        return name;
    }

    //orElseGet
    public static String optionalOrElseGet() {
        Optional<Student> studentOptional =
                Optional.ofNullable(null);
        return studentOptional.map(Student::getName).orElseGet(() -> "Default");

    }

    //orElseThrow
    public static String optionalOrElseThrow() {

        Optional<Student> studentOptional =
                Optional.ofNullable(null);

        return studentOptional.map(Student::getName)
                .orElseThrow(() -> new RuntimeException("No Data Available"));
    }

    public static void main(String[] args) {


//        Difference between orElse and orElseGet() is that the second accepts a supplier

        System.out.println("orElse : " + optionalOrElse());
        System.out.println("orElseGet :  " + optionalOrElseGet());
        System.out.println("orElseThrow :  " + optionalOrElseThrow());
    }
}
