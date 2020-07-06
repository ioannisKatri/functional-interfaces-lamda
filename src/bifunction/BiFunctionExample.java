package bifunction;


import data.Student;
import data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;


public class BiFunctionExample {

    static Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;

    static Predicate<Student> p2 = (s) -> s.getGpa() >= 3.9;

    static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunction = ((students, studentPredicate) -> {

        Map<String, Double> studentGradeMap = new HashMap<>();
        students.forEach(student -> {
            if (studentPredicate.test(student)) {
                studentGradeMap.put(student.getName(), student.getGpa());
            }
        });
        return studentGradeMap;
    });

    public static void main(String[] args) {
        Map<String, Double> studentGradeMap1 = new HashMap<>();
        System.out.println(biFunction.apply(StudentDataBase.getAllStudents(), p2));
    }
}
