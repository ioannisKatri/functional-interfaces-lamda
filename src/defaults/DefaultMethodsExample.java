package defaults;

import data.Student;
import data.StudentDataBase;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultMethodsExample {

    public static void main(String[] args) {

        /**
         * Sort the list names in alphabetical order
         */

        List<String> stringList = Arrays.asList("Adam", "Jenny", "Alex", "Dan", "Mike", "Eric");

        /**
         * Prior Java 8
         */

//        Collections.sort(stringList);

//        System.out.println("Sorted list using Collections.Sort() : " + stringList);

        /**
         * Java 8
         */

        List<Student> students = StudentDataBase.getAllStudents();

        stringList.sort(Comparator.naturalOrder());

        System.out.println("Sorted list using List.Sort() : " + stringList);

        stringList.sort(Comparator.reverseOrder());

        System.out.println("Sorted list using List.Sort() reverse : " + stringList);
    }
}
