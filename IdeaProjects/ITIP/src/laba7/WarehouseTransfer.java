package laba7;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class WarehouseTransfer {
    public static void main(String[] args) {
        List<Integer> weights = new ArrayList<>(List.of(20, 30, 60, 40, 20, 40, 90, 30, 10, 110));

        int numTrip = 3;
        int maxWeightPerTrip = 150;

        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(numTrip);

        List<Worker> workers = new ArrayList<>();
        int[] totalWeight = {0};

        for (int i = 0; i < numTrip; i++) {
            workers.add(new Worker(startSignal, doneSignal, weights, maxWeightPerTrip, i + 1, totalWeight));
        }

        for (Worker worker : workers) {
            worker.start();
        }
        startSignal.countDown();

        try {
            doneSignal.await();
            System.out.println("Последний рейс выполенен. Общий вес перенесенного товара: " + totalWeight[0] + " кг.");
            System.out.println("Работа выполнена.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Worker extends Thread {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    private final List<Integer> weights;
    private final int maxWeightPerTrip;
    private final int workerNum;
    private final int[] totalWeight;

    public Worker(CountDownLatch startSignal, CountDownLatch doneSignal, List<Integer> weights, int maxWeightPerTrip, int workerNum, int[] totalWeight) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
        this.weights = weights;
        this.maxWeightPerTrip = maxWeightPerTrip;
        this.workerNum = workerNum;
        this.totalWeight = totalWeight;
    }

    @Override
    public void run() {
        try {
            startSignal.await();

            int localTotalWeight = 0;
            while (true) {
                int nextWeight;

                synchronized (weights) {
                    if (weights.isEmpty()) {
                        break;
                    }

                    nextWeight = weights.get(0);
                    if (localTotalWeight + nextWeight <= maxWeightPerTrip) {
                        localTotalWeight += nextWeight;
                        weights.remove(0);

                        System.out.println("Рейс " + workerNum + ": товар весом " + nextWeight +
                                " кг. Всего: " + localTotalWeight + " кг.");
                    } else {
                        System.out.println("Рейс " + workerNum + ": успешно выполнен.");
                        break;
                    }
                }
            }

            synchronized (totalWeight) {
                totalWeight[0] += localTotalWeight;
            }
            doneSignal.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
