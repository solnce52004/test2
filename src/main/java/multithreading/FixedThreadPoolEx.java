package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FixedThreadPoolEx {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(5);
        for (int task = 0; task < 10; task++) {
            ex.execute(new CustomThread());
        }

        ex.shutdown();
        try {
            ex.awaitTermination(8, TimeUnit.SECONDS);
            System.out.println("Main ended 1.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main ended 2.");
    }
}

class CustomThread implements Runnable{
    @Override
    public void run() {
        System.out.println("start " + Thread.currentThread().getName());
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sum);
        System.out.println("end " + Thread.currentThread().getName());
    }
}