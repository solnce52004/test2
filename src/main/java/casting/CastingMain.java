package casting;

public class CastingMain {
    public static void main(String[] args) {
        T30 t30 = new T30();

        //переменные - кастинг работает - т.к. скрываются при переопределении
        //compile type binding
        // - еще на этапе компиляции понятно, что переменную надо смотреть
        // в классе кастомизированной переменной
        t30.printA();//20
        System.out.println(t30.a);//30
        System.out.println(((T10) t30).a);//10
        System.out.println(((T20) t30).a);//20

        //методы - в методе кастинг не работает
        //runtime type binding
        // методы были @Override в каждом наследнике
        // поэтому будут вызваны для класса объекта
        // в runtime type binding,
        // на который указывает референс-переменная при объявлении
        t30.abc();//T30
        ((T10)t30).abc();//T30
        ((T20)t30).abc();//T30
    }
}


class T10{
    int a = 10;
    void abc(){
        System.out.println("T10");
    }
}
class T20 extends T10{
    int a = 20;

    @Override
    void abc(){
        System.out.println("T20");
    }
}
class T30 extends T20{
    int a = 30;

    @Override
    void abc(){
        System.out.println("T30");
    }

    void printA(){
        System.out.println(super.a);//доступ к T20
    }
}