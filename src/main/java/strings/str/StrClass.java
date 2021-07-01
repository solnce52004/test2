package strings.str;

public class StrClass {
    public static char[] arr = new char[4];
//    public static int[] arr = {1,2, 3, 4};
    public static char ch;

    //обязательно статическая переменная (автоинициализация на NULL)
    //обычную переменную надо определить до первого использования
    private static String s;

    public static void printStr(){
//        System.out.println("Empty string: " + s.trim());// будет ошибка - нельзя вызвать метод на NULL
        System.out.println("Empty string: ");
        System.out.println(s);
//        System.out.println("isEmpty string: " + s.isEmpty()); // будет ошибка - нельзя вызвать метод на NULL
    }

}
