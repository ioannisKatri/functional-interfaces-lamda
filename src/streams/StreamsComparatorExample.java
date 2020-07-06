package streams;


import data.Student;
import data.StudentDataBase;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

class StreamsComparatorExample {

    public static List<Student> sortStudentsByName() {

        Comparator<Student> compareNames = (student1, student2) -> {
            return student1.getName().compareTo(student2.getName());
        };


        return StudentDataBase.getAllStudents()
                .stream()
//                .sorted(compareNames)
//                .sorted(ComparatorTest.comparing(Student::getName))
                .sorted((student1, student2) -> {
                    return student1.getName().compareTo(student2.getName());
                })
                .collect(toList());
    }

    public static List<Student> sortStudentsByGpa() {

        return StudentDataBase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getGpa))
                .collect(toList());
    }

    public static List<Student> sortStudentsByGpaDesc() {

        return StudentDataBase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(toList());
    }

    public static void main(String[] args) {


        System.out.println("Students sorted by Name : ");
        sortStudentsByName().forEach(System.out::println);
//        System.out.println("Students sorted by GPA : ");
//        sortStudentsByGpa().forEach(System.out::println);
//
//        System.out.println("Students sorted by GPA DESC: ");
//        sortStudentsByGpaDesc().forEach(System.out::println);


    }
}
