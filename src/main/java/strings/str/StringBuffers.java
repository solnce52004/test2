package strings.str;

public class StringBuffers {
    public static void printStrBuffers() {
        StringBuilder stBuilder = new StringBuilder("Hello");
        StringBuffer stBuffer = new StringBuffer("Hello");

        System.out.println("StringBuffers:");
        System.out.println(new String(stBuilder));//можно передавать как параметр при создании объекта String
        System.out.println(new String(stBuffer));
    }
}
