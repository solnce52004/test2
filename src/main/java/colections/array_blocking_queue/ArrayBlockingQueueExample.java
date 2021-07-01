package colections.array_blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueExample {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);

        //Producer
        new Thread(
                () -> {
                    int i = 0;
                    while (true){
                            try {
                                queue.put(++i);
                                System.out.println("Producer " + i + " " + queue);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                    }
                }
        )
        .start();

        //Consumer
        new Thread(
                () -> {
                    while (true){
                        try {
                            Thread.sleep(5000);
                            Integer j = queue.take();
                            System.out.println("Consumer " + j + " " + queue);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        )
        .start();
    }
}
