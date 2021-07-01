package strings.str;

public class StringBuilders {
    public static void printStrBuilders() {
        StringBuilder sb1 = new StringBuilder();//capacity default = 16
        StringBuilder sb2 = new StringBuilder("Hello!");//capacity = 16 + 6 = 22
        StringBuilder sb22 = new StringBuilder("Hello!");//capacity = 16 + 6 = 22
        StringBuilder sb3 = new StringBuilder(sb2);//capacity


        System.out.println("StringBuilders:");
        System.out.println(sb1.capacity());
        System.out.println(sb2.capacity());
        System.out.println(sb3);// копия
        System.out.println(sb3.capacity());

        //сравнение на равенство
        System.out.println(sb2 == sb22);//false - разные ссылки на разные объекты
        System.out.println("StringBuilder equals: " + sb2.equals(sb22));//false - метод не переопределен (работает как "=="), как в стринг, сравнеиние по ссылкам

        //НО
        String s2 = new String(sb2);
        String s22 = new String(sb22);
        System.out.println("StringBuilder equals (to type Str): " + s2.equals(s22));
    }
}
