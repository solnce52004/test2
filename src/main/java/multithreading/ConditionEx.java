package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionEx {
    public static void main(String[] args) throws InterruptedException {
        MessageCond m = new MessageCond();
        Thread[] arr = {
                new Thread(new MyReaderCond(m)),
                new Thread(new MyWriterCond(m))
        };

        for (Thread t : arr) {
            t.start();
        }
        Thread.sleep(10000);
        for (Thread t : arr) {
            t.interrupt();
        }

        System.out.println("Out main..");
    }
}

class MessageCond {
    private String message;
    private final Lock lock = new ReentrantLock();
    private final Condition reader = lock.newCondition();
    private final Condition writer = lock.newCondition();

    public String getMessage() throws InterruptedException {
        lock.lock();
        try {
            while (this.message == null) {
                reader.await();
            }
            String res = message;
            message = null;
            writer.signal();
            return res;
        } finally {
            lock.unlock();
        }
    }

    public void setMessage(String message) throws InterruptedException {
        lock.lock();
        try {
            while (this.message != null) {
                writer.await();
            }
            this.message = message;
            reader.signal();
        } finally {
            lock.unlock();
        }
    }
}

class MyReaderCond implements Runnable {

    private MessageCond m;

    public MyReaderCond(MessageCond m) {
        this.m = m;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Read " + m.getMessage());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

class MyWriterCond implements Runnable {
    private MessageCond m;

    public MyWriterCond(MessageCond m) {
        this.m = m;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = String.valueOf(Math.random());
                m.setMessage(message);
                System.out.println("Write " + message);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
