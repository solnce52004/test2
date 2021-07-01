package access_modifiers.xy;

public class X {
    public X(){
        System.out.println("X");
    }
    public X(int i){
        System.out.println("X-" + i);
    }

    /**
     * private - не наследуется - поэтому если тип ссылки этот (родит) класс
     * то сработает compile type binding
     * - в классе (дочерн) объекта поиска аналогичного метода в runtime не будет
     *
     * @return
     */
    private boolean abc(){
        return false;
    }

    public static void main(String[] args) {
        X xy = new Y(18);
        System.out.println(xy.abc());
    }
}

class Y extends X{
    public Y(int i) {
        // super(); - вызовется неявно!!!
        System.out.println("Y-" + i);
    }

    public boolean abc(){
        return true;
    }
}
