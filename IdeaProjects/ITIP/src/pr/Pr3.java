package pr;

import java.util.Arrays;

public class Pr3 {
    public static void main(String[] args) {
        System.out.println("_________");
        System.out.println(replaceVovels("Even if you did this task not by yourself, you have to understand every single line of code."));
        System.out.println("_________");
        System.out.println(stringTransform("Hello"));
        System.out.println("_________");
        System.out.println(doesBlockFit(1,2,2,1,1));
        System.out.println("_________");
        System.out.println(numCheck(243));
        System.out.println("_________");
        int[] root = {1, -3, 2};
        System.out.println(countRoots(root));
        System.out.println("_________");
        String[][] sales = {
                {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}
        };
        System.out.println(Arrays.toString(salesData(sales)));
        System.out.println("_________");
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println("_________");
        int[] wave = {1, 2, -6, 10, 3};
        System.out.println(waveForm(wave));
        System.out.println("_________");
        System.out.println(commonVovel("Actions speak louder than words"));
        System.out.println("_________");
        int[][] arrays = {{6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}};

        dataScience(arrays);

        for (int[] array : arrays) {
            System.out.println(Arrays.toString(array));
        }
    }
    public static String replaceVovels(String str){
        String letters = "AEIOUYaeiouy";
        for(int i = 0;i<letters.length()-1;i++){
            String change = "";
            change += letters.charAt(i);
            str = str.replaceAll(change,"*" );
        }
        return str;
    }

    public static String stringTransform(String str){
        String letters = "BCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for(int i = 0;i<letters.length()-1;i++){
            String change = "";
            change += letters.charAt(i);
            change += letters.charAt(i);
            String dub = "";
            dub += letters.charAt(i);
            str = str.replaceAll(change,"Duble" + dub.toUpperCase() );
        }
        return str;
    }

    public static boolean doesBlockFit(int a, int b, int c, int w, int h){
        if ((a<=w && b<=h) || (b<=w && a<=h) || (a<=w && c<=h) || (c<=w && a<=h) || (b<=w && c<=h) || (c<=w && b<=h)){
            return true;
        }
        return false;
    }

    public static boolean numCheck(int num){
        int sumSquar = 0;
        int startNum = num;
        int lastChar;
        while(num!=0){
            lastChar = num%10;
            sumSquar += lastChar * lastChar;
            num = num / 10;
        }
        if(startNum % 2 == sumSquar % 2){
            return true;
        }
        return false;
    }

    public static int countRoots(int[] nums){
        if (nums.length != 3) {
            return -1;
        }
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        int discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return 0;
        } else if (discriminant == 0) {
            return 1;
        } else {
            return 2;
        }
    }

    public static String[] salesData(String [][] sales){
        int maxSales = 0;
        String sale = "";
        for(int i =0; i < sales.length;i++){
            if(maxSales <= sales[i].length){
                maxSales = sales[i].length;
            }
        }
        for(int i = 0; i < sales.length;i++){
            if(maxSales == sales[i].length){
                sale += sales[i][0] + " ";
            }
        }
        return sale.split(" ");
    }

    public static boolean validSplit(String str) {
        if (str == null) {
            return false;
        }
        str = str.toLowerCase().replaceAll(",", "");
        String[] words = str.split(" ");

        if (words.length <= 1) {
            return false; // В предложении должно быть больше одного слова
        }

        for (int i = 1; i < words.length; i++) {
            String currentWord = words[i];
            String previousWord = words[i - 1];
            int currentWordLength = currentWord.length();
            int previousWordLength = previousWord.length();

            if (currentWordLength == 0 || previousWordLength == 0) {
                return false; // Ни одно слово не должно быть пустым
            }

            char lastCharOfPreviousWord = previousWord.charAt(previousWordLength - 1);
            char firstCharOfCurrentWord = currentWord.charAt(0);

            if (Character.toLowerCase(lastCharOfPreviousWord) != Character.toLowerCase(firstCharOfCurrentWord)) {
                return false;
            }
        }

        return true;
    }

    public static boolean waveForm(int[] arr) { // не сошлось с ответом
        if (arr.length < 3) {
            return false;
        }
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            if ((curr - prev) > 0 && (i + 1 < arr.length)) {
                int next = arr[i + 1];
                if ((next - curr) < (curr - prev)) {
                    return false;
                }
            } else if ((curr - prev) < 0 && (i > 0)) {
                int prevPrev = arr[i - 1];
                if ((prev - prevPrev) > (curr - prev)) {
                    return false;
                }
            }
            prev = curr;
        }
        return true;
    }

    public static char commonVovel(String str) {
        String lowercaseSentence = str.toLowerCase();
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int[] vowelCounts = new int[5];
        for (int i = 0; i < lowercaseSentence.length(); i++) {
            char letter = lowercaseSentence.charAt(i);
            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                int index = letter == 'a' ? 0 : letter == 'e' ? 1 : letter == 'i' ? 2 : letter == 'o' ? 3 : 4;
                vowelCounts[index]++;
            }
        }
        int maxCountIndex = 0;
        for (int i = 1; i < vowelCounts.length; i++) {
            if (vowelCounts[i] > vowelCounts[maxCountIndex]) {
                maxCountIndex = i;
            }
        }
        return vowels[maxCountIndex];
    }

    public static void dataScience(int[][] arrays) { // не пон
        int n = arrays.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (j != i) {
                    sum += arrays[j][i];
                    count++;
                }
            }

            int average = sum / count;
            arrays[i][n - 1] = average;
        }
    }

}
