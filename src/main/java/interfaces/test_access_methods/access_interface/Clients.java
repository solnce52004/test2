package interfaces.test_access_methods.access_interface;

/**
 * интерфейсы могут иметь access modifier:
 * public
 * default (package)
 */
public interface Clients {
    void getType();
    default String getName(){
        return "Interf";
    }
}
