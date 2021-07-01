package access_modifiers.employees4;

public class Doctor extends EmployeeParentClass {
    public static void main(String[] args) {
        //////binding
        Doctor doc = new Doctor();
        doc.printAccess();//Doctor has access public - вывод из override-метода

        EmployeeParentClass edoc = new Doctor();
        edoc.printAccess();
    }

    @Override
    public void printAccess() {
        System.out.println("Doctor has access public");
    }
}
