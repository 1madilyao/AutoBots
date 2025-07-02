package com.autobots.java.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class HomeWork {
    public static void main(String[] args) {
///1. Отфильтровать чётные числа
//    Условие:
//    Есть список чисел. Оставь только чётные числа и выведи их.
//
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumber = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumber);
        //  [2, 4, 6]

///       2. Преобразовать строки в верхний регистр
//        Условие:
//        Есть список слов. Сделай их заглавными.
//
        List<String> words = Arrays.asList("java", "stream", "lambda");
        List<String> toUpperCase = words.stream()
                .map(n -> n.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(toUpperCase);
        //[JAVA, STREAM, LAMBDA]

        /// 2. Преобразовать строки в верхний регистр только первые буквы
        List<String> words2 = Arrays.asList("java", "stream", "lambda");
        List<String> toUpperCase2 = words.stream()
                .map(n -> n.substring(0, 1).toUpperCase() + n.substring(1).toLowerCase())
                .collect(Collectors.toList());
        System.out.println(toUpperCase2);
///        3. Посчитать количество строк длиннее 3 символов
//        Условие:
//        Сколько строк длиннее 3 символов?

        List<String> list = Arrays.asList("sun", "moon", "sky", "star");
        Long count = list.stream()
                .filter(n -> n.length() > 3)
                .count();
        System.out.println(count);

///        4. Найти сумму всех чисел в списке
//        Условие:
//        Посчитай сумму всех элементов списка.

        List<Integer> nums = Arrays.asList(10, 20, 30, 40);
        int sum = nums.stream()
                .mapToInt(n -> n)
                .sum();
        System.out.println(sum);
///       5. Получить список квадратов чисел
//        Условие:
//        Преобразуй список: каждое число возвести в квадрат.

        List<Integer> nums1 = Arrays.asList(1, 2, 3, 4, 5);
        int kvadrat = nums1.stream()
                .mapToInt(n -> n * n)
                .sum();
        System.out.println(kvadrat);

//        Задача 1: Удалить дубликаты и отсортировать
//        Условие:
//        У тебя есть список с повторами. Удали дубликаты, отсортируй по возрастанию и выведи.

        List<Integer> nums2 = Arrays.asList(3, 5, 2, 3, 7, 5, 1);
        List<Integer> nums3 = nums2.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(nums3);

//Задача 2: Найти самое длинное слово
//Условие:
//Из списка слов найди самое длинное.
//
        List<String> words1 = Arrays.asList("java", "stream", "lambda", "wow", "functionality");
        OptionalInt maxlenght = words1.stream()
                .mapToInt(String::length)
                .max();
        System.out.println(maxlenght);





    }
}
