package laba5;


import java.util.regex.*;

public class task5WordFinder {
    public static void main(String[] args) {
        String text = "Jaje fpjpw jkjpw jlhscbz qelf lknkne jhqebnn";

        String letter = "j";

        try {
            findWordsStartingWithLetter(text, letter);
        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в регулярном выражении: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private static void findWordsStartingWithLetter(String text, String letter) {
        if (letter.length() != 1) {
            throw new IllegalArgumentException("Буква должна быть только одной.");
        }

        String regex = "(?i)\\b" + letter + "\\w*\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Слова, начинающиеся с буквы " + letter + ":");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}





