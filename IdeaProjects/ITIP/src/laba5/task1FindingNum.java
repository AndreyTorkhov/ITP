package laba5;

import java.util.regex.*;

public class task1FindingNum {
    public static void main(String[] args) {
        String text = "These 5 products are priced at $19.99.";

        try {
            Pattern pattern = Pattern.compile("\\b(\\d+(\\.\\d+)?)\\b");
            Matcher matcher = pattern.matcher(text);

            boolean found = false;

            while (matcher.find()) {
                System.out.println(matcher.group());
                found = true;
            }

            if (!found) {
                System.out.println("Числа не найдены в тексте.");
            }

        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в регулярном выражении: " + e.getMessage());
        }
    }
}
