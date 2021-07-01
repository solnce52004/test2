package multithreading;

public class SyncClassEx {

    static int counter = 0;

    static void increment(){
        synchronized (SyncClassEx.class){
            System.out.println("inc " + counter);
            counter++;
        }
    }


    public static void main(String[] args) {
        var t1 = new Thread1();
        var t2 = new Thread1();

        t1.start();
        t2.start();
    }
}

class Thread1 extends Thread{
    @Override
    public void run() {
        for (var i = 0; i < 100; i++) {
            SyncClassEx.increment();
        }
    }
}