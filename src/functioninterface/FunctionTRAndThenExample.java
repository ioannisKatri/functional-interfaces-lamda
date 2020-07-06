package functioninterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//import statements are same as in apply() example
public class FunctionTRAndThenExample {
    public static void main(String args[]) {
        TestFunction<Employee, String> funcEmpToString = (Employee e) -> e.getName();

        List<Employee> employeeList =
                Arrays.asList(new Employee("Tom Jones", 45),
                        new Employee("Harry Major", 25),
                        new Employee("Ethan Hardy", 65),
                        new Employee("Nancy Smith", 15),
                        new Employee("Deborah Sprightly", 29));

        Random random = new Random();
        TestFunction<String, Integer> initialFunction = (String s) -> s.substring(0, random.nextInt(10)).length();

        List<Integer> empNameListInitials = convertEmpListToNamesList(employeeList, funcEmpToString.andThen(initialFunction));
        empNameListInitials.forEach(str -> {
            System.out.print(" " + str);
        });
    }

    public static List<Integer> convertEmpListToNamesList(List<Employee> employeeList, TestFunction<Employee, Integer> funcEmpToString) {
        List<Integer> empNameList = new ArrayList<Integer>();
        for (Employee emp : employeeList) {
            empNameList.add(funcEmpToString.apply(emp));
        }
        return empNameList;
    }
}