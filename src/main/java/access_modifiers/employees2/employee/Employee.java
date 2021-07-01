package access_modifiers.employees2.employee;

import lombok.Getter;
import lombok.Setter;
import access_modifiers.foods.Food;

@Setter
@Getter
public class Employee {
    private int salary = 100;
    int salaryValue = 100;

     public Food eat() {
        System.out.println("Employee eats Food");
        return new Food();
    }

    /**
     * private не наслеуются
     * protected - значит доступен для наследников, даже если те - в др пакете
     */
    protected void printAccess(){
        System.out.println("access protected");
    }

    protected void printAccessPublic(){
        System.out.println("access protected or default");
    }

    static String getName(){
        return "Employee";
    }

    public void getInfoEmployee(){
        System.out.println("info of " + getName());
    }
}
