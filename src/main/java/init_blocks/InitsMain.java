package init_blocks;

public class InitsMain {
    {
        int a = 5;
        System.out.println("init 1 " + a);//2, 4
    }

   static  {
        int a = 5;
        System.out.println("init 2 STATIC " + a);//1
    }


    public InitsMain(){
        System.out.println("constructor 1");//3
    }

    public InitsMain(int a) {
        this();//вызовет еще раз первый косруктор без параметров
        System.out.println("constructor 2 " + a);//5
    }

    public static void main(String[] args) {
        InitsMain initsMain1 = new InitsMain();
        InitsMain initsMain2 = new InitsMain(10);
    }
}
