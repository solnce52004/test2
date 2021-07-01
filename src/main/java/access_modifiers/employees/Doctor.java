package access_modifiers.employees;

import access_modifiers.foods.Fruits;

public class Doctor extends Employee {

    /**
     * при перезаписи метода в наследнике
     * можно менять возвращаемый тип
     * но только на sub-класс!!! базового метода
     *
     *  Примитивных типов это не касается!!!
     *  если в базовом классе метод возвращал int,
     *  то и в наследнике должен возвращаться int!!!
     *
     *  access modifier в наследниках - такой же или менее строгий!!!
     *
     * @return Fruits
     */
    @Override
    public Fruits eat() {
        System.out.println("Doctor eats Fruits");
        return new Fruits();
    }

    @Override
    public void printAccess() {
        System.out.println("Doctor has access public");
    }

    /**
     * static  - значит будет compile binding - будет hiding
     * базовый статичный метод будет скрыт этим методом для данного child класса
     *
     * если убрать static из базового и дочернего метода,
     * то и базовом методе getInfoEmployee() будет вызываться дочерний @Override метод
     * getName() - он уже будет считаться Override + будет runtime binding(в кот будет поиск метода в классе ОБЪЕКТА)
     *
     * @return String
     */
    static String getName(){
        return "Doctor";
    }

    /**
     * будет вызван статич метод этого класса,
     * а не базового
     */
    void getInfoDoctor(){
        System.out.println("info of " + getName());
    }
}
