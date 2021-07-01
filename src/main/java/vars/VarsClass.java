package vars;

public class VarsClass {
    public char a;//auto
    public static int b;//auto

    public final int c;//now|constructor
    public static final int d = 0;//now!


    public VarsClass(int c) {
        this.c = c;
    }

    public void printAllVars () {
        System.out.println(
                String.format(
                        "%s, %s, %s, %s",
                        this.a,
                        b,
                        this.c,
                        VarsClass.d
                )
        );
    }

    public void printAllVarsF () {
        System.out.printf(
                        "%s, %s, %s, %s",
                        this.a,
                        b,
                        this.c,
                        VarsClass.d
        );
    }
}
