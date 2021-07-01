package multithreading;

public class SyncObj {
    public static void main(String[] args) {
        var t1 = new Thread2();
        var t2 = new Thread2();

        t1.start();
        t2.start();
    }
}



class Thread2 extends Thread{
    //    volatile
    int counter = 0;//volatile???

    void increment(){
//        synchronized (this){
        System.out.println("inc " + counter);
        counter++;
//        }
    }

    @Override
    public void run() {
        for (var i = 0; i < 100; i++) {
            SyncClassEx.increment();
        }
    }
}