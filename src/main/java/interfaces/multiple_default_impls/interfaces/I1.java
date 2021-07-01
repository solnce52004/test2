package interfaces.multiple_default_impls.interfaces;

public interface I1 {
    default void get() {
        System.out.println("I1");
    }
}
