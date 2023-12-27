package laba7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MatrixMaxFinder {

    public static int findMax(int[][] matrix) {
        int numThreads = matrix.length;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < numThreads; i++) {
            int start = i * cols;
            int end = Math.min((i + 1) * cols, rows * cols);
            Runnable worker = new MaxFinderWorker(matrix, start, end);
            executor.execute(worker);
        }
        executor.shutdown();
        try {
            while (!executor.isTerminated()) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return MaxFinderWorker.getMaxElement();
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int result = findMax(matrix);
        System.out.println(result);
    }
}

class MaxFinderWorker implements Runnable {
    private final int[][] matrix;
    private final int start;
    private final int end;
    private static int maxElement = Integer.MIN_VALUE;
    private static final Object lock = new Object();
    public MaxFinderWorker(int[][] matrix, int start, int end) {
        this.matrix = matrix;
        this.start = start;
        this.end = end;
    }
    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            int row = i / matrix[0].length;
            int col = i % matrix[0].length;

            int currentElement = matrix[row][col];

            synchronized (lock) {
                if (currentElement > maxElement) {
                    maxElement = currentElement;
                }
            }
        }
    }
    public static int getMaxElement() {
        return maxElement;
    }
}