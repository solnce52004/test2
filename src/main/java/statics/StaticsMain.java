package statics;

public class StaticsMain {
    static int a = 5;

    public static void main(String[] args) {
        StaticsMain st = new StaticsMain();

        System.out.println(st.a);

        st = null;

        System.out.println(st.a);//так можно!!! - compile type binding
    }
}
