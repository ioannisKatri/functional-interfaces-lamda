package functioninterface;


import java.util.Objects;

//http://www.angelikalanger.com/GenericsFAQ/JavaGenericsFAQ.html
//https://stackoverflow.com/questions/57549932/question-about-java-generics-and-design-of-java-util-function-function
//https://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java
//https://stackoverflow.com/questions/897935/when-do-java-generics-require-extends-t-instead-of-t-and-is-there-any-down
public interface TestFunction<T, R> {

    R apply(T t);

    default <V> TestFunction<V, R> compose(TestFunction<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> {

            System.out.println();
            System.out.println("Before");
//            System.out.println(v.getClass().getName());

            return apply(before.apply(v));
        };
    }

    default <V> TestFunction<T, V> andThen(TestFunction<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }

    static <T> TestFunction<T, T> identity() {
        return t -> t;
    }
}
