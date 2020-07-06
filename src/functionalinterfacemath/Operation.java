package functionalinterfacemath;

@FunctionalInterface
public interface Operation<Intetger> {

    //SAM -- Single Abstract Method.
    //identifier abstract is optional
    Integer operate(Integer operand);

    default Operation<Integer> add(Integer o) {
        return (o1) -> operate(o1) + o;
    }

    default Operation<Integer> multiply(Integer o) {
        return (o1) -> operate(o1) * o;
    }

    //define other default methods for divide, subtract, etc
    default Integer getResult() {
        return operate(0);
    }

    default void print() {
        System.out.println("result is = " + getResult());
    }


    //helper -- adds 5 to a given number
    static Integer plus5(Integer input) {
        return input + 5;
    }
}
