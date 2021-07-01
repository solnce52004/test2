package access_modifiers.animals_static;

public class MainStaticAnimals {
}

class Animals{
    String getName(){
        return "Animals";
    }

    void printNameAnimals(){
        System.out.println("Name: " + getName());
    }
}

class Mouse extends Animals{
    /**
     * будет вызван этот метод при runtime type binding
     *
     * @return
     */
    @Override
    String getName(){
        return "Mouse";
    }

    public static void main(String[] args) {
        Animals am = new Mouse();
        am.printNameAnimals();
    }
}