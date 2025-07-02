package com.autobots.java.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaLessons {
    public static void main(String[] args) {

        MathOperation addition =(a, b)->a + b ;
        MathOperation multi =(a,b)->a * b ;

        System.out.println("5+3="+addition.operation(5,3));
        System.out.println("5*3="+multi.operation(5,3));


        // принимает любой объект возвращает true/false -boolean
        Predicate<String>isnotEmpty= s->!s.isEmpty();
        System.out.println(isnotEmpty.test(""));
        System.out.println(isnotEmpty.test("java"));

        // принимает int возвращает String
        Function<Integer,String> toStringFun= i->"число:"+i;
        System.out.println(toStringFun.apply(10));    // абстрактный метод function


        Consumer<String> print =s-> System.out.println("Writing : "+ s);
        print.accept("Hello World!  ");
    }


}
