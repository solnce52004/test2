package multithreading.syncronizers;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchEx {
    private static CountDownLatch countDownLatch = new CountDownLatch(3);

    private static void action1(){
        try {
            System.out.println("action1 start...");
            Thread.sleep(2000);
            countDownLatch.countDown();
            System.out.println("action1 end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void action2(){
        try {
            System.out.println("action2 start...");
            Thread.sleep(3000);
            countDownLatch.countDown();
            System.out.println("action1 end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void action3(){
        try {
            System.out.println("action3 start...");
            Thread.sleep(4000);
            countDownLatch.countDown();
            System.out.println("action1 end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Friends("Bob", countDownLatch);
        new Friends("Mary", countDownLatch);
        new Friends("Jane", countDownLatch);
        new Friends("Lesley", countDownLatch);
        new Friends("Nike", countDownLatch);
        new Friends("Albert", countDownLatch);

        action1();
        action2();
        action3();
    }
}

class Friends extends Thread{
    private String name;
    private CountDownLatch countDownLatch;

    Friends(String name, CountDownLatch countDownLatch){
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println(name + " get action...");
        } catch (InterruptedException e) {
            e.printStackTrace();
            this.interrupt();
        }
    }
}
