package func_interfaces;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class FuncMain {
    static void printFunction(
            ArrayList<Student> arr,
            Function<Student, String> func
    ) {
        for (Student s : arr) {
            System.out.println(func.apply(s));
        }
    }

    static void printPredicate(
            ArrayList<Student> arr,
            Predicate<Student> func,
            MyInterface<Student> myFunc
    ) {
        for (Student s : arr) {
//            if (func.test(s)) {
//                System.out.println(s.getName());
//            }
            //см переданные реализации из лямбд func либо myFunc
            if (func.or(myFunc).test(s)) {
                System.out.println(s.getName());
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Петя", 10));
        list.add(new Student("Вася", 20));
        list.add(new Student("Jhon", 30));
        list.add(new Student("Bobby", 40));

        printFunction(
                list,
                Student::getName
        );

        System.out.println("-------");

        printPredicate(
                list,
                s -> s.getAge() > 10,
                s -> s.getName().equals("Bobby")
        );

        /*
         * Вася
         * Jhon
         * Bobby
         * */

        System.out.println("-------");

//        list.removeIf(s -> s.getName().endsWith("я"));
//        list.forEach(s -> System.out.println(s.getName()));

    }
}

@FunctionalInterface
interface MyInterface<T> extends Predicate<T> {
    boolean test(T t);
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}