package access_modifiers.employees;

public class MainEmployeesClass {
    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.eat();//Employee eats Food

        /////////
        //doctor
        Doctor doctor = new Doctor();
        //метод переопределен
        doctor.printAccess();

        //референс-переменная базового типа ссылается на объек-наследник
        Employee emplDoctor = new Doctor();
        //метод перезаписан
        //метод есть и в базовом и в наследнике
        //будет вызван метод класса ОБЪЕКТА, НА КОТ ссылается референс-переменная
        //можно проверить изменение доступа при перезаписи, если в одном пакете!!!
        // в др пакетах можно будет проверить только public (почему?)!
        emplDoctor.printAccess();

        ////////
        //tacher
        Teacher teacher = new Teacher();
        //метод перезаписан
        teacher.printAccessPublic();

        Employee emplTeacher = new Teacher();
        //метод перезаписан
        //но возвращаемы тип НЕ ИЗМЕНЯЛСЯ
        //метод есть и в базовом и в наследнике
        //но будет вызван метод из класса ОБЪЕКТА, а не класса референс-переменной

        //доступ был изменен,
        // но по прежнему обращение к методу класса переменной на этапе компиляции!
        // поэтому ИДЕ будет ругаться если вызывать из другогопакета
        // для переменной базового типа метод,
        // даже если он переопределен в наследнике на публичный - это будет проверяться уже в runtime!!!!
        // но до него не сможем скомпилиться, если доступ родительского слишком строгий
        emplTeacher.printAccessPublic();


        //////binding
        Doctor doc = new Doctor();
        doc.getInfoEmployee();
        doc.getInfoDoctor();

//        Employee edoc = new Doctor();
//        edoc.getInfoEmployee();
//        edoc.getInfoDoctor();
//        ((Doctor) edoc).getInfoDoctor();


    }
}
