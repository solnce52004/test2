package interfaces.test_access_methods.main_package;

import interfaces.test_access_methods.access_interface.Clients;

public class MainAccess {
    public static void main(String[] args) {
        Clients cg = new Girl();

        String name = cg.getName();
        System.out.println(name);
    }
}

class Girl implements Clients{

    /**
     * в наследнике при перезаписи/имплементации метода интерфейса
     * (по идеи в интерфейсе все методы - public)
     * НЕЛЬЗЯ изменить область видимости на package
     */
    @Override
    public void getType() {
    }

    /**
     * компилятор иногда тормозит и ошибка вылетает уже в рантайме...
     */
    @Override
     public String getName() {
        return "Girl";
    }
}