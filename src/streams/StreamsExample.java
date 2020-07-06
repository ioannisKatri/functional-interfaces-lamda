package streams;


import data.Student;
import data.StudentDataBase;


import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {

    public static void main(String[] args) {

        //student name and there activities in a map
        Predicate<Student> studentPredicate = (student -> student.getGradeLevel() >= 3);
        Predicate<Student> studentgpaPredicate = (student -> student.getGpa() >= 3.9);

// All these operations below Are called Stream Pipeline
//Each operation returns a stream
//  Filter is a n intermediate operation (Stream operations that happen between the parallelStream and the collect())
//        Collect is the terminal operation
        Map<String, List<String>> studentMap = StudentDataBase.getAllStudents().parallelStream()
                .filter(studentPredicate)
                .filter(studentgpaPredicate)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));


        Map<String, List<String>> debuging = StudentDataBase.getAllStudents().stream()
                .peek((student -> {
                    System.out.println(student);
                }))
                .filter(studentPredicate) //Stream<Students>
                .peek((student -> {
                    System.out.println("after 1 st filter " + student);
                }))
                .filter(studentgpaPredicate)//Stream<Students>
                .peek((student -> {
                    System.out.println("after 2 nd filter " + student);
                }))
                .collect(Collectors.toMap(Student::getName, Student::getActivities)); //<Map>

        System.out.println(debuging);
    }
}
