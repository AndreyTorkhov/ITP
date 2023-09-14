package pr;

import java.util.Arrays;
import java.util.Random;

public class Pr2 {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println(duplicateChars("Donald"));
        System.out.println("_________");
        System.out.println(getInitials("Ryan Gosling"));
        System.out.println("_________");
        int[] deo = {44, 32, 86, 19};
        System.out.println(differenceEvenOdd(deo));
        System.out.println("_________");
        float[] eta = {1,2,3,4,5};
        System.out.println(equalToAvg(eta));
        System.out.println("_________");
        int[] im = {3,3,-2, 408, 3, 31};
        System.out.println(Arrays.toString(indexMult(im)));
        System.out.println("_________");
        System.out.println(reverse("qwert etty"));
        System.out.println("_________");
        System.out.println(tribonacci(11));
        System.out.println("_________");
        System.out.println(pseudoHash(8));
        System.out.println("_________");
        System.out.println(botHelper("Hello, I’m under the water, please help me"));
        System.out.println("_________");
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println("_________");
    }
    public static boolean duplicateChars(String str){
        str = str.toLowerCase();
        boolean[] mas = new boolean[256];
        for (int i = 0; i < str.length();i++) {
            int val = str.charAt(i);
            if (mas[val]) {
                return true;
            }
            mas[val] = true;
        }
        return false;
    }
    public static String getInitials(String str){
        String[] names = str.split(" ");
        StringBuilder initials = new StringBuilder();
        for(String i : names){
            if(!i.isEmpty()){
                char let = i.charAt(0);
                initials.append(let);
            }
        }
        return initials.toString();
    }
    public static int differenceEvenOdd(int[] nums){
        int sumEven = 0;
        int sumOdd = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                sumEven += num;
            } else {
                sumOdd += num;
            }
        }
        return sumEven - sumOdd;
    }
    public static boolean equalToAvg(float[] nums){
        if (nums.length == 0) {
            return false;
        }
        float sum = 0;
        for (float num : nums) {
            sum += num;
        }
        float average = sum / nums.length;
        for (float num : nums) {
            if (num == average) {
                return true;
            }
        }
        return false;
    }
    public static int[] indexMult(int[] nums){
        int[] res = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            res[i] = nums[i] * i;
        }
        return res;
    }
    public static String reverse(String str){
        char[] mas = str.toCharArray();
        int s = 0;
        int e = str.length()-1;
        while(s<e){
            char x = mas[s];
            mas[s] = mas[e];
            mas[e] = x;
            s++;
            e--;
        }
        String result = new String(mas);
        return result;
    }
    public static int tribonacci(int n){
        int[] mas = new int[n];
        for(int i = 3; i<n;i++){
            mas[0]=0;
            mas[1]=0;
            mas[2]=1;
            mas[i] = mas[i-1] + mas[i-2] + mas[i-3];
        }
        return mas[mas.length-1];
    }
    public static String pseudoHash(int n){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random(); //генератор
        StringBuilder hash = new StringBuilder();
        for(int i = 0;i<n;i++){
            int randomIndex = random.nextInt(characters.length()); //сканер
            char randomChar = characters.charAt(randomIndex);
            hash.append(randomChar);
        }
        return hash.toString();
    }
    public static String botHelper(String str){
        str = str.replaceAll(",", " ").toLowerCase();
        String[] words = str.split(" ");
        String word = "help";
        for(int i = 0; i<words.length;i++){
            if(words[i].equals(word)){
                return "Calling for a staff member";
            }
        }
        return "Keep waiting";
    }
    public static boolean isAnagram(String str1, String str2){
        str1 = str1.toLowerCase().replace(" ", "");
        str2 = str2.toLowerCase().replace(" ", "");
        if(str1.length()!=str2.length()){
            return false;
        }

        char[] s1Char = str1.toCharArray();
        char[] s2Char = str2.toCharArray();
        Arrays.sort(s2Char);
        Arrays.sort(s1Char);
        return Arrays.equals(s1Char, s2Char);
    }
}
