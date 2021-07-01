package init_blocks;

public class InitsMain2 {
    int a = 1;

    {a = 2;}

    InitsMain2(){
        a = 3;
    }


    public static void main(String[] args) {
        InitsMain2 initsMain2 = new InitsMain2();
        System.out.println(initsMain2.a);//3
    }
}


class A{

    final static int a;//-определяется, когда загружается класс
    int nonStatic;//-определяется, когда создается объект класса

    static {
        a = 5;//тут можно проинициализировать!!!
//        nonStatic = 10;//нельзя обратиться к не статичной!
    }
}