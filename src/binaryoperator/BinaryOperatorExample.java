package binaryoperator;


import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    static Comparator<Integer> ComparatorTest = (a, b) -> a.compareTo(b);

    public static void main(String[] args) {

        BinaryOperator<Integer> binaryOperator = (a, b) -> a * b;
// Use case -> when input and the output ar the of the same type
        System.out.println(binaryOperator.apply(3, 4));

        BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(ComparatorTest);
        System.out.println("Result of MaxBy is : " + maxBy.apply(4, 5));

        BinaryOperator<Integer> minBy = BinaryOperator.minBy(ComparatorTest);
        System.out.println("Result of minBy is : " + minBy.apply(4, 5));

    }

}
