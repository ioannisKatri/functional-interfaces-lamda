package consumer;

import data.Student;
import data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class ConsumerExample {

    static Consumer<Student> c2 = (student) -> System.out.println(student);
    static Consumer<Student> c3 = (student) -> System.out.print(student.getName());
    static Consumer<Student> c4 = (student) -> System.out.println(student.getActivities());


    public static void printStudents() {

        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(c2);
    }

    public static void printNameAndActivities() {
        System.out.println("printNameAndActivities :");

        List<Student> studentList = StudentDataBase.getAllStudents();

        studentList.forEach(c3.andThen(c4)); //consumer chaining
    }


    public static void printNameAndActivitiesUsingCondition() {

        System.out.println("printNameAndActivitiesUsingCondition :");
        List<Student> studentList = StudentDataBase.getAllStudents();

        studentList.forEach((student -> {
            if (student.getGradeLevel() >= 3 && student.getGpa() >= 3.9) {
                c3.andThen(c4).andThen(c2).accept(student);
            }
        }));
    }


    public static void main(String[] args) {

        Consumer consumer = new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        };

//        consumer.StudentDataBase.getAllStudents().forEach(consumer);
//
//        consumer.StudentDataBase.getAllStudents().forEach(new consumer<consumer.Student>() {
//            @Override
//            public void accept(consumer.Student student) {
//                if (student.getGradeLevel() == 3 && student.getGpa() >= 3.9) {
//                    c3.accept(student);
//                    c4.accept(student);
//                    c2.accept(student);
//
//                    System.out.println();
//                }
//            }
//        });


//        consumer.StudentDataBase.getAllStudents().forEach((student -> {
//            if (student.getGradeLevel() == 3 && student.getGpa() >= 3.9) {
//                c3.accept(student);
//                c4.accept(student);
//                c2.accept(student);
//                System.out.println();
//            }
//        }));

//        static consumer<consumer.Student> c3 = (student) -> System.out.print(student.getName());

//        consumer.StudentDataBase.getAllStudents().forEach(new consumer<consumer.Student>() {
//            @Override
//            public void accept(consumer.Student student) {
//                if (student.getGradeLevel() == 3 && student.getGpa() >= 3.9) {
//
//                    c3.andThen((student1 -> {
//                        System.out.println(student1);
//                    })).accept(student);
//
//                    System.out.println();
//                }
//            }
//        });
//
//        consumer.StudentDataBase.getAllStudents().forEach(new consumer<consumer.Student>() {
//            @Override
//            public void accept(consumer.Student student) {
//                if (student.getGradeLevel() == 3 && student.getGpa() >= 3.9) {
//
//                    new consumer<consumer.Student>() {
//                        @Override
//                        public void accept(consumer.Student student) {
//                            System.out.print(student.getName());
//                        }
//                    }.andThen(new consumer<consumer.Student>() {
//                        @Override
//                        public void accept(consumer.Student student) {
//                            System.out.println(student);
//                        }
//                    }).accept(student);
//
////                    c3.andThen(new consumer<consumer.Student>() {
////                        @Override
////                        public void accept(consumer.Student student) {
////                            System.out.print("'----");
////                            System.out.println(student);
////                        }
////                    }).accept(student);
//
//                    System.out.println();
//                }
//            }
//        });
//
//
//        consumer.StudentDataBase.getAllStudents().forEach(new consumer<consumer.Student>() {
//            @Override
//            public void accept(consumer.Student student) {
//                if (student.getGradeLevel() == 3 && student.getGpa() >= 3.9) {
//
//                    c3.andThen(new consumer<consumer.Student>() {
//                        @Override
//                        public void accept(consumer.Student student) {
//                            System.out.println(student);
//                        };
//                    }).accept(student);
//
////                    c3.andThen(new consumer<consumer.Student>() {
////                        @Override
////                        public void accept(consumer.Student student) {
////                            System.out.print("'----");
////                            System.out.println(student);
////                        }
////                    }).accept(student);
//
//                    System.out.println();
//                }
//            }
//        });
        Student student4 = new Student("Dave", 3, 3.9, "male", Arrays.asList("swimming", "gymnastics", "soccer"));


        TestInterface<Student> test = (student) -> {
            System.out.println("Calling Accept()");
        };

        test.andThen2().accept(student4);


        test.andThen((student) ->
                System.out.println("Calling andThen()")
        ).andThen((student) ->
                System.out.println("Calling Second andThen()")
        ).accept(student4);
//
//
//        test.andThen1(student4);
//        test.accept(student4);


//        consumer.StudentDataBase.getAllStudents().forEach((student -> {
//            if (student.getGradeLevel() >= 3 && student.getGpa() >= 3.9) {
//                c3.andThen(c4).accept(student);
//            }
//        }));

//
//        consumer.StudentDataBase.getAllStudents().forEach((student -> {
//            if (student.getGradeLevel() >= 3 && student.getGpa() >= 3.9) {
//                c3.andThen(c4).accept(student);
//            }
//        }));

        //printStudents();
//        printNameAndActivities();
//        printNameAndActivitiesUsingCondition();
    }
}
