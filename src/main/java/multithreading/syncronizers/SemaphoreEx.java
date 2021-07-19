package multithreading.syncronizers;

import lombok.extern.java.Log;

import java.util.concurrent.Semaphore;

@Log
public class SemaphoreEx {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (String name : new String[]{"Ivan", "Mary", "Bob", "Jhon"}) {
                new CallBox(name, semaphore);
        }
    }
}

@Log
class CallBox extends Thread {
    private String name;
    private Semaphore semaphore;

    public CallBox(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        this.start();
    }

    @Override
    public void run() {
        try {

            this.semaphore.acquire();

            System.out.println("Call start... " + this.name);
            Thread.sleep(3000);
            System.out.println("Call end " + this.name);
        } catch (InterruptedException e) {
            log.warning("Interrupted!");
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        finally {
           this.semaphore.release();
        }
    }
}
