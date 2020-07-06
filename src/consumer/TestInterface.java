package consumer;


import java.util.Objects;

@FunctionalInterface
public interface TestInterface<T> {

    void accept(T t);


//    student ->System.out.println("Calling andThen()")

    default TestInterface<T> andThen(TestInterface<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> {
            System.out.println("Before calling accept(t)");
            accept(t);
            System.out.println("After calling accept(t)\n");

            System.out.println("Before calling after.accept(t)");
            after.accept(t);
            System.out.println("After calling after.accept(t)\n");
        };
    }

    default void andThen1(T t) {
        accept(t);
    }

    default TestInterface<T> andThen2() {
        return (T t) -> {
            accept(t);
        };
    }

}

