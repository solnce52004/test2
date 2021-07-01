package multithreading;

import java.util.concurrent.*;

public class CallableEx {
    public static void main(String[] args) {

        ExecutorService ex = Executors.newSingleThreadExecutor();
        Future<Integer> submit = ex.submit(new FactorialThread(-5));
        try {
            Integer future = submit.get();
            System.out.println(future);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("exp... " + e.getMessage());//
        } finally {
            ex.shutdown();
        }
    }
}

class FactorialThread implements Callable<Integer> {
    private int f;

    public FactorialThread(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        if (this.f < 1) {
            System.out.println("<1");
            throw new Exception();
        }
        int res = 1;
        for (int i = 1; i <= f; i++) {
            res *= i;
        }
//        System.out.println(res);
        return res;
    }
}