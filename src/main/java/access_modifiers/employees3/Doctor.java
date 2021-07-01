package access_modifiers.employees3;

public class Doctor extends Employee {
    public static void main(String[] args) {
        //////binding
        Doctor doc = new Doctor();
        doc.printAccess();//Doctor has access public - вывод из override-метода

        Employee edoc = new Doctor();
        edoc.printAccess();
    }

    @Override
    public void printAccess() {
        System.out.println("Doctor has access public");
    }
}

class Employee {
    /**
     * private не наслеуются
     */
     void printAccess(){
        System.out.println("access default");
    }
}