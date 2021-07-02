package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PartialSumEx {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Future<Double>> futuresList = new ArrayList<>();

//        double dividedTo = 1_000_000_000 / 100_000_000;

        for (double i = 0; i < 10; i++) {
            futuresList.add(
                    executorService.submit(
                            new PartialSum(
                                    100_000_000 * i + 1,
                                    100_000_000 * (i + 1)
                            )
                    )
            );

        }



        double totalSum = 0;
        for (Future<Double> future : futuresList) {
            double futureRes = 0;
            try {
                futureRes = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            totalSum += futureRes;
        }
        executorService.shutdown();
        System.out.println(totalSum);
    }
}

class PartialSum implements Callable<Double> {
    private double from;
    private double to;

    public PartialSum(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Double call() throws Exception {
        double sum = 0;
        for (double i = from; i < to; i++) {
            sum = from;
            sum += i;
        }
        return sum;
    }

}