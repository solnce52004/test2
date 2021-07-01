package interfaces;

public class MainInterfacesClass {
    public static void main(String[] args) {
        Animals aCat = new Cat();
        Cat cat = new Cat();

        System.out.println("----simple-----");
        aCat.go();
        cat.go();

        System.out.println("----default----");
        aCat.eat();
        cat.eat();

        System.out.println("----static-----");
        Animals.sleep();
        Cat.sleep();

        System.out.println("----vars-----");
        System.out.println(Animals.tails);
        System.out.println(Cat.tails);
        cat.printTails();

        System.out.println("----inners-----");
        cat.getT();
        cat.getA();

        System.out.println("----inners-def----");
        aCat.getInnerTInMethodAnimal();
        cat.getInnerTInMethodAnimal();

    }

}

interface Animals {
    //public static final - поэтому и обращение д.б. как к статической константе
    int tails = 1;
    String headName = "Animal head";

    void go();

    default void eat() {
        System.out.println("default animal eats");
    }

    static void sleep() {
        System.out.println("static animal sleeps");
    }

    /////////////////////////
    ///// inner classes /////
    class T {
        int heads = 88;
        String getName() {
            return headName + " " + heads;
        }
    }
    abstract class A {
        int heads = 878979;//при имплементации не будет доступна
        abstract String getTail();
    }
    ////////////////////////

    default void getInnerTInMethodAnimal() {
        // вложенный в метод класс будет иметь больший приоритет
        // чем вложенный в классе с таким же именем
        class T {
            int heads = 55;
            String getName() {
                return headName + " " + heads;
            }
        }
        T t = new T();
        System.out.println(t.getName());
    }
}

class Cat implements Animals {
    //hiding
    String headName = "Cat head";

    @Override
    public void go() {
        System.out.println("cat goes - override");
    }

    @Override
    public void eat() {
        System.out.println("default CAT eats - override");
    }

    static void sleep() {
        System.out.println("static CAT sleeps - hiding");
    }

    void printTails() {
        //обращение как к статической константе
        System.out.println(Animals.tails);
        System.out.println(tails);
    }

    void getT() {
        T t = new T();
        int tHeads = t.heads;
        String tName = t.getName();

        System.out.println(tHeads);
        System.out.println(tName);
    }

    void getA() {
        class ImplA extends A {
            String getTail() {
//                A.heads//нет доступа
                return "A impl in Cat";
            }
        }

        A implA = new ImplA();
        String tail = implA.getTail();
        System.out.println(tail);
    }
}