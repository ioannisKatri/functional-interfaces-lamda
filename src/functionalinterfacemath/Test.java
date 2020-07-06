package functionalinterfacemath;

public class Test {
    public static void main(String[] args) {

        //plus5 is an expressive static helper method that adds 5 to a given number
        Operation<Integer> calc = (x) -> Operation.plus5(2);

        Operation complexOp = calc.add(3)
                .multiply(4)
                .multiply(2)
                .multiply(2)
                .add(4);

        complexOp.print();

        int result = complexOp.getResult();

    }
}
