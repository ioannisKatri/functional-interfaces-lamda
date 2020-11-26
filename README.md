# Java 8 - functional interfaces - Lamda


The purpose of this repo is to learn how to utilize functional interfaces and Lamdas that were introduced in Java 8.

###What is Lamda?

Java lambda expressions are Java's first step into functional programming. A lambda is an anonymous function that can be created without belonging to any class. Lambda expressions are commonly used to implement simple event listeners / callbacks or in functional programing with Java Streams API.

###What is a functional interface?

All functional interfaces have an informative @FunctionalInterface. That itnerface that contains only a single abstract (unimplemented) method. They can contain default and static methods which have implementation in addition to the single unimplemented method. 