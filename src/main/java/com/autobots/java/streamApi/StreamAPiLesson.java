package com.autobots.java.streamApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPiLesson {
    public static void main(String[] args) {
       List<String> names = List.of("Anna","Bob","Alex","Bella","Andrew");

//        for (String name : names ){
//            if (name.startsWith("A")){
//                System.out.println(name);
//            }
//
//        }


        List<String>result =names.stream()
                .filter(name->name.startsWith("A")) // фильтрация по условиям
                .map(String :: toUpperCase)               // upper case
                .sorted()                             // сортировка
                .collect(Collectors.toList());        // мы положили в список чтобы сохранить результат этих данных
        System.out.println(result);                   // вывод

    List <Integer > numbers = List.of(1,2,3,4,5,6);
    int r1=0;
    for (int num:numbers){
        r1+=num;
    }
    System.out.println(r1);

    int totalSum= numbers.stream()      // обращаемся к коллекции и хотим сохранить Totalsum stream -перебирает под капотом for
            .mapToInt(num->num)// Большой Int на int
            .sum();
        System.out.println(totalSum);

     int TotalElements =(int)numbers.stream()
             .count();
        System.out.println(TotalElements);

     numbers.stream()
             .min(Integer::compareTo)
             .ifPresent(System.out::println);

     List<String> list =List.of("one","two","three","Hello","four","five");
     list.stream()
             .filter(s->s.length()>3)
             .findFirst()
             .ifPresent(System.out::println);

        List<Employee> employees = List.of(
                new Employee(1, "Alice", 28, 3000, "IT"),
                new Employee(2, "Bob", 35, 4000, "HR"),
                new Employee(3, "Charlie", 40, 5000, "Finance"),
                new Employee(4, "David", 25, 3500, "IT"),
                new Employee(5, "Eva", 30, 4200, "Marketing"),
                new Employee(6, "Frank", 45, 6000, "Finance"),
                new Employee(7, "Grace", 32, 4100, "HR"),
                new Employee(8, "Henry", 29, 3900, "IT"),
                new Employee(9, "Isabel", 38, 4500, "Marketing"),
                new Employee(10, "Jack", 27, 3600, "IT")
        );








        Map<String,List<Employee>> employeebyDepartman =employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
       employeebyDepartman.forEach((department,list1 )->{
           System.out.println("Отдел: "+ department);
           list1.forEach(System.out::println);
       });
        System.out.println("-----Usual Addition----");

        Map<String, List<Employee>> employeesByDepartment2 = new HashMap<>();
        for (Employee employee : employees){
            employeesByDepartment2.putIfAbsent(employee.getDepartment(), new ArrayList<>());
            employeesByDepartment2.get(employee.getDepartment()).add(employee);
        }
        for (Map.Entry<String, List<Employee>> entry : employeesByDepartment2.entrySet()){
            System.out.println(entry.getKey() + "\n" + entry.getValue());
        }

        System.out.println("-----Usual Addition----");



        List<Employee> ITEmployee=employees.stream()
                .filter(s->s.getDepartment().equalsIgnoreCase("IT"))
                .collect(Collectors.toList());
        System.out.println(ITEmployee);

        List<Employee> ItEmployee2=new ArrayList<>();
        for (Employee employee:employees){
            if (employee.getDepartment().equalsIgnoreCase("IT")){
                ItEmployee2.add(employee);
            }
        }
        System.out.println(ItEmployee2);



    }
}
