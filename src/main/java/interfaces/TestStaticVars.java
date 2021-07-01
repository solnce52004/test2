package interfaces;

public class TestStaticVars {
    public static void main(String[] args) {

        I it = new Test();
        Test t = new Test();

        it.printName();
        t.printName();

        t.printNameTest();
    }
}

interface I {
    String name = "I name";

    default void printName() {
        System.out.println(name);
    }
}

class Test implements I {
    static String name = "Test name";

//    @Override
//    public void printName() {
//        System.out.println(name);
//    }
        public void printNameTest() {
        System.out.println(name);
    }
}