package laba7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArraySumCalculator {
    private static final int numThreads = 4;

    public static int sumArray(int[] array) {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        int arrayLength = array.length;
        int chunkSize = (int) Math.ceil((double) arrayLength / numThreads);

        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = Math.min((i + 1) * chunkSize, arrayLength);

            Runnable worker = new SumWorker(array, start, end);
            executor.execute(worker);
        }
        executor.shutdown();

        try {
            while (!executor.isTerminated()) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SumWorker.getTotalSum();
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int result = sumArray(array);
        System.out.println(result);
    }
}

class SumWorker implements Runnable {
    private final int[] array;
    private final int start;
    private final int end;
    private static int totalSum = 0;
    private static final Object lock = new Object();

    public SumWorker(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        int localSum = 0;
        for (int i = start; i < end; i++) {
            localSum += array[i];
        }
        synchronized (lock) {
            totalSum += localSum;
        }
    }

    public static int getTotalSum() {
        return totalSum;
    }
}
