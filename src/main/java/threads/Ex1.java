package threads;

import lombok.SneakyThrows;

public class Ex1 {
    public static void main(String[] args) throws InterruptedException {
        //Thread t1 = new CustomThread1();
        CustomThread1 t1 = new CustomThread1();
        CustomThread2 t2 = new CustomThread2();


        System.out.println(Thread.currentThread().getName());

        System.out.println(t1.getState());//
        t1.start();
        System.out.println(t1.getState());//

        t1.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t1.getState());//

        t2.start();

        t1.join();
        System.out.println(t1.getState());//

        t2.join();
        System.out.println("MAIN ext...");
        System.out.println();

        Thread t3 = new Thread(new ImplThread1());
        Thread t4 = new Thread(new ImplThread2());

        t3.start();
        t4.start();

        t3.join();
        t4.join();
        System.out.println("MAIN impl...");
    }



}

class CustomThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("CustomThread1: " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class CustomThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("2: " + i);
        }
    }
}
class ImplThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("CustomThread1: " + i);
        }
    }
}

class ImplThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("2: " + i);
        }
    }
}