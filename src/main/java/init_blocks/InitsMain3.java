package init_blocks;

public class InitsMain3 {
    public static void main(String[] args) {
//        Animal animal = new Animal();
        /*
        * static Animal
        * non-static Animal
        * constructor Animal
        * */

        Animal lion = new Lion();
        /*
        При загрузке класса
        Сперва вызываются статич инит блоки всех родит классов!

        static Animal
        static Mammal
        static Lion


        При создании объекта - также все для родит классов!

        non-static Animal
        constructor Animal

        non-static Mammal
        constructor Mammal

        non-static Lion
        constructor Lion
        */
    }
}

class Animal {
    static {
        System.out.println("static Animal");
    }

    {
        System.out.println("non-static Animal");
    }

    Animal() {
        System.out.println("constructor Animal");
    }
}

class Mammal extends Animal {
    static {
        System.out.println("static Mammal");
    }

    {
        System.out.println("non-static Mammal");
    }

    Mammal() {
        System.out.println("constructor Mammal");
    }
}

class Lion extends Mammal {
    static {
        System.out.println("static Lion");
    }

    {
        System.out.println("non-static Lion");
    }

    Lion() {
        System.out.println("constructor Lion");
    }
}