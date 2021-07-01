package access_modifiers;

import access_modifiers.employees.Doctor;
import access_modifiers.employees.Employee;
import access_modifiers.employees.Teacher;

public class MainOop {
    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.eat();//Employee eats Food

        /////////
        //doctor
        Doctor doctor = new Doctor();
        //метод переопределен
        //и возвращаемый тип - наследник типа базового метода
        doctor.eat();//Doctor eats Fruits
        doctor.printAccess();

        //референс-переменная базового типа ссылается на объек-наследник
        Employee emplDoctor = new Doctor();
        //метод перезаписан
        //метод есть и в базовом и в наследнике
        //будет вызван метод класса ОБЪЕКТА, НА КОТ ссылается референс-переменная
        emplDoctor.eat();//Doctor eats Fruits

        //уже нельзя вызвать!
        //т.к. нет доступа к методу базового класса
        // хотя в наследнике доступ изменен на публичный!
//        emplDoctor.printAccess();

        ////////
        //tacher
        Teacher teacher = new Teacher();
        //метод перезаписан
        //но возвращаемы тип НЕ ИЗМЕНЯЛСЯ
        teacher.eat();//Teacher eats Food
        teacher.printAccessPublic();

        Employee emplTeacher = new Teacher();
        //метод перезаписан
        //но возвращаемы тип НЕ ИЗМЕНЯЛСЯ
        //метод есть и в базовом и в наследнике
        //но будет вызван метод из класса ОБЪЕКТА, а не класса референс-переменной
        emplTeacher.eat();

        //доступ был изменен, но по прежнему обращение к методу класса переменной?
//        emplTeacher.printAccessPublic();
    }
}
