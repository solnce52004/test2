package multithreading;

public class MessageEx {
    public static void main(String[] args) throws InterruptedException {
        Message m = new Message();
        Thread[] arr = {
                new MyReader(m),
                new MyWriter(m)
        };

        for (Thread t : arr) {
            t.start();
        }

        Thread.sleep(1000);
        for (Thread t : arr) {
            t.interrupt();
        }

        System.out.println("Out main..");
    }
}

class Message {
    private String message;

    public synchronized String getMessage() throws InterruptedException {
        while (this.message == null) {
            this.wait();
        }
        String res = message;
        message = null;
        this.notifyAll();
        return res;
    }

    public synchronized void setMessage(String message) throws InterruptedException {
        while (this.message != null) {
            this.wait();
        }
        this.message = message;
        this.notifyAll();
    }
}

class MyReader extends Thread {

    private Message m;

    public MyReader(Message m) {
        this.m = m;
    }

    @Override
    public void run() {

        while (true) {
            if(isInterrupted()){
                System.out.println("r interrupted");
                return;
            }
            try {
                System.out.println("Read " + m.getMessage());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

class MyWriter extends Thread {
    private Message m;

    public MyWriter(Message m) {
        this.m = m;
    }

    @Override
    public void run() {
        while (true) {
            if(isInterrupted()){
                System.out.println("w interrupted");
                return;
            }

            try {
                String message = String.valueOf(Math.random());
                m.setMessage(message);
                System.out.println("Write " + message);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                //прервали из другого потока во время сна
                System.out.println("w throw interrupted");
                return;
            }
        }
    }
}