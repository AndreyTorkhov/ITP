package laba6;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class SalesTracker {
    private ConcurrentHashMap<String, Integer> salesMap;

    public SalesTracker() {
        this.salesMap = new ConcurrentHashMap<>();
    }

    public void addSale(String product, int quantity) {
        salesMap.merge(product, quantity, Integer::sum);
    }

    public void displaySales() {
        System.out.println("Список продаж:");
        for (ConcurrentHashMap.Entry<String, Integer> entry : salesMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " ш.");
        }
    }

    public int getTotalSales() {
        return salesMap.values().stream().mapToInt(Integer::intValue).sum();
    }

    public String getMostPopularProduct() {
        return salesMap.entrySet().stream()
                .max(ConcurrentHashMap.Entry.comparingByValue())
                .map(ConcurrentHashMap.Entry::getKey)
                .orElse("Продаж еще нет");
    }

    public static void main(String[] args) {
        SalesTracker salesTracker = new SalesTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите название продукта (или 'exit' чтобы закончить): ");
            String product = scanner.nextLine().trim();

            if (product.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Введите количество: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            salesTracker.addSale(product, quantity);
        }

        System.out.println("Общие продажи: " + salesTracker.getTotalSales());
        System.out.println("Самый продаваемый продукт: " + salesTracker.getMostPopularProduct());

        salesTracker.displaySales();

        scanner.close();
    }
}