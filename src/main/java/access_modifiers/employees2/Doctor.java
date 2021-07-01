package access_modifiers.employees2;

import access_modifiers.employees2.employee.Employee;
import access_modifiers.foods.Fruits;

public class Doctor extends Employee {
    public static void main(String[] args) {
        //////binding
        Doctor doc = new Doctor();

        doc.eat();
        doc.eat(1.1);

        doc.getInfoEmployee();//info of Employee - внутри вызовется статич БАЗОВЫЙ метод
        doc.getInfoDoctor();//info of Doctor - внутри вызовется статич НАСЛЕДН метод

        //если закоментить override - будет вывод из БАЗОВОГО protected метода
        doc.printAccess();//Doctor has access public - вывод из override-метода

        /////////////////////
        Employee edoc = new Doctor();

        edoc.getInfoEmployee();//info of Employee
//        edoc.getInfoDoctor();// - нет такого же метода у наследника типа ссылки

        //родитель в другом пакете!
        //нужна кастомизация, чтобы вызвать перезаписанный метод с измененным на публичный квалификатором
        //т.к. биндинг произойдет только в рантайме, а пока компилятор ищет аналогичный метод в классе референс-переменной,
        // там protected
        // мы в main наследника (хоть и в другом пакете)
        // почему не виден метод????
//        edoc.printAccess();

        Doctor doctor = new Doctor();
        System.out.println(doctor.salaryValue);//dvdvdv
    }

    /**
     * hiding!!!
     * поле с таким же НАЗВАНИЕМ (хотя и с другим типом + статичное)
     * скрыло одноименное поле базового класса
     * <p>
     * (если закоментить - выведется базовое поле)
     */
    static String salaryValue = "dvdvdv";

    /**
     * при перезаписи метода в наследнике
     * можно менять возвращаемый тип
     * но только на sub-класс!!! базового метода
     * <p>
     * В данном примере <? extends Food>, т.е. Fruits
     * <p>
     * Примитивных типов это не касается!!!
     * если в базовом классе метод возвращал int,
     * то и в наследнике должен возвращаться int!!!
     * <p>
     * access modifier в наследниках - такой же или менее строгий!!!
     *
     * @return Fruits
     */
    @Override
    public Fruits eat() {//можно указать возвращаемый тип Food, возвращая Fruits (т.к. <Fruits extends Food>)
        // - ковариантный return type
        System.out.println("Doctor eats Fruits");
        return new Fruits();
    }

    /**
     * данный метод уже OVERLOAD - перезагружен - добавление еще одного с другими параметрами
     *
     * @param b
     * @return
     */
    public Fruits eat(Double b) {
        System.out.println("Doctor eats Fruits " + b);
        return new Fruits();
    }

    /**
     * в parent-классе - protected (и метод в др. пакете)
     */
    @Override
    public void printAccess() {
        System.out.println("Doctor has access public");
    }

    /**
     * static  - значит будет compile binding - будет hiding
     * базовый статичный метод будет скрыт этим методом для данного child класса
     * <p>
     * если убрать static из базового и дочернего метода,
     * то и базовом методе getInfoEmployee() будет вызываться дочерний @Override метод
     * getName() - он уже будет считаться Override + будет runtime binding(в кот будет поиск метода в классе ОБЪЕКТА)
     *
     * @return String
     */
    static String getName() {
        return "Doctor";
    }

    /**
     * будет вызван статич метод этого класса,
     * а не базового
     */
    public void getInfoDoctor() {
        System.out.println("info of " + getName());
    }
}
