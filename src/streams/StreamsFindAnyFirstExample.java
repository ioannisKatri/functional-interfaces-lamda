package streams;


import data.Student;
import data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsFindAnyFirstExample {

    public static Optional<Student> findAnyStudent() {

        return StudentDataBase.getAllStudents().parallelStream()
                //adam
                //jenny
                //emily
                .filter(student -> student.getGpa() >= 3.1)
                .findAny();
    }

    public static Optional<Student> findFirstStudent() {

        return StudentDataBase.getAllStudents().parallelStream()
                //adam
                //jenny
                //emily
                .filter(student -> student.getGpa() >= 3.1)
                .findFirst();
    }

    public static void main(String[] args) {


        Optional<Student> studentOptionalFindAny = findAnyStudent();
        if (studentOptionalFindAny.isPresent()) {
            System.out.println("Found The student : " + studentOptionalFindAny.get());
        } else {
            System.out.println("Student Not Found !");
        }

        Optional<Student> studentOptionalFindFirst = findFirstStudent();
        if (studentOptionalFindFirst.isPresent()) {
            System.out.println("Found The student : " + studentOptionalFindFirst.get());
        } else {
            System.out.println("Student Not Found !");
        }

//        findFIrst() will return the firt, in one of the streams which is running in parallel.


        List<String> lst1 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill", "Dany", "Julia", "Jenish", "Divya");
        List<String> lst2 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill", "Dany", "Julia", "Jenish", "Divya");

        Optional<String> findFirst = lst1.parallelStream().filter(s -> s.startsWith("D")).findFirst();
        Optional<String> fidnAny = lst2.parallelStream().filter(s -> s.startsWith("D")).findAny();

        System.out.println(findFirst.get()); //Always print David
        System.out.println(fidnAny.get()); //Print Jack/Jill/Julia :behavior of this operation is explicitly nondeterministic


    }
}
