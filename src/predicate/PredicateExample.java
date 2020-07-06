package predicate;

import data.Student;

import java.util.Arrays;
import java.util.function.Predicate;

public class PredicateExample {

    static Predicate<Integer> p = (i) -> {
        return i % 2 == 0;
    };

    static Predicate<Integer> p1 = (i) -> i % 2 == 0;

    static Predicate<Integer> p2 = (i) -> i % 5 == 0;

    public static void predicateAnd() {

        System.out.println("predicate And result is : " + p1.and(p2).test(10)); //predicate chaining
        System.out.println("predicate And result is : " + p1.and(p2).test(9)); //predicate chaining

    }

    public static void predicateOr() {

        System.out.println("predicate OR result is : " + p1.or(p2).test(10)); //predicate chaining
        System.out.println("predicate OR result is : " + p1.or(p2).test(8)); //predicate chaining

    }

    public static void predicateNegate() {

        System.out.println("predicate Negate result is : " + p1.or(p2).negate().test(8)); //predicate chaining

    }

    public static void main(String[] args) {


//        System.out.println(p.test(4));
//
//
//        System.out.println(p1.test(4));
//
//        predicateAnd();
//        predicateOr();
//        predicateNegate();


        CustomPredicate<Integer> find = (i) -> {
            System.out.println(i % 2 == 0);
            return i % 2 == 0;
        };

//        find.test(11);


        Student student1 = new Student("Adam", 3, 3.6, "male", Arrays.asList("swimming", "basketball", "volleyball"));
        Student student2 = new Student("Sophia", 3, 3.5, "female", Arrays.asList("swimming", "dancing", "football"));


        CustomPredicate<Student> equalsGrade = student -> student.getGradeLevel() == 3;

        CustomPredicate<Student> testGrade = student -> {
            System.out.println(student.getGradeLevel() >= 3);
            return student.getGradeLevel() >= 3;
        };

        System.out.println(equalsGrade.test(student1));

    }

}
