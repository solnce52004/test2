package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutorServiceEx {
    public static void main(String[] args) {
//        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

//        service.scheduleAtFixedRate(new MyThread(), 4, 2, TimeUnit.SECONDS);
//        service.scheduleWithFixedDelay(new MyThread(), 4, 5, TimeUnit.SECONDS);

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            service.execute(new MyThread());
        }


        try {
            Thread.sleep(30_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.shutdown();
        System.out.println("Main ended.");
    }
}

class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start");
        double sum = 0;
        for (double i = 0; i < 1000_000_000; i++) {
            sum += Math.sqrt(i);
        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName() + " end " + sum);
    }
}
