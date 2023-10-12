package pr;

import java.util.Arrays;

public class Pr3 {
    public static void main(String[] args) {
        System.out.println("_________1");
        System.out.println(replaceVovels("Even if you did this task not by yourself, you have to understand every single line of code."));
        System.out.println("_________2");
        System.out.println(stringTransform("Hello"));
        System.out.println("_________3");
        System.out.println(doesBlockFit(1,3,5,4,5));
        System.out.println("_________4");
        System.out.println(numCheck(243));
        System.out.println("_________5");
        int[] root = {1, -3, 2};
        System.out.println(countRoots(root));
        System.out.println("_________6");
        String[][] sales = {
                {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}
        };
        System.out.println(Arrays.toString(salesData(sales)));
        System.out.println("_________7");
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println("_________8");
        int[] wave = {1, 2, -6, 10, 3};
        System.out.println(waveForm(wave));
        System.out.println("_________9");
        System.out.println(commonVovel("Actions speak louder than words"));
        System.out.println("_________10");
        int[][] arrays = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {5, 5, 5, 5, 5},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}
        };

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
        String letters ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
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
        int[] in = {a, b, c};
        int[] out = {w, h};
        Arrays.sort(in);
        Arrays.sort(out);
        if (in[0] <= out[0])
        {
            return in[1] <= out[1];
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
        int dis = nums[1] * nums[1] - 4 * nums[0] * nums[2];
        if (dis < 0) {
            return 0;
        } else if (dis == 0) {
            if((nums[1] % (nums[0] * 2)) == 0) {
                return 1;
            }
            return 0;
        }
        else {
            int answer = 0;
            for(int i = 1; i * i <= dis; i++) {
                if (i * i == dis) {
                    if (((nums[1] + i) % (nums[0] * 2)) == 0) {
                        answer++;
                    }
                    if (((nums[1] - i) % (nums[0] * 2)) == 0) {
                        answer++;
                    }
                }
            }
            return answer;
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

        for (int i = 1; i < words.length; i++) {
            String currentWord = words[i];
            String previousWord = words[i - 1];
            int currentWordLength = currentWord.length();
            int previousWordLength = previousWord.length();
            char lastCharOfPreviousWord = previousWord.charAt(previousWordLength - 1);
            char firstCharOfCurrentWord = currentWord.charAt(0);

            if (lastCharOfPreviousWord != firstCharOfCurrentWord) {
                return false;
            }
        }

        return true;
    }

    public static boolean waveForm(int[] arr) {
        for(int i=1; i<arr.length - 1; i++) {
            if(!(arr[i] < arr[i-1] && arr[i] < arr[i+1] || arr[i] > arr[i-1] && arr[i] > arr[i+1])) {
                return false;
            }
        }
        return true;
    }

    public static char commonVovel(String str) {
        str = str.toLowerCase();
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int[] vowelCounts = new int[5];
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            for(int j =0; j < vowels.length; j++){
                if(vowels[j]==letter){
                    vowelCounts[j]++;
                }
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

    public static void dataScience(int[][] arrays) {
        int n = arrays.length;

        for (int i = 0; i < n; i++) {
            float sum = 0;
            float count = 0;

            for (int j = 0; j < n; j++) {
                if (j != i) {
                    sum += arrays[j][i];
                    count++;
                }
            }

            float average = sum/count;
            int num = Math.round(average);
            for(int j = 0; j < n; j++){
                if(i == j){
                    arrays[i][j] = num;
                }
            }
        }
    }
}
