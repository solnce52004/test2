package strings;

import lombok.extern.java.Log;
import strings.str.StrClass;
import strings.str.StrIter;
import strings.str.StringBuffers;
import strings.str.StringBuilders;

import java.util.Arrays;

@Log
public class MainStringsClass {
    public static void main(String[] args) {
        try {
            char[] arr = StrClass.arr;
            for (char c : arr) {
                System.out.println(c);
            }

//            Arrays.stream(arr).forEach(a -> log.info(String.valueOf(a)));

//            char ch = StrClass.ch;
//            System.out.println("ch=" + (int)ch + ";");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // ниже будет создано 4 новых объекта
        String s1 = new String("hello");
        String s12 = new String("hello");

        System.out.println("сравниваем ССЫЛКИ на объект " + (s1 == s12));// сравниваем ССЫЛКИ на объект (новый или в пуле)
        System.out.println("сравниваем ЗНАЧЕНИЯ " + s1.equals(s12));// сравниваем ЗНАЧЕНИЯ (метод перегружен)

        String s2 = "hello";//сперва будет проверка на наличие объекта с таким значеним в String Constant Pool
        String s3 = "Hello";

        // тут уже не будет создан новый объект,
        // будет созана еще одна ссылка на уже имеющийся
        // в string const pool
        String s32 = "Hello";
        Boolean b = s3 == s32;// =>true, т.к. это 2 ссылки на 1 объект
        System.out.println("сравниваем ССЫЛКИ на объект " + (s3 == s32));// сравниваем ССЫЛКИ на объект (новый или в пуле)
        System.out.println("сравниваем ЗНАЧЕНИЯ " + s3.equals(s32));// сравниваем ЗНАЧЕНИЯ


        String nullString = null;
        nullString += 5;//"null5"
        System.out.println(nullString);

//        System.out.println(null + false);// error!

        // создается массив char (final privat)
        // String - IMMUTABLE!!!
        String s5 = new String("Hello world!");
        // ни один метод не меняет значение,
        // из всех методов String возвращаются измененные копии массива char


        //trim - создаст новый объект? если сделает изменения (будет ссылаться на новый созданный объект)
        // если изменений не сделает - вернет текущий обект (ссылка не изменится)
        String st0 = "ghgh";
        String st1 = "ghgh";
        System.out.println("trim: " + (st0 == st1.trim()));

        //chain
        String s6 = new String("Uraaaaa!!!");
        String s7 = s5.concat(s6)
                .trim()// метод вернет СТАРЫЙ объект, если не сделал изменений
                .replace("Uraaaaa", "Ура")
                .substring(6, 10);
        System.out.println(s7);


        // iteration
        StrIter.printIter();

        //StringBuilder - MUTABLE!!!
        StringBuilders.printStrBuilders();
        //StringBuffers - MUTABLE!!!МНОГОПОТОЧНОСТЬ!!!
        StringBuffers.printStrBuffers();

        //isEmpty
        StrClass.printStr();
    }
}
