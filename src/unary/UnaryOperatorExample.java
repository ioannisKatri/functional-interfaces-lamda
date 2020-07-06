package unary;


import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

    static UnaryOperator<String> unaryOperator = (s) -> s.concat("Default");

    public static void main(String[] args) {

// Use case -> when input and the output ar the of the same type we use UnaryOperator instead of funtion
        System.out.println(unaryOperator.apply("java8"));
    }
}
