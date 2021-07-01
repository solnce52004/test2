package interfaces.multiple_default_impls.interfaces;

public interface I2 {
    default void get(){
        System.out.println("I2");
    }
}
