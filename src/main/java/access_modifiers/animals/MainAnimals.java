package access_modifiers.animals;

public class MainAnimals {
}

class Animals {
    /**
     * метод будет вызван при compile type binding для класса референс-переменной,
     * т.к. указан static - аналогичный метод в дочернем классе объекта (на кот ссылается переменная с типом родителя)
     * искаться не будет при вызове внутри класса
     * <p>
     * (наследоваться static не может - только перекрыться
     * - но в таком случае перекрывающий метод будет использоваться только при вызове на тот класс-наследник, где перекрывающий метод)
     *
     * @return String
     */
    static String getName() {
        return "Animals";
    }

    void printNameAnimals() {
        System.out.println("Name: " + getName());
    }
}

class Mouse extends Animals {
    static String getName() {
        return "Mouse";
    }

    /**
     * Overloaded method!!! были изменены передаваемые параметры
     * @param n имя мышки
     * @return String
     */
    static String getName(String n) {
        return n;
    }


    public static void main(String[] args) {
        Animals am = new Mouse();
        am.printNameAnimals();
        Mouse.getName("khkjkhk");
    }
}