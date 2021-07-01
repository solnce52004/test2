package access_modifiers.print_access;

public class PrintAccess {
    /**
     * private не наслеуются.
     *
     * protected - значит доступен
     * для всех в пакете,
     * либо для наследников, даже если те - в др пакете
     */
    protected void printAccess() {
        System.out.println("access protected");
    }
}


class LocalDoctor1 {
    public static void main(String[] args) {
        PrintAccess printAccess = new PrintAccess();
        //вот обычный доступ для постороннего класса в одном пакете
        printAccess.printAccess();//работает родитель
    }
}
class LocalDoctor2 {
    public static void main(String[] args) {
        PrintAccess printAccess = new LocalDoctor();
        //вот доступ для ссылки типа родителя НА наследника, но в одном пакете с ним
        printAccess.printAccess();//отработает наследник!!!
    }
}

class LocalDoctor extends PrintAccess{
    public static void main(String[] args) {
        PrintAccess localDoctor = new LocalDoctor();
        // в одном пакете компилятор ищет метод в классе референс-переменой
        //(если protected
        // - доступ для всех в пакете - метод виден по-любому - из объектов (неважно где созданных - в наследниках или сторонних классах в том же пакете - главное в рампах пакета)
        // и через super для наслед
        // - в другом пакете - виден наследникам через super
        // (через создание объекта не может быть виден, при обращении через свеже-созданный объект родит класса, даже в методе потомка - почему????)
        // )
        // потом на этапе выполнения смотрит, есть ли аналогичный метод в объекте (перезаписанный)
        // если есть, то выполняет
        localDoctor.printAccess();//работает наследник (т.к. все в одном пакете!!!)

        PrintAccess printAccess = new PrintAccess();
        //вот доступ для ссылки типа родителя из наследника, но в одном пакете с ним
        printAccess.printAccess();// работает родитель
    }

    @Override
    public void printAccess() {
        super.printAccess();
        System.out.println("LocalDoctor has access public");
    }
}
