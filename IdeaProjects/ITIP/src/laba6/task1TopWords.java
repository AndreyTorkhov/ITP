package laba6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class task1TopWords {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\AT\\Desktop\\topWord.txt";
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Map<String, Integer> wordCountMap = new HashMap<>();

        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        scanner.close();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCountMap.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        System.out.println("Toп 10 слов:");
        int count = 0;
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " раз");
            count++;
            if (count == 10) {
                break;
            }
        }
    }
}
