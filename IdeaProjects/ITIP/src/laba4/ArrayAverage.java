package laba4;

public class ArrayAverage {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4", "ф"};
        int sum = 0;
        int index = 1;
        try {
            if (arr.length == 0) {
                throw new ArithmeticException("Массив пустой");
            }
            if (index < 0 || index >= arr.length) {
                throw new ArrayIndexOutOfBoundsException("Индекс за пределами массива");
            }
            for (int i = 0;i<arr.length;i++) {
                sum += Integer.valueOf(arr[i]);
            }
            double average = (double) sum / arr.length;
            System.out.println("Среднее арифметическое: " + average);
        } catch (ArithmeticException e) {
            System.err.println("Деление на ноль: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Выход за границы массива: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Неверные данные: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }
}