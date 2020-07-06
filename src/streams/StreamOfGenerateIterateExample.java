package streams;

import data.Student;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamOfGenerateIterateExample {

    public static void main(String[] args) {

        Stream<String> stringStream = Stream.of("adam", "dan", "julie");
        stringStream.forEach(System.out::println);

        Stream.iterate(1, x -> x * 2)
                .limit(5)
                .forEach(System.out::println);

//        In the below code we are just assigning a reference not the actual int value.
        Supplier<Integer> integerSupplier = new Random()::nextInt;

        Supplier<Integer> integerSupplier1 = () -> {
            return new Random().nextInt();
        };

        Stream.generate(integerSupplier)
                .limit(5)
                .forEach(System.out::println);


    }
}
