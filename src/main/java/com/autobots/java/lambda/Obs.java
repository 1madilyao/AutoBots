package com.autobots.java.lambda;

import java.util.function.*;

public class Obs {
    public static void main(String[] args) {


        Predicate<String> isEmpty = str -> str.isEmpty();
        System.out.println(isEmpty.test("")); // true

        Function<String, Integer> stringLength = s -> s.length();
        System.out.println(stringLength.apply("Java")); // 4

        Consumer<String> greeter = name -> System.out.println("Hello, " + name);
        greeter.accept("Madina"); // Hello, Madina

        Supplier<Double> randomValue = () -> Math.random();
        System.out.println(randomValue.get()); // например, 0.5234

        UnaryOperator<Integer> square = x -> x * x;
        System.out.println(square.apply(5)); // 25

        BinaryOperator<Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(3, 7)); // 10

        BiFunction<String, Integer, String> repeat = (s, n) -> s.repeat(n);
        System.out.println(repeat.apply("ha", 3)); // hahaha

        BiPredicate<String, String> areEqual = (a, b) -> a.equalsIgnoreCase(b);
        System.out.println(areEqual.test("java", "JAVA")); // true

        BiConsumer<String, Integer> printAge = (name, age) -> System.out.println(name + " is " + age + " years old");
        printAge.accept("Madina", 25);
    }
}
