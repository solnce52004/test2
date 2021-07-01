package access_modifiers.employees5;

import access_modifiers.print_access.PrintAccess;

public class Doctor extends PrintAccess {
    public static void main(String[] args) {
        PrintAccess edoc = new Doctor();

        /* А вот в наследниках класса protected-члены родительского класса можно увидеть
         только если мы используем this или super.
         Если же мы обращаемся к переменной-ссылке на экземпляр родительского класса,
         то к его protected-членам доступа не будет. */

//        edoc.printAccess();

        Doctor doctor = new Doctor();
        doctor.printAccess();

    }

    /**
     * в parent-классе - protected (и метод в др. пакете)
     */
    @Override
    public void printAccess() {
        // вот он доступ к protected из др пакета для наследника
        // но только через super!!!
        // а не через экземпляр parent-класса!!!
        super.printAccess();


        System.out.println("Doctor has access public");
    }
}
