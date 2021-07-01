package access_modifiers.employees;

import lombok.Getter;
import lombok.Setter;
import access_modifiers.foods.Food;

@Setter
@Getter
public class Employee {
    private int salary = 100;

    protected void work() {
        System.out.println("work");
    }

     public Food eat() {
        System.out.println("Employee eats Food");
        return new Food();
    }

     void printAccess(){
        System.out.println("access protected");
    }

    protected void printAccessPublic(){
        System.out.println("access protected or default");
    }

    static String getName(){
        return "Employee";
    }

    void getInfoEmployee(){
        System.out.println("info of " + getName());
    }
}
