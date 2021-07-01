package abstracts;

import org.w3c.dom.ls.LSOutput;

public class AbstractMain {
    public static void main(String[] args) {
        System.out.println(Figure.name);

        Figure fr = new Rectangle();//мет,кот счит перезапис, вызовутся у объекта
        Rectangle r = new Rectangle();

        //call implemented abstract method
        System.out.println(fr.getName());
        System.out.println(r.getName());

        //call simple override method
        System.out.println(fr.getCount());
        System.out.println(r.getCount());

        //call static hidden method
        Figure.printClassName();
        Rectangle.printClassName();


        //////////
        //create with parametrized constructors
        Figure fr2 = new Rectangle(80);
        Rectangle r2 = new Rectangle(90);

        System.out.println(fr2.getName());
        System.out.println(r2.getName());


        //
        r.test();
        r2.test();
    }
}

abstract class Figure {
    static String name = "dsdfs";
    int count;

    public Figure() {
        count = 30;
    }

    public Figure(int i) {
        count = i;
    }

    abstract String getName();

    int getCount() {
        return this.count;
    }

    static void printClassName() {
        System.out.println(Figure.class);
    }
}

class Rectangle extends Figure {
    //если не указан конструктор наследника -
    //в этом классе неявно вызывается коструктор,
    //в котором также неявно вызывается конструктор родителя

    public Rectangle() {
    }

    public Rectangle(int i) {
        //если сами не вызовем родит конструктор с парамеррами
        //то будет вызван родит без параметров - неявно
        super(i);
    }

    @Override
    String getName() {
        int c = super.count + 3;
        return "count " + c;
    }

    @Override
    int getCount() {
        return 10;
    }


    /**
     * static методы не могут быть перезаписаны
     * <p>
     * данный static метод скрывает родительский (hiding)
     */
    static void printClassName() {
        System.out.println(Rectangle.class);
    }


    ////////// inner class /////
    final static String s1 = "ffg34534345gdg";//статич константа
    private int p1 = 100;

    void test() {
        String s;

        class R {
            final static String s = "ffggdg";//статич константа

            void print() {
                System.out.println("Inner Local Class by method");
                System.out.println(s);
                System.out.println(s1);
                System.out.println(p1);
            }
        }

        R r = new R();
        r.print();
    }
}
