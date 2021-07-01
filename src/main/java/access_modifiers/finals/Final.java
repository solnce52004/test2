package access_modifiers.finals;

public class Final {
    public static void main(String[] args) {
        Teacher.getName();
    }
}

class Employee {
    private static String name = "Employee";

    /**
     * static - в потомке нельзя Override - это будет уже создание нового метода (hiding)
     * <p>
     * если поставить final - можно увидеть некорректную ошибку компилятора
     * "getName()' cannot override 'getName()' in 'oop.finals.Employee'; overridden method is final"
     * <p>
     * дело в том, что мы и не могли сделать override на статический метод
     * мы могли сделать только хиддинг
     *
     * @return
     */
    static String getName() {
        System.out.println(Employee.name);
        return Employee.name;
    }
}

class Teacher extends Employee {
    /**
     * метод не Override, а hidden - родительский скрыт этим методом потомка
     *
     * @return
     */
//    @Override
    static String getName() {
        //super.getName() - нельзя
        return Employee.getName();
    }
}