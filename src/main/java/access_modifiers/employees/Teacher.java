package access_modifiers.employees;

import access_modifiers.foods.Food;

public class Teacher extends Employee{
    @Override
    public Food eat() {
//        return super.eat();

        System.out.println("Teacher eats Food");
        return new Food();
    }

    @Override
    public void printAccessPublic() {
        System.out.println("Teacher has access public");
    }
}
