package multithreading;

public class JoinEx {
    public static void main(String[] args) {
        Thread t = new Thread(new MyThr());
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        System.out.println("Main out... "
                + Thread.currentThread().getName());
    }
}

class MyThr implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
//                System.out.println(
//                        String.format("i=%d Thread: %s id=%d",
//                                i,
//                                Thread.currentThread().getName(),
//                                Thread.currentThread().getId()
//                                )
//                );
                System.out.println(
                        new StringBuffer(String.format("i=%d Thread: %s id=%d",
                                i,
                                Thread.currentThread().getName(),
                                Thread.currentThread().getId()
                        ))
                );
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
