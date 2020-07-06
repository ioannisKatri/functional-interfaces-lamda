package streams_terminal;


import data.Student;
import data.StudentDataBase;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamGroupingByExample {

    public static void groupStudentsByGender() {

        Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGender));

        System.out.println(studentMap);
    }

    public static void customizedGroupingBy() {

        Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents()
                .stream() //Stream<Students>
                .collect(groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE"));

        System.out.println(studentMap);
    }

    public static void twoLevelGrouping_1() {

        Map<Integer, Map<String, List<Student>>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,
                        groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE")));

        System.out.println(studentMap);
    }

    public static void twoLevelGrouping_2() {

        Map<String, Integer> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getName,
                        summingInt(Student::getNoteBooks)));

        System.out.println(studentMap);
    }

    public static void threeArgumentGroupBy() {

        LinkedHashMap<String, Set<Student>> studentLinkedHashmap = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getName, LinkedHashMap::new, toSet()));

        System.out.println(studentLinkedHashmap);
    }

    public static void threeArgumentGroupBy1() {

        LinkedHashMap<String, Map<String, List<Student>>> studentLinkedHashmap = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getName, LinkedHashMap::new, groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE")));

        System.out.println(studentLinkedHashmap);
    }

    public static void calculateTopGpa() {

        Map<Integer, Optional<Student>> studentMapOptional = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,
                        maxBy(Comparator.comparing(Student::getGpa))));

        // System.out.println(studentMapOptional);

        Map<Integer, Student> studentMapOptional1 = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,
                        collectingAndThen(maxBy(Comparator.comparing(Student::getGpa))
                                , Optional::get)));

        System.out.println(studentMapOptional1);
    }

    public static void calculateLeastGpa() {

        Map<Integer, Optional<Student>> studentMapOptional = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,
                        minBy(Comparator.comparing(Student::getGpa))));

        // System.out.println(studentMapOptional);

        Map<Integer, Student> studentMapOptional1 = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,
                        collectingAndThen(minBy(Comparator.comparing(Student::getGpa))
                                , Optional::get)));


//
//        LinkedHashMap<Double, Set<Student>> maasdsaasp = StudentDataBase.getAllStudents().stream()
//                .filter(p -> p.getGpa() > 3.8)
//                .collect( groupingBy(Student::getGpa, LinkedHashMap::new,toSet()));
//

        System.out.println(studentMapOptional1);
    }


    // downstream is another collector
    public static void main(String[] args) {

        groupStudentsByGender();
        //customizedGroupingBy();
        //twoLevelGrouping_1();
        // twoLevelGrouping_2();
        // threeArgumentGroupBy();
//        threeArgumentGroupBy1();
        //calculateTopGpa();
//        calculateLeastGpa();

    }
}
