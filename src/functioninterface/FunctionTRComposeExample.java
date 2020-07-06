package functioninterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionTRComposeExample {
    public static void main(String[] args) {
        TestFunction<Employee, String> funcEmpToString = (Employee e) -> {
            System.out.println("This is applied");
            return e.getName() + "-";
        };

        TestFunction<Employee, Employee> funcEmpFirstName =
                (Employee e) -> {
                    System.out.println("inside function");

                    String firstName = e.getName().substring(0, e.getName().indexOf(" "));

                    System.out.println(firstName);
                    e.setName(firstName + "+");
                    return e;
                };

        List<Employee> employeeList =
                Arrays.asList(new Employee("Tom Jones", 45),
                        new Employee("Harry Major", 25),
                        new Employee("Ethan Hardy", 65),
                        new Employee("Nancy Smith", 15),
                        new Employee("Deborah Sprightly", 29));

        List<String> empFirstNameList = convertEmpListToNamesList(employeeList, funcEmpToString.compose(funcEmpFirstName));


        empFirstNameList.forEach(str -> {
            System.out.print(" " + str);
        });
    }

    public static List<String> convertEmpListToNamesList(List<Employee> employeeList, TestFunction<Employee, String> funcEmpToString) {
        List<String> empNameList = new ArrayList<String>();
        for (Employee emp : employeeList) {
            empNameList.add(funcEmpToString.apply(emp));
        }
        return empNameList;
    }
}
