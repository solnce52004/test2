package multithreading;

public class WaitNotifyEx {
    public static void main(String[] args) {
        Market market = new Market();

        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);

        Thread prodThread = new Thread(producer);
        Thread consThread = new Thread(consumer);

        prodThread.start();
        consThread.start();
    }

}

class Market {
    private final Object lock = new Object();
    private int breadCount = 0;

     void getBread() {
         synchronized (lock){
             while (breadCount < 1) {
                 try {
                     System.out.println("Consumer get - wait: " + breadCount);
                     lock.wait();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }

             lock.notify();
             breadCount--;
             System.out.println("Consumer get - notify: " + breadCount);
         }
    }

     void addBread() {
         synchronized (lock){
             while (breadCount >= 5) {
                 try {
                     System.out.println("Producer put - wait: " + breadCount);
                     lock.wait();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }

             lock.notify();
             breadCount++;
             System.out.println("Producer put - notify: " + breadCount);
         }
    }
}

class Producer implements Runnable {
    Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.addBread();
        }
    }
}

class Consumer implements Runnable {
    Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getBread();
        }
    }
}