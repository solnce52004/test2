package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockEx {
    public static void main(String[] args) {
        Call call = new Call();

        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        call.mobileCall();
                    }
                }
        );

        Thread t2 = new Thread(
                () -> call.waCall()
        );

        Thread t3 = new Thread(
                call::skypeCall
        );

        t1.start();
        t2.start();
        t3.start();
    }
}

class Call{
    Lock lock = new ReentrantLock();

    void mobileCall() {
        lock.lock();
        try {
            System.out.println("mobile ... ");
            Thread.sleep(3000);
            System.out.println("mobile stop ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void waCall() {
        lock.lock();
        try {
            System.out.println("wa ... ");
            Thread.sleep(5000);
            System.out.println("wa stop ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void skypeCall() {
        lock.lock();
        try {
            System.out.println("skype ... ");
            Thread.sleep(7000);
            System.out.println("skype stop ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

