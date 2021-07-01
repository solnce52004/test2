package vars;

import lombok.extern.java.Log;
import vars.*;
import static vars.VarsClass.b;// импорт статич переменной
import vars.sub.SubClass;

@Log
public class MainVarsClass {

//    static int b = 8;

    public static void main(String[] args) {
        VarsClass var = new VarsClass(3);

        var.printAllVars();
        var.printAllVarsF();
        log.severe(String.valueOf(b));

        SubClass.get();
    }
}
