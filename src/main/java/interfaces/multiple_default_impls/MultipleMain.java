package interfaces.multiple_default_impls;

import interfaces.multiple_default_impls.interfaces.I1;
import interfaces.multiple_default_impls.interfaces.I2;

public class MultipleMain {
    public static void main(String[] args) {
        Test test = new Test();
        test.get();
    }
}

class Test implements I1, I2 {

    /**
     * "Test inherits unrelated defaults for get() from types"
     * Если совпадают дефолтные методы в имплементированных интерфейсах
     * то необходимо ОБЯЗАТЕЛЬНО переопределить этот метод в классе-имплементаторе
     */
    @Override
    public void get() {
        System.out.println("Test");
    }
}