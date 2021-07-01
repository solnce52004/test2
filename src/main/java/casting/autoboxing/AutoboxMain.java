package casting.autoboxing;

public class AutoboxMain {
    void abc(int a) {
        System.out.println("int");//1
    }

    //близжайший тип
    void abc(long a) {
        System.out.println("long");//2
    }

    //autoboxing
    void abc(Integer a) {
        System.out.println("Integer");//3
    }

    //1-to Integer - (autoboxing)
    //2-to Object - (конвертация)
    void abc(Object a) {
        System.out.println("Object");//4
    }



    //конвертация (в другой бл тип) в 2 этапа недопустима
    //1-to long
    //2-to Long
    void abc(Long a) {
        System.out.println("Long");// error! (только 50L)
    }


    /*
    * int
    * long
    *
    * Integer
    * Object
    *
    * Long (только 50L)
    * */

    public static void main(String[] args) {
        new AutoboxMain().abc(50);
    }
}
